/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.util.HibernateUtil;


/**
 *
 * @author matya
 */
public class ClienteDao implements iClienteDao {

    //save Marca
    //get All Marca
    //get Marca By Id
    //Update Marca
    //Delete Marca
    
    @Override
    public void saveCliente(Cliente cliente) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(cliente);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    
    @Override
    public void updateCliente(Cliente cliente) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(cliente);
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Cliente getClienteById(int id) {
        Transaction transaction = null;
        Cliente cliente = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            cliente = session.get(Cliente.class,id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return cliente;
    }
    
    public List<Cliente> getAllCliente() {
        Transaction transaction = null;
        List<Cliente> clientes = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            clientes = session.createQuery("from Cliente").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clientes;
    }
    
    @Override
    public void deleteCliente(int id) {
        Transaction transaction = null;
        Cliente cliente = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            cliente = session.get(Cliente.class,id);
            session.delete(cliente);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
