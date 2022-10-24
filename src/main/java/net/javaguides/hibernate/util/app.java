/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.util;

import java.util.List;
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Venta;


/**
 *
 * @author matya
 */
public class app {
    public static void main(String[] args) {
        GestorHibernate gestorHib  = GestorHibernate.getInstancia();

        Cliente cliente = new Cliente("Gestor1", "Hibernate", "PDM", 
                "42980360", "String email", "String telefono"
                , "String fechaNacimiento");
        // REGISTRAR
        //gestorHib.saveObject(cliente);
        //Cliente cliente2 = gestorHib.getObjectById("Cliente as cliente WHERE cliente.documento LIKE '%42980360%'", 0);
        //System.out.println(cliente2);
        //System.out.println("REGISTRÓ EL OBJETO");
        
        /*
        Venta venta = new Venta("holis");
        gestorHib.saveObject(venta);
        
        List<Venta> listadoVentas;
        listadoVentas = gestorHib.getAllObjects("Venta");
        System.out.println(listadoVentas);
        
        */

    }
}
