package models.dao.impl;

import common.exceptions.UserDaoException;
import models.connector.Connector;
import models.dao.UserDao;
import models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by tatar on 04.03.17.
 */

public class UserDaoImpl {
    /**
     * Логгирование
     */

    Logger logger = Logger.getLogger(UserDaoImpl.class);

    private static final String SQL_FIND_USER =
            "SELECT * FROM \"user\" WHERE login=? AND password=?;";
    private static final String SQL_CREATE_USER =
            "INSERT INTO \"user\"(login, password," +
                    "last_name, first_name, role_id" +
                    "email, phone, is_active, updated_date) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public User getUserByLoginAndPassword(String login, String password) throws UserDaoException {
        logger.debug(login + " " + password);

        User user = null;
        try{
            Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                logger.debug("find");
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getLong("roleId"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("is_active"),
                        resultSet.getDate("update_date")
                );
            } else {
                logger.debug(login + " " + password + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return user;
    }


    public boolean registrationUser(String login, String password, String lastName,
                                    String firstName, String email,
                                    String phone) {
        Date date = new Date();
        try {
            Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, firstName);
            preparedStatement.setLong(5, 3);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, phone);
            preparedStatement.setBoolean(8, true);
            preparedStatement.setString(9, date.toString());
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                logger.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }


}
