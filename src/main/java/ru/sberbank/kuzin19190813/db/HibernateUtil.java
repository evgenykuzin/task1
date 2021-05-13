package ru.sberbank.kuzin19190813.db;

import org.hibernate.cfg.Environment;
import ru.sberbank.kuzin19190813.entities.City;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sberbank.kuzin19190813.util.PropertiesManager;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = PropertiesManager.getProperties("database");
                settings.setProperty(Environment.HBM2DDL_AUTO, "create");

                configuration
                        .addPackage("ru.sberbank.kuzin19190813.entities");

                configuration
                        .setProperties(settings);

                configuration
                        .addAnnotatedClass(City.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private HibernateUtil() {
    }

    public static void close() {
        sessionFactory.close();
    }
}
