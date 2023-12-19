package valerko.lgs.shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.hibernate.HibernateException;


public class FactoryManager {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
		try {entityManagerFactory = Persistence.createEntityManagerFactory("IShopPersistence");}
		catch (HibernateException exception) {
			System.out.println("Problem creating session factory");
		     exception.printStackTrace();
		}
		
		}
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}

}
