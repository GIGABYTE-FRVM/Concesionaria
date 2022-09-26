/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Auto;

/**
 *
 * @author matya
 */
interface iAutoDao {
    void deleteAuto(int id);

    List<Auto> getAllAuto();

    Auto getAutoById(int id);

    //save Combustible
    //get All Combustible
    //get Combustible By Id
    //Update Combustible
    //Delete Combustible
    void saveAuto(Auto auto);

    void updateAuto(Auto auto);
}
