package valerko.lgs.hbm;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {
	public static void main(String[] args) {
		// Creating session
		Session session = HibernateSessionFactory.getSessionFactory().openSession();

		// Create new objects for transaction
		Item item1 = new Item(11);
		Item item2 = new Item(22);
		Item item3 = new Item(33);
		Item item4 = new Item(44);

		Cart cart = new Cart(100, "NewYear");
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));

		// Creating new transaction
		Transaction transaction = session.beginTransaction();
		session.persist(cart);
		transaction.commit();
		
		// Close transaction
		session.close();
	}
}
