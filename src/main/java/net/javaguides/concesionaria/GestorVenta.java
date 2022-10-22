/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria;

public class GestorVenta {

    Venta pantallaVenta;

    public GestorVenta() {
        pantallaVenta = new Venta();
    }

    void mostrarPantalla(boolean b) {
        pantallaVenta.setVisible(true);
    }

}
