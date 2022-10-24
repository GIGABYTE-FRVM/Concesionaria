/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria;

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

public class GestorVenta {

    VistaVenta pantallaVenta;
    ConsultaVentas consultaVentas;
    Auto autoSeleccionado;
    List<Personal> listaVendedores;
    List<Venta> listadoVentas;
    GestorPersonalABMC gestorVendedor;
    GestorHibernate gestorHibernate;
    Integer ultimoIdVenta;
    Cliente cliente;
    double totalVenta;

    public GestorVenta() {
        gestorVendedor = new GestorPersonalABMC();
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaVenta = new VistaVenta(this);
        pantallaVenta.conocerGestor(this);
        consultaVentas = new ConsultaVentas(this);
        consultaVentas.conocerGestor(this);
        mostrarPantalla(true);
    }

    void mostrarPantalla(boolean b) {
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
        cliente = gestorHibernate.getObjectById("Cliente as cliente WHERE cliente.documento LIKE '%" + dniCliente + "%'", 0);
        return cliente;
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
        pantallaVenta.setTxtCosto(Double.toString(autoSeleccionado.getPrecio()));
        pantallaVenta.setTxtImpuesto(Double.toString(autoSeleccionado.getMarca().getPais().getRegion().getPorcentaje()));
        calcularTotal();
    }

    public void calcularTotal() {
        int cantidad = pantallaVenta.getCantidad();
        double costo = autoSeleccionado.getPrecio();
        double impuesto = autoSeleccionado.getMarca().getPais().getRegion().getPorcentaje();
        totalVenta = cantidad * costo + ((cantidad * costo) * impuesto) / 100;
        pantallaVenta.setTxtTotal(Double.toString(totalVenta));
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
        if (esValido(ventaObject)) {
            gestorHibernate.saveObject(ventaObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaVenta.limpiarEntradas();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public DefaultTableModel mostrarDatos() {
        conocerVentas();
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

    private void conocerVentas() {
        listadoVentas = gestorHibernate.getAllObjects("Venta");
    }

    private boolean esValido(Venta ventaObject) {
        return autoSeleccionado != null;
    }
    public void actualizarTabla(){
        consultaVentas.actualizarTabla();
    }



}
