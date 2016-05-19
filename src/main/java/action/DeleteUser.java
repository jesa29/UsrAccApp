package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.User;
import model.UserDAO;

/**
 * Created by jesa on 30.03.2016.
 * Action-класс для Struts2
 * Удаление существующего пользователя
 */
public class DeleteUser extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserDAO dao = new UserDAO();
    private Long id;
    //поля для получения параметров Json
    private String ID;

    public User getModel() {
        return user;
    }

    /**
     * удаление пользователя из базы
     *
     * @return успешное завершение
     */
    public String execute() {
        dao.deleteUser(getId());
        return Action.SUCCESS;
    }

    //getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
        this.id = Long.valueOf(ID);
    }
}
