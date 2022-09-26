/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Combustible;
/**
 *
 * @author EderZ
 */
public interface iCombustibleDao {
    void deleteCombustible(int id);

    List<Combustible> getAllCombustible();

    Combustible getCombustibleById(int id);

    //save Combustible
    //get All Combustible
    //get Combustible By Id
    //Update Combustible
    //Delete Combustible
    void saveCombustible(Combustible combustible);

    void updateCombustible(Combustible combustible);
    
}
