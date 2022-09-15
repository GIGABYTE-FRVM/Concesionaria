/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Pais;
import main.java.net.javaguides.hibernate.util.HibernateUtil;

/**
 *
 * @author matya
 */
public class PaisDao implements iPaisDao {

    //save Marca
    //get All Marca
    //get Marca By Id
    //Update Marca
    //Delete Marca
    @Override
    public void savePais(Pais pais) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(pais);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }@Override
    public void updatePais(Pais pais) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(pais);
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Pais getPaisById(int id) {
        Transaction transaction = null;
        Pais pais = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            pais = session.get(Pais.class,id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return pais;
    }
    @Override
    public List<Pais> getAllPais() {
        Transaction transaction = null;
        List<Pais> paises = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            paises = session.createQuery("from Pais").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return paises;
    }
    @Override
    public void deletePais(int id) {
        Transaction transaction = null;
        Pais pais = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            pais = session.get(Pais.class,id);
            session.delete(pais);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
