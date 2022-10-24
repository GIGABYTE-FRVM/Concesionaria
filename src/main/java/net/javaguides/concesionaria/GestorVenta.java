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
import java.util.stream.Stream;
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.model.Venta;

public class GestorVenta {

    VistaVenta pantallaVenta;
    Auto autoSeleccionado;
    List<Personal> listaVendedores;
    GestorPersonalABMC gestorVendedor;
    GestorHibernate gestorHibernate;
    Integer ultimoIdVenta;
    
    public GestorVenta() {
        gestorVendedor = new GestorPersonalABMC();
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaVenta = new VistaVenta(this);
        pantallaVenta.conocerGestor(this);
        mostrarPantalla(true);
    }

    void mostrarPantalla(boolean b) {
        pantallaVenta.setVisible(b);
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
        System.out.println(date);
        return date;
    }

    public String getHoraActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hour = dateFormat.format(Calendar.getInstance().getTime());
        System.out.println(hour);
        return hour;
    }
    
    public void mostrarIdUltimaVenta() {
        this.conocerUltimoIdVenta();
    }
    
    public Integer conocerUltimoIdVenta() {
        List<Venta> listadoVentas = gestorHibernate.getAllObjects("Venta");
        if(listadoVentas.isEmpty()) {
            ultimoIdVenta = 1;
        }else {
            Optional<Integer> maximoId = listadoVentas.stream()
                    .map(Venta::getId)
                    .max(Integer::compare);
            
            ultimoIdVenta = maximoId.get();
        }
        
        return ultimoIdVenta + 1;
    }
    public Cliente buscarClientePorDni(String dniCliente) {
        Cliente cliente = gestorHibernate.getObjectById("Cliente as cliente WHERE cliente.documento LIKE '%" + dniCliente + "%'", 0);
        System.out.println(cliente);
        return cliente;
    }

    void buscarAuto() {
        GestorBuscador gestorBuscador =  new GestorBuscador();
        gestorBuscador.conocerGestorAuto(this);
    }

    public Auto getAutoSeleccionado() {
        return autoSeleccionado;
    }

    public void setAutoSeleccionado(Auto autoSeleccionado) {
        this.autoSeleccionado = autoSeleccionado;
        pantallaVenta.setAutoSeleccionado(autoSeleccionado);
    }
    
    
    
}
