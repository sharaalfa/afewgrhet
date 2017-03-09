package services.impl;


import common.exceptions.UserDaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import services.UserService;
import models.dao.UserDao;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;

/**
 * Created by tatar on 04.03.17.
 */

/**
 * Инъекция UserDao в UserSevice с помощью аннотации
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    /**
     * Проверка авторизации
     * @param login логина пользователя
     * @param password пароля пользователя
     * @return страницу для авотризованных пользователей
     * @throws UserDaoException
     */
    public boolean authorize(String login, String password) throws UserDaoException  {
        if(userDao.getUserByLoginAndPassword(login, password) != null) {
            return true;
        }
        return false;
    }

    /**
     * Регистрация
     * @param login новый логин
     * @param password новый пароль
     * @param lastName Фамилия пользователя
     * @param firstName Имя пользователя
     * @param email электронный ящик
     * @param phone телефон
     * @return регистрацию нового пользователя
     */

    public boolean registration(String login, String password, String lastName,
                                String firstName, String email,
                                String phone) {
        return userDao.registrationUser(login, password, lastName,
                firstName, email,
                phone);
    }
}
