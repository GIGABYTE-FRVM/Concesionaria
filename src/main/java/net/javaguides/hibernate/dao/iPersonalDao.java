/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Personal;

/**
 *
 * @author matya
 */
public interface iPersonalDao {

    void deletePersonal(int id);

    List<Personal> getAllPersonal();

    Personal getPersonalById(int id);

    void savePersonal(Personal personal);

    void updatePersonal(Personal personal);
    
}
