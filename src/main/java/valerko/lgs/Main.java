package valerko.lgs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import valerko.lgs.domain.User;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
////		UserService userService = UserServiceImpl.getUserService();
////		List<User> users = userService.readAll();
////		
////		System.out.println();
////		System.out.println("Users:");
////		users.forEach(System.out::println);
////		System.out.println();

	 EntityManagerFactory emf =
             Persistence.createEntityManagerFactory("IShopPersistence");
         EntityManager em = emf.createEntityManager();
		

	}

}
