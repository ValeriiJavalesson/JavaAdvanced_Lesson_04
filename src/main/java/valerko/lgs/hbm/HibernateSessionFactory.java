package valerko.lgs.hbm;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {
	private static SessionFactory hibernateSessionFactory;

	public static SessionFactory getSessionFactory() {
		if (hibernateSessionFactory == null) {
			try {
				//Configure session factory
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");

				configuration.addResource("Cart.hbm.xml");
				configuration.addResource("Item.hbm.xml");

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				hibernateSessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hibernateSessionFactory;
	}
}
