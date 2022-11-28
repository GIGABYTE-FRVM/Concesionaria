/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria;

import java.awt.Color;
import net.javaguides.concesionaria.herramientas.GestorBuscador;
import net.javaguides.hibernate.model.Auto;
import java.util.List;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Personal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.model.Venta;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JTextField;

public class GestorVenta {



    VistaVenta pantallaVenta;
    ConsultaVenta consultaVentas;
    Auto autoSeleccionado;
    List<Personal> listaVendedores;
    List<Venta> listadoVentas;
    GestorPersonalABMC gestorVendedor;
    GestorHibernate gestorHibernate;
    Integer ultimoIdVenta;
    Cliente cliente;
    double totalVenta;
    Color disableColor = new Color(153,153,153);
    NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();

    public GestorVenta() {
        gestorVendedor = new GestorPersonalABMC();
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaVenta = new VistaVenta(this);
        pantallaVenta.conocerGestor(this);
        consultaVentas = new ConsultaVenta(this);
        consultaVentas.conocerGestor(this);
        mostrarPantalla(true);
    }

    public void mostrarPantalla(boolean b) {
        pantallaVenta.setVisible(b);
    }

    void mostrarConsultasVentas(boolean b) {
        consultaVentas.setVisible(b);
    }

    public void conocerVendedores() {
        if (!(listaVendedores == null)) {
            listaVendedores.clear();
        }
        listaVendedores = gestorVendedor.conocerListVendedores();
    }

