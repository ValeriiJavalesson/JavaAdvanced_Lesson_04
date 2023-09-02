package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Article {
    private int id;
    private String title;
    private String description;
    private double price;
    private int subcategories_id;
    private int user_id;

    public Article(int id, String title, String description, double price, int subcategory_id, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.subcategories_id = subcategory_id;
        this.user_id = user_id;
    }

    public Article(String title, String description, double price, int subcategory_id, int user_id) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.subcategories_id = subcategory_id;
        this.user_id = user_id;
    }

    public static Article map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String title = result.getString("title");
        String description = result.getString("description");
        double price = result.getDouble("price");
        int subcategory_id = result.getInt("subcategories_id");
        int user_id = result.getInt("user_id");
        return new Article(id, title, description, price, subcategory_id, user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSubcategories_id() {
        return subcategories_id;
    }

    public void setSubcategories_id(int subcategories_id) {
        this.subcategories_id = subcategories_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", subcategories_id=" + subcategories_id +
                ", user_id=" + user_id +
                '}';
    }
}
