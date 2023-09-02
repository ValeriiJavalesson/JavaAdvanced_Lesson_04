package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String phone_number;

    public User(int id, String username, String phone_number) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
    }

    public User(String username, String phone_number) {
        this.username = username;
        this.phone_number = phone_number;
    }

    public static User map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String username = result.getString("username");
        String phone_number = result.getString("phone_number");

        return new User(id, username, phone_number);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