    public String getFechaActual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String date = dateFormat.format(Calendar.getInstance().getTime());
        return date;
    }

    public String getHoraActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hour = dateFormat.format(Calendar.getInstance().getTime());
        return hour;
    }

    public void mostrarIdUltimaVenta() {
        this.conocerUltimoIdVenta();
    }

    public Integer conocerUltimoIdVenta() {
        conocerVentas();
        if (listadoVentas.isEmpty()) {
            ultimoIdVenta = 0;
        } else {
            Optional<Integer> maximoId = listadoVentas.stream()
                    .map(Venta::getId)
                    .max(Integer::compare);

            ultimoIdVenta = maximoId.get();
        }

        return ultimoIdVenta + 1;
    }

    public Cliente buscarClientePorDni(String dniCliente) {
        if (!(dniCliente.equals(""))) {
            cliente = gestorHibernate.getObjectById("Cliente as cliente WHERE cliente.documento LIKE '%" + dniCliente + "%'", 0);
            return cliente;
        } else {
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN DNI");
            return null;
        }
    }

    void buscarAuto() {
        GestorBuscador gestorBuscador = new GestorBuscador();
        gestorBuscador.conocerGestorAuto(this);
    }

    public Auto getAutoSeleccionado() {
        return autoSeleccionado;
    }

    public void setAutoSeleccionado(Auto autoSeleccionado) {
        this.autoSeleccionado = autoSeleccionado;
        pantallaVenta.setAutoSeleccionado(autoSeleccionado);
        pantallaVenta.setTxtCombustible(autoSeleccionado.getCombustible().toString());
        pantallaVenta.setTxtColor(autoSeleccionado.getColor());
        pantallaVenta.setTxtCosto(formatoImporte.format(autoSeleccionado.getPrecio()));
        pantallaVenta.setTxtImpuesto(Double.toString(autoSeleccionado.getMarca().getPais().getRegion().getPorcentaje()));
        calcularTotal();
    }

    public double calcularTotal() {
        int cantidad = pantallaVenta.getCantidad();
        double costo = autoSeleccionado.getPrecio();
        double impuesto = autoSeleccionado.getMarca().getPais().getRegion().getPorcentaje();
        System.out.println("cantidad:" + cantidad);
        System.out.println("costo: " + costo);
        System.out.println("impuesto:" + impuesto);
        totalVenta = cantidad * costo + ((cantidad * costo) * impuesto) / 100;
        pantallaVenta.setTxtTotal(formatoImporte.format(totalVenta));
        return totalVenta;
    }

    public void registrarVenta() {
        Venta ventaObject = new Venta();
        ventaObject.setAuto(autoSeleccionado);
        ventaObject.setCantidad(pantallaVenta.getCantidad());
        ventaObject.setCliente(cliente);
        ventaObject.setFecha(getFechaActual());
        ventaObject.setHora(getHoraActual());
        ventaObject.setImpuesto(autoSeleccionado.getMarca().getPais().getRegion().getPorcentaje());
        ventaObject.setPrecio(autoSeleccionado.getPrecio());
        ventaObject.setTotal(totalVenta);
        ventaObject.setVendedor(pantallaVenta.getVendedor());
        ventaObject.setGanancia((autoSeleccionado.getPrecio() - autoSeleccionado.getPrecioCosto()) * pantallaVenta.getCantidad());
        if (esValido(ventaObject)) {
            gestorHibernate.saveObject(ventaObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            cliente.setEsCliente(1);
            gestorHibernate.updateObject(cliente);
            pantallaVenta.limpiarEntradas();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public DefaultTableModel mostrarDatos(List<Venta> listadoVentas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Cliente");
        modelo.addColumn("Auto");
        modelo.addColumn("Precio");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");
        modelo.addColumn("Ganancia");
        Object data[] = new Object[11];
        try {
            for (Venta venta : listadoVentas) {
                data[0] = venta;
                data[1] = venta.getFecha();
                data[2] = venta.getHora();
                data[3] = venta.getVendedor();
                data[4] = venta.getCliente();
                data[5] = venta.getAuto().toStringCompleto();
                data[6] = venta.getPrecio();
                data[7] = venta.getImpuesto();
                data[8] = venta.getCantidad();
                data[9] = venta.getTotal();
                data[10] = venta.getGanancia();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos: " + e);
        }
        return modelo;
    }

    public List<Venta> conocerVentas() {
        listadoVentas = gestorHibernate.getAllObjects("Venta");
        return listadoVentas;
    }

    public List<Venta> conocerVentasLimit(int page, int limit) {
        listadoVentas = gestorHibernate.getObjectsLimit("Venta", page, limit);
        return listadoVentas;
    }

    private boolean esValido(Venta ventaObject) {
        return autoSeleccionado != null;
    }

    public void actualizarTabla() {
        //consultaVentas.actualizarTabla();
    }

    public List<Venta> conocerVentasFiltradas(int page, int limit) {
        String tipo = consultaVentas.getTipo();
        String consulta = consultaVentas.getConsulta();
        String fechaDesdeHasta;
        if (consultaVentas.getFiltroConFechas()) {
            String fechaDesde = consultaVentas.getFechaDesde();
            String fechaHasta = consultaVentas.getFechaHasta();
            fechaDesdeHasta = "AND venta.fecha BETWEEN '" + fechaDesde + "' AND '" + fechaHasta + "'";
        } else {
            fechaDesdeHasta = "";
        }
        List<Venta> ventasFiltradas = null;
        switch (tipo) {
            case "Cliente" ->
                ventasFiltradas = gestorHibernate.getObjectsLimit("Venta as venta WHERE (venta.cliente.nombre  LIKE '%" + consulta + "%' OR venta.cliente.apellido  LIKE '%" + consulta + "%')" + fechaDesdeHasta, page, limit);
            case "Empleado" ->
                ventasFiltradas = gestorHibernate.getObjectsLimit("Venta as venta WHERE (venta.vendedor.nombre  LIKE '%" + consulta + "%' OR venta.vendedor.apellido  LIKE '%" + consulta + "%') " + fechaDesdeHasta, page, limit);
            case "Auto" ->
                ventasFiltradas = gestorHibernate.getObjectsLimit("Venta as venta WHERE (venta.auto.marca.nombre LIKE '%" + consulta + "%' OR venta.auto.marca.nombre LIKE '%" + consulta + "%') "+ fechaDesdeHasta, page, limit);
        }
        return ventasFiltradas;
    }

    public List<Venta> conocerVentasFiltradas() {
        String tipo = consultaVentas.getTipo();
        String consulta = consultaVentas.getConsulta();
        String fechaDesdeHasta;
        if (consultaVentas.getFiltroConFechas()) {
            String fechaDesde = consultaVentas.getFechaDesde();
            String fechaHasta = consultaVentas.getFechaHasta();
            fechaDesdeHasta = "AND venta.fecha BETWEEN '" + fechaDesde + "' AND '" + fechaHasta + "'";
        } else {
            fechaDesdeHasta = "";
        }
        List<Venta> ventasFiltradas = null;
        switch (tipo) {
            case "Cliente" ->
                ventasFiltradas = gestorHibernate.getAllObjects("Venta as venta WHERE (venta.cliente.nombre  LIKE '%" + consulta + "%' OR venta.cliente.apellido  LIKE '%" + consulta + "%') "+ fechaDesdeHasta);
            case "Empleado" ->
                ventasFiltradas = gestorHibernate.getAllObjects("Venta as venta WHERE (venta.vendedor.nombre  LIKE '%" + consulta + "%' OR venta.vendedor.apellido  LIKE '%" + consulta + "%') "+ fechaDesdeHasta);
            case "Auto" ->
                ventasFiltradas = gestorHibernate.getAllObjects("Venta as venta WHERE (venta.auto.marca.nombre LIKE '%" + consulta + "%' OR venta.auto.modelo.nombre LIKE '%" + consulta + "%') "+ fechaDesdeHasta);
        }
        return ventasFiltradas;
    }
        
        public VistaVenta getPantallaVenta() {
        return pantallaVenta;
    }

    public void setPantallaVenta(VistaVenta pantallaVenta) {
        this.pantallaVenta = pantallaVenta;
    }
    
    
    public boolean validarCamposVacios(JTextField txtDNI, JTextField txtAutoSeleccionado) {
        if(txtDNI.getForeground().equals(disableColor) || txtAutoSeleccionado.getForeground().equals(disableColor)) {
            return false;
        }else {
            return true;
        }
    }
    
    public boolean validarDNI(String DNI) {
        for (int i = 0; i < DNI.length(); i++)
        {
            char c = DNI.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        if(DNI.isBlank()) {
            return false;
        }
        return true;
    }
}
