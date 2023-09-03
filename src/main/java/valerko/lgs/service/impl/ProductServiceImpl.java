package valerko.lgs.service.impl;

import valerko.lgs.dao.ProductDao;
import valerko.lgs.dao.impl.ProductDaoImpl;
import valerko.lgs.domain.Product;
import valerko.lgs.service.ProductService;
import valerko.lgs.service.UserService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl productServiceImpl;
    private ProductDao productDao;

    private ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }
    public static ProductService getProductService(){
        if(productServiceImpl == null){
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    @Override
    public void create(Product product) {
        productDao.create(product);
    }

    @Override
    public Product read(int id) {
        return productDao.read(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }
}
