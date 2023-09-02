package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Subcategory;

public class SubcategoryDao implements DaoInterface<Subcategory> {
    private static final String READ_ALL = "select * from subcategories where is_deleted=false";
    private static final String CREATE = "insert into subcategories(`title`, `categories_id`) values (?,?)";
    private static final String READ_BY_ID = "select * from subcategories where id =?";
    private static final String UPDATE_BY_ID = "update subcategories set title=?, categories_id=? where id = ?";
    private static final String DELETE_BY_ID = "update subcategories set is_deleted=true where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public SubcategoryDao() {
        this.connection = ConnectionUtil.getInstance().getConnection();
    }

    @Override
    public void insert(Subcategory subcategory) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, subcategory.getTitle());
            preparedStatement.setInt(2, subcategory.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subcategory read(int id) {
        Subcategory subcategory = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            subcategory = Subcategory.map(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subcategory;
    }

    @Override
    public void update(Subcategory subcategory) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, subcategory.getTitle());
            preparedStatement.setInt(2, subcategory.getCategory_id());
            preparedStatement.setInt(3, subcategory.getId());
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
    public List<Subcategory> readAll() {
        List<Subcategory> listOfSubcategories = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfSubcategories.add(Subcategory.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfSubcategories;
    }
}
