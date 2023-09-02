package valerko.lgs.dao.impl;

import org.apache.log4j.Logger;
import valerko.lgs.dao.BucketDao;
import valerko.lgs.domain.Bucket;
import valerko.lgs.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDao {

    private static final String READ_ALL = "select * from bucket where is_deleted=false";
    private static final String CREATE = "insert into bucket(`userId`, `productId`, `purchaseDate`) values (?,?,?)";
    private static final String READ_BY_ID = "select * from bucket where id=?";
    private static final String UPDATE_BY_ID = "update bucket set userId=?, productId=?, purchaseDate = ? where id = ?";
    private static final String DELETE_BY_ID = "update bucket set is_deleted=true where id=?";
    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() {
        this.connection = ConnectionUtil.getInstance().getConnection();
    }
    @Override
    public void create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public Bucket read(int id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            bucket = Bucket.map(result);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return bucket;
    }

    @Override
    public void update(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Bucket> readAll() {
        List<Bucket> listOfBuckets = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfBuckets.add(Bucket.map(result));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return listOfBuckets;
    }
}
