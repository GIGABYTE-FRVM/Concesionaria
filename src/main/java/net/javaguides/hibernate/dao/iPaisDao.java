/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Pais;

/**
 *
 * @author matya
 */
public interface iPaisDao {

    void deletePais(int id);

    List<Pais> getAllPais();

    Pais getPaisById(int id);

    //save Marca
    //get All Marca
    //get Marca By Id
    //Update Marca
    //Delete Marca
    void savePais(Pais pais);

    void updatePais(Pais pais);
    
}
