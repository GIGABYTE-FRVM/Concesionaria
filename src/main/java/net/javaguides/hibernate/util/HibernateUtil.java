package net.javaguides.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;
import net.javaguides.hibernate.model.Pais;
import net.javaguides.hibernate.model.Personal;

import org.hibernate.HibernateException;


import net.javaguides.hibernate.model.Combustible;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost/concesionaria?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Marca.class);
                configuration.addAnnotatedClass(Pais.class);
                configuration.addAnnotatedClass(Personal.class);
                configuration.addAnnotatedClass(Combustible.class);
                configuration.addAnnotatedClass(Modelo.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
            }
        }
        return sessionFactory;
    }
}
