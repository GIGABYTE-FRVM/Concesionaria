/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Cliente;

/**
 *
 * @author matya
 */
interface iClienteDao {
    void deleteCliente(int id);

    List<Cliente> getAllCliente();

    Cliente getClienteById(int id);

    void saveCliente(Cliente cliente);

    void updateCliente(Cliente cliente);
}
