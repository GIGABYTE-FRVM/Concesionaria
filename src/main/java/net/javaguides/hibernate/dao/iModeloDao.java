/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Modelo;

/**
 *
 * @author matya
 */
public interface iModeloDao {

    void deleteModelo(int id);

    List<Modelo> getAllModelos();

    Modelo getModeloById(int id);

    //save Modelo
    //get All Modelo
    //get Modelo By Id
    //Update Modelo
    //Delete Modelo
    void saveModelo(Modelo modelo);

    void updateModelo(Modelo modelo);
    
}
