/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.util.HibernateUtil;

/**
 *
 * @author matya
 */
public class MarcaDao implements iMarcaDao {

    //save Marca
    //get All Marca
    //get Marca By Id
    //Update Marca
    //Delete Marca
    @Override
    public void saveMarca(Marca marca) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(marca);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }@Override
    public void updateMarca(Marca marca) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(marca);
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Marca getMarcaById(int id) {
        Transaction transaction = null;
        Marca marca = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            marca = session.get(Marca.class,id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return marca;
    }
    @Override
    public List<Marca> getAllMarcas() {
        Transaction transaction = null;
        List<Marca> marcas = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            marcas = session.createQuery("from Marca").list();

            transaction.commit();
                

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return marcas;
    }
    @Override
    public void deleteMarca(int id) {
        Transaction transaction = null;
        Marca marca = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            marca = session.get(Marca.class,id);
            session.delete(marca);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
