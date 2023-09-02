package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Category;

public class CategoryDao implements DaoInterface<Category> {
    private static final String READ_ALL = "select * from categories where is_deleted=false";
    private static final String CREATE = "insert into categories(`title`) values (?)";
    private static final String READ_BY_ID = "select * from categories where id =?";
    private static final String UPDATE_BY_ID = "update categories set title=? where id = ?";
    private static final String DELETE_BY_ID = "update categories set is_deleted=true where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CategoryDao() {
        this.connection = ConnectionUtil.getInstance().getConnection();
    }

    @Override
    public void insert(Category category) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category read(int id) {
        Category category = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            category = Category.map(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Category category) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.setInt(2, category.getId());
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
    public List<Category> readAll() {
        List<Category> listOfCategories = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfCategories.add(Category.map(result));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCategories;
    }
}
