/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.util;

import java.util.List;
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.dao.MarcaDao;
import net.javaguides.hibernate.dao.GestorHibernate;


/**
 *
 * @author matya
 */
public class app {
    public static void main(String[] args) {
        MarcaDao marcaDao = new MarcaDao();
        GestorHibernate gestorHib   = new GestorHibernate();


        Cliente cliente = new Cliente("Gestor1", "Hibernate", "PDM", 
                "String documento", "String email", "String telefono"
                , "String fechaNacimiento");
        // REGISTRAR
        gestorHib.saveObject(cliente);
        System.out.println("REGISTRÓ EL OBJETO");
        //GET ALL
        List<Cliente> clientes = gestorHib.getAllObjects("Cliente");
        //List<Marca> marcas = marcaDao.getAllMarcas();
        System.out.println(clientes);
        clientes.forEach(cliente1 -> System.out.println(cliente1.getNombre()));
        System.out.println("CONSULTÓ LOS OBJETOS");
        //ELIMINAR
        gestorHib.deleteObject("Cliente",4);
        System.out.println("ELIMINÓ EL OBJETO");
        //MODIFICAR
        cliente.setNombre("GESTORHIBMOD");
        gestorHib.updateObject(cliente);
        System.out.println("MODIFICÓ EL OBJETO");

        //CONSULTAR
        Cliente cliente2 = gestorHib.getObjectById("Cliente",3);
        System.out.println(cliente2);
        System.out.println("CONSULTÓ EL OBJETO");



    }
}
