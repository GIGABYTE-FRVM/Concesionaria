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
import net.javaguides.hibernate.model.Cliente;

public class GestorVenta {

    Venta pantallaVenta;
    Auto autoSeleccionado;
    List<Personal> listaVendedores;
    GestorPersonalABMC gestorVendedor;
    GestorHibernate gestorHibernate;
    Integer ultimoIdVenta;
    
    public GestorVenta() {
        pantallaVenta = new Venta(this);
        pantallaVenta.conocerGestor(this);
        gestorVendedor = new GestorPersonalABMC();
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaVenta = new Venta(this);
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
        ultimoIdVenta = gestorHibernate.getLatestIdObject("venta");
        return ultimoIdVenta;
    }

    public Cliente buscarClientePorDni(String dniCliente) {
        Cliente cliente = gestorHibernate.getClienteByDni("cliente", Integer.parseInt(dniCliente));
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
