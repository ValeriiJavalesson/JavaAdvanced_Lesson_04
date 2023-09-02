package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Subcategory {
    private int id;
    private String title;
    private int category_id;

    public Subcategory(int id, String title, int category_id) {
        this.id = id;
        this.title = title;
        this.category_id = category_id;
    }

    public Subcategory(String title, int category_id) {
        this.title = title;
        this.category_id = category_id;
    }

    public static Subcategory map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String title = result.getString("title");
        int category_id = result.getInt("categories_id");
        return new Subcategory(id, title, category_id);
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
