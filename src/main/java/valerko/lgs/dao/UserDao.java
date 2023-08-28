package valerko.lgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import valerko.lgs.domain.User;
import valerko.lgs.shared.AbstractCRUD;
import valerko.lgs.utils.ConnectionUtil;

public interface UserDao extends AbstractCRUD<User> {
}
