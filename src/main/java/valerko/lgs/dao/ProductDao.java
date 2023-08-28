package valerko.lgs.dao;

import valerko.lgs.domain.Product;
import valerko.lgs.shared.AbstractCRUD;
import valerko.lgs.utils.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ProductDao extends AbstractCRUD<Product> {
}
