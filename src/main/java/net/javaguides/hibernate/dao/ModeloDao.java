/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Modelo;
import net.javaguides.hibernate.util.HibernateUtil;

/**
 *
 * @author matya
 */
public class ModeloDao implements iModeloDao {

    //save Modelo
    //get All Modelo
    //get Modelo By Id
    //Update Modelo
    //Delete Modelo
    @Override
    public void saveModelo(Modelo modelo) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(modelo);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }@Override
    public void updateModelo(Modelo modelo) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(modelo);
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Modelo getModeloById(int id) {
        Transaction transaction = null;
        Modelo modelo = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            modelo = session.get(Modelo.class,id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return modelo;
    }
    @Override
    public List<Modelo> getAllModelos() {
        Transaction transaction = null;
        List<Modelo> modelos = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            modelos = session.createQuery("from Modelo").list();

            transaction.commit();
                

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return modelos;
    }
    @Override
    public void deleteModelo(int id) {
        Transaction transaction = null;
        Modelo modelo = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            modelo = session.get(Modelo.class,id);
            session.delete(modelo);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
