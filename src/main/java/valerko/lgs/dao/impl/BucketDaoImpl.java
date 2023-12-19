package valerko.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import valerko.lgs.dao.BucketDao;
import valerko.lgs.domain.Bucket;
import valerko.lgs.domain.User;
import valerko.lgs.shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {
	
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
//			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bucket;
	}

	public List<Bucket> readByUser(User user) {
		List<Bucket> listOfBuckets = new ArrayList<>();
		try {
			listOfBuckets = readAll().stream()
					.filter(b->b.getUser().equals(user))
					.toList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfBuckets;
	}

	@Override
	public Bucket update(Bucket bucket) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
}
