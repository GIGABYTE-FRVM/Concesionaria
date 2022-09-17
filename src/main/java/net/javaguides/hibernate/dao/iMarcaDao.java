/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Marca;

/**
 *
 * @author matya
 */
public interface iMarcaDao {

    void deleteMarca(int id);

    List<Marca> getAllMarcas();

    Marca getMarcaById(int id);

    //save Marca
    //get All Marca
    //get Marca By Id
    //Update Marca
    //Delete Marca
    void saveMarca(Marca marca);

    void updateMarca(Marca marca);
    
}
