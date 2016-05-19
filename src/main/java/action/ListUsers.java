package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.User;
import model.UserDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesa on 30.03.2016.
 * Action-класс для Struts2
 * Получение списка пользователей
 */
public class ListUsers extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserDAO dao = new UserDAO();
    private List<User> users = new ArrayList<User>();

    public User getModel() {
        return user;
    }

    /**
     * получение списка пользователей из базы
     *
     * @return успешное завершение
     */
    public String execute() {
        users = dao.getUsers();
        return Action.SUCCESS;
    }

    //getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
}
