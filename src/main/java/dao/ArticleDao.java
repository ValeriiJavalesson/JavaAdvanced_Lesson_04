package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Article;

public class ArticleDao implements DaoInterface<Article> {

    private static final String READ_ALL = "select * from articles where is_deleted=false";
    private static final String CREATE = "insert into articles(`title`, `description`, `price`, `subcategories_id`, `user_id`) values (?,?,?,?,?)";
    private static final String READ_BY_ID = "select * from articles where id =?";
    private static final String UPDATE_BY_ID = "update articles set title=?, description=?, price=?, subcategories_id=?, user_id=?  where id = ?";
    private static final String DELETE_BY_ID = "update articles set is_deleted=true where id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ArticleDao() {
        this.connection = ConnectionUtil.getInstance().getConnection();
    }

    @Override
    public void insert(Article article) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setDouble(3, article.getPrice());
            preparedStatement.setInt(4, article.getSubcategories_id());
            preparedStatement.setInt(5, article.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article read(int id) {
        Article article = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            article = Article.map(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public void update(Article article) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setDouble(3, article.getPrice());
            preparedStatement.setInt(4, article.getSubcategories_id());
            preparedStatement.setInt(5, article.getUser_id());
            preparedStatement.setInt(6, article.getId());
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
    public List<Article> readAll() {
        List<Article> listOfArticles = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfArticles.add(Article.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfArticles;
    }
}
