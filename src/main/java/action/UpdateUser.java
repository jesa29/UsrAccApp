package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.User;
import model.UserDAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by jesa on 30.03.2016.
 * Action-класс для Struts2
 * Обновление существующего пользователя
 */
public class UpdateUser extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserDAO dao = new UserDAO();
    private Long id;
    //поля для получения параметров Json
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String dateOfBirth;
    private String email;
    private String ID;
    //поля для преобразования дат
    SimpleDateFormat stringFormatter = new SimpleDateFormat("dd.MM.yyyy"),
            dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public User getModel() {
        return user;
    }

    /**
     * обновление данных о пользователе в базе
     *
     * @return успешное завершение
     * @throws ParseException при неправильной входной строке с датой
     */
    public String execute() throws ParseException {
        //получение пользователя из базы по id
        user = dao.getUser(getId());
        //создание нового пользователя с измененными параметрами
        User newUser = new User(getFirstName() == null ? user.getFirstName() : getFirstName(),
                getLastName() == null ? user.getLastName() : getLastName(),
                getPassportNumber() == null ? user.getPassportNumber() : Long.valueOf(this.passportNumber),
                getDateOfBirth() == null ? user.getDateOfBirth() : parseDateOfBirth(),
                getEmail() == null ? user.getEmail() : getEmail());
        newUser.setID(user.getID());
        dao.updateUser(newUser);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * преобразование входной строки в дату
     *
     * @return дата, полученная из строки
     * @throws ParseException при неправильной входной строке с датой
     */
    public Date parseDateOfBirth() throws ParseException {
        Date date;
        try {
            date = new Date((stringFormatter.parse(this.dateOfBirth)).getTime());
        } catch (ParseException parseException) {
            date = new Date((dateFormatter.parse(this.dateOfBirth)).getTime());
        }
        return date;
    }
}
