package model;

/**
 * Created by jesa on 11.03.2016.
 * Взаимодействие с объектами базы данных
 */

import java.util.ArrayList;
import java.util.List;

import listener.HibernateListener;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {
    /**
     * Получение списка пользователей из БД
     *
     * @return список пользователей
     */
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext
                        .getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        users = (List<User>) session.createQuery("from User").list();
        session.getTransaction().commit();
        return users;
    }

    /**
     * Добавление нового пользователя
     *
     * @param user пользователь, полученный из Action-класса
     */
    public void addUser(User user) {
        //получение сессии
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext
                        .getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    /**
     * Удаление пользователя
     *
     * @param id идентификатор пользователя, полученный из Action-класса
     */
    public void deleteUser(Long id) {
        //получение сессии
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext
                        .getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
        session.getTransaction().commit();
    }

    /**
     * Получение пользователя из базы по идентификатору
     *
     * @param id идентификатор
     * @return пользователь
     */
    public User getUser(Long id) {
        //получение сессии
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext
                        .getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    /**
     * Обновление пользователя в БД
     *
     * @param user пользователь, полученный из Action-класса
     */
    public void updateUser(User user) {
        //получение сессии
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext
                        .getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}