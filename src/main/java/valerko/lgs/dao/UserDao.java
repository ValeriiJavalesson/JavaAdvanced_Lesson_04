package valerko.lgs.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import valerko.lgs.domain.User;

public class UserDao implements DaoInterface<User> {
    private static final String READ_ALL = "select * from user where is_deleted=false";
    private static final String CREATE = "insert into user(`firstName`, `lastName`, `email`, `password`, `accessLevel`) values (?,?,?,?,?)";
    private static final String READ_BY_ID = "select * from user where id =?";
    private static final String READ_BY_EMAIL = "select * from user where email =?";
    private static final String UPDATE_BY_ID = "update user set firstName=?, lastName = ?, email = ?, password = ?, accessLevel = ? where id = ?";
    private static final String DELETE_BY_ID = "update user set is_deleted=true where id=?";
    private static final String DELETE_BY_EMAIL = "update user set is_deleted=true where email=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public UserDao() {
        this.connection = ConnectionUtil.getInstance().getConnection();
    }

    @Override
    public void insert(User user) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAccessLevel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User read(int id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            user = User.map(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User read(String email) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            user = User.map(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAccessLevel());
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String email) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_EMAIL);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readAll() {
        List<User> listOfUsers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfUsers.add(User.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }
}
