package models.dao;

import common.exceptions.UserDaoException;
import models.pojo.User;


import java.sql.Date;
import java.util.List;

/**
 * Created by tatar on 04.03.17.
 */
public interface UserDao{
    User getUserByLoginAndPassword(String login, String password) throws UserDaoException;

    boolean registrationUser(String login, String password,
                         String lastName, String firstName,
                         String email, String phone);


}
