package valerko.lgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import valerko.lgs.domain.Magazine;

public class MagazineDao implements DaoInterface<Magazine> {

	private static final String READ_ALL = "select * from magazine where is_deleted=false";
	private static final String CREATE = "insert into magazine(`title`, `description`) values (?,?)";
	private static final String READ_BY_ID = "select * from magazine where id =?";
	private static final String UPDATE_BY_ID = "update magazine set title=?, description = ? where id = ?";
	private static final String DELETE_BY_ID = "update magazine set is_deleted=true where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MagazineDao(Connection connection) {
		this.connection = connection;
	}

	public MagazineDao() {
		this.connection = ConnectionUtil.getInstance().getConnection();
	}

	@Override
	public void insert(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, magazine.getTitle());
			preparedStatement.setString(2, magazine.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Magazine read(int id) {
		Magazine magazine = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			magazine = Magazine.map(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magazine;
	}

	@Override
	public void update(Magazine magazine) {
		try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, magazine.getTitle());
            preparedStatement.setString(2, magazine.getDescription());
            preparedStatement.setInt(3, magazine.getId());
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
	public List<Magazine> readAll() {
		List<Magazine> listOfMagazines = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
            	listOfMagazines.add(Magazine.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfMagazines;
	}

}
