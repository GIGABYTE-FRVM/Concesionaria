/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matya
 */
public class GestorHibernate {

    private static GestorHibernate instancia;

    private GestorHibernate(){
        System.out.println("GestorHibernate Creado");
    }
    
    public static GestorHibernate getInstancia() {
        if (instancia == null) {
            instancia = new GestorHibernate();
        }
        return instancia;
    }

    public <T> void saveObject(T object) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(object);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public <T> void updateObject(Object object) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(object);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public <T> T getObjectById(String query, int id) {
        Transaction transaction = null;
        List<T> objects = null;
        T object = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("from " + query);
            objects = session.createQuery("from " + query).list();
            object = objects.get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return object;
    }

    public <T> List<T> getAllObjects(String query) {
        Transaction transaction = null;
        List<T> objects = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            objects = session.createQuery("from " + query).list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return objects;
    }

    public <T> void deleteObject(String query, int id) {
        Transaction transaction = null;
        List<T> objects = null;
        T object = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            objects = session.createQuery("from " + query + " where id = " + id).list();
            object = objects.get(0);
            session.delete(object);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public <T> void deleteObject(T object) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(object);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    
    public <T> T getLatestIdObject(String table) {
        Transaction transaction = null;
        List<T> objects;
        T object = null;
        
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //objects = session.createQuery("select " + table + ".id from " + table + " where " + table + ".id = (select max("+table+".id) from " + table + ")").list();
            objects = session.createQuery("select venta.id from venta").list();
            object = objects.get(0);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return object;
    }
    
        public <T> T getClienteByDni(String query, int dni) {
        Transaction transaction = null;
        List<T> objects = null;
        T object = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("holis");
            objects = session.createQuery("from " + query + " where documento = " + Integer.toString(dni)).list();
            System.out.println("adios");
            object = objects.get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return object;
    }
}
