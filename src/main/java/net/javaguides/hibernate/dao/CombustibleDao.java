/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Combustible;
import net.javaguides.hibernate.util.HibernateUtil;
/**
 *
 * @author EderZ
 */
public class CombustibleDao implements iCombustibleDao{
     //save Combustible
    //get All Combustible
    //get Combustible By Id
    //Update Combustible
    //Delete Combustible
    
    @Override
    public void saveCombustible(Combustible combustible) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(combustible);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }@Override
    public void updateCombustible(Combustible combustible) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(combustible);
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Combustible getCombustibleById(int id) {
        Transaction transaction = null;
        Combustible combustible = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            combustible = session.get(Combustible.class,id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return combustible;
    }
    @Override
    public List<Combustible> getAllCombustible() {
        Transaction transaction = null;
        List<Combustible> combustibles = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            combustibles = session.createQuery("from Combustible").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return combustibles;
    }
    @Override
    public void deleteCombustible(int id) {
        Transaction transaction = null;
        Combustible combustible = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            combustible = session.get(Combustible.class,id);
            session.delete(combustible);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

