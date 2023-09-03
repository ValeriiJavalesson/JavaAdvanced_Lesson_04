package valerko.lgs.service.impl;

import valerko.lgs.dao.BucketDao;
import valerko.lgs.dao.impl.BucketDaoImpl;
import valerko.lgs.domain.Bucket;
import valerko.lgs.service.BucketService;
import valerko.lgs.service.ProductService;

import java.util.List;

public class BucketServiceImpl implements BucketService {
    private static BucketServiceImpl bucketServiceImpl;
    private BucketDao bucketDao;

    private BucketServiceImpl() {
        bucketDao = new BucketDaoImpl();
    }
    public static BucketService getBucketService(){
        if(bucketServiceImpl == null){
            bucketServiceImpl = new BucketServiceImpl();
        }
        return bucketServiceImpl;
    }

    @Override
    public void create(Bucket bucket) {
        bucketDao.create(bucket);
    }

    @Override
    public Bucket read(int id) {
        return bucketDao.read(id);
    }

    @Override
    public void update(Bucket bucket) {
        bucketDao.update(bucket);
    }

    @Override
    public void delete(int id) {
        bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }
}
