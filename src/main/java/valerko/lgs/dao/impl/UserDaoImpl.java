package valerko.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import valerko.lgs.dao.UserDao;
import valerko.lgs.domain.User;
import valerko.lgs.shared.FactoryManager;

public class UserDaoImpl implements UserDao {
	
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			user = em.find(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User read(String email) {
		User user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> from = criteria.from(User.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<User> typed = em.createQuery(criteria);
			try {
				user = typed.getSingleResult();
			} catch (Exception e) {
//				System.err.println("No user found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			User user = read(id);
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String email) {
		try {
			User user = read(email);
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAll() {
		List<User> listOfUsers = new ArrayList<>();
		try {
			Query query = em.createQuery("SELECT e FROM User e");
			listOfUsers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}
}
