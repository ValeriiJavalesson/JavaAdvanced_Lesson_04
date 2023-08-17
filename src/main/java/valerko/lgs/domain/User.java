package valerko.lgs.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	
	private int id ;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String accessLevel;
	
	public User(String firstName, String lastName, String email, String password, String accessLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}
	public User(int id, String firstName, String lastName, String email, String password, String accessLevel) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}
	
    public static User map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String firstName = result.getString("firstName");
        String lastName = result.getString("lastName");
        String email = result.getString("email");
        String password = result.getString("password");
        String accessLevel = result.getString("accessLevel");
        return new User(id, firstName, lastName, email, password, accessLevel);
    }
    
	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getAccessLevel() {
		return accessLevel;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", accessLevel=" + accessLevel +"]";
	}
	
	
	
}
