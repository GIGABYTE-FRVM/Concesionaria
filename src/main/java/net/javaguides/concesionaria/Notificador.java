/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria;

/**
 *
 * @author matya
 */
public class Notificador {

    public synchronized void solicitar() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public synchronized void entregar() {
        notify();
    }
}
