/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria;

import net.javaguides.concesionaria.herramientas.GestorBuscador;
import net.javaguides.hibernate.model.Auto;

public class GestorVenta {

    Venta pantallaVenta;
    Auto autoSeleccionado;

    public GestorVenta() {
        pantallaVenta = new Venta();
        pantallaVenta.conocerGestor(this);
    }

    void mostrarPantalla(boolean b) {
        pantallaVenta.setVisible(true);
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
