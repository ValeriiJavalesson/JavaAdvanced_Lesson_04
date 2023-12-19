package valerko.lgs.service;

import java.util.List;

import valerko.lgs.domain.Bucket;
import valerko.lgs.domain.User;
import valerko.lgs.shared.AbstractCRUD;

public interface BucketService extends AbstractCRUD<Bucket>{
	public List<Bucket> readByUser(User user);

}
