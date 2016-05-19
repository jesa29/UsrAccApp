package listener;

/**
 * Created by jesa on 14.03.2016.
 * Класс для конфигурации Hibernate и работы с SessionFactory
 * с помощью сервлета
 */

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {

    private Configuration config;
    private SessionFactory factory;

    private String path = "/hibernate.cfg.xml";
    private static Class hibernateListenerClass = HibernateListener.class;

    public static final String KEY_NAME = hibernateListenerClass.getName();

    public void contextDestroyed(ServletContextEvent event) {

    }

    public void contextInitialized(ServletContextEvent event) {

        try {
            //Конфигурация Hibernate из файла
            URL url = HibernateListener.class.getResource(path);
            config = new Configuration().configure(url);
            factory = config.buildSessionFactory();

            //Сохранение SessionFactory в сервлет
            event.getServletContext().setAttribute(KEY_NAME, factory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}