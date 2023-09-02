package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDao implements DaoInterface<User> {
    private static final String READ_ALL = "select * from users where is_deleted=false";
    private static final String CREATE = "insert into users(`username`, `phone_number`) values (?,?)";
    private static final String READ_BY_ID = "select * from users where id =?";
    private static final String UPDATE_BY_ID = "update users set username=?, phone_number = ? where id = ?";
    private static final String DELETE_BY_ID = "update users set is_deleted=true where id=?";

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
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPhone_number());
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

    @Override
    public void update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPhone_number());
            preparedStatement.setInt(3, user.getId());
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
