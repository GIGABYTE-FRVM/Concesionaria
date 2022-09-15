/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.util;

import java.util.List;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.dao.MarcaDao;

/**
 *
 * @author matya
 */
public class app {
    public static void main(String[] args) {
        MarcaDao marcaDao = new MarcaDao();
        Marca marca = new Marca("HIB2","Hibernate33","Logré conectar con hibernate2",null);
        // REGISTRAR
        marcaDao.saveMarca(marca);
        
        //ELIMINAR
        marcaDao.deleteMarca(8);
        
        //MODIFICAR
        marca.setNombre("HIBERNATE UPDATE");
        marcaDao.updateMarca(marca);
        
        //CONSULTAR
        Marca marca2 = marcaDao.getMarcaById(7);
        List<Marca> marcas = marcaDao.getAllMarcas();
        //marcas.forEach(marca1 -> System.out.println(marca1.getNombre()));
        

    }
}
