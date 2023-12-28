package valerko.lgs;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {
	public static void main(String[] args) {
		System.out.println("Test sring");
		// Creating session
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		// Create new objects for transaction
		
		Post post1 = new Post("Post one");
		Post post2 = new Post("Post two");
		
		Comment comment1 = new Comment("Commenter one", post1);
		Comment comment2 = new Comment("Commenter two", post2);
		Comment comment3 = new Comment("Commenter three", post2);
		
		post1.setComments(new HashSet<>(Arrays.asList(comment1)));
		post2.setComments(new HashSet<>(Arrays.asList(comment2, comment3)));

		// Creating new transaction
		Transaction transaction = session.beginTransaction();
		
		session.persist(post1);
		session.persist(post2);
		session.persist(comment1);
		session.persist(comment2);
		session.persist(comment3);
		
		transaction.commit();
		
		//Read from DB
		Post postDB1 = (Post) session.get(Post.class, 1);
		System.out.println(postDB1 + " has list of comments " + postDB1.getComments());
		Post postDB2 = (Post) session.get(Post.class, 2);
		System.out.println(postDB2 + " has list of comments " + postDB2.getComments());

		Comment commentDB1 = (Comment) session.get(Comment.class, 1);
		System.out.println(commentDB1 + " commented a " + commentDB1.getPost());
		Comment commentDB2 = (Comment) session.get(Comment.class, 2);
		System.out.println(commentDB2 + " commented a " + commentDB2.getPost());
		Comment commentDB3 = (Comment) session.get(Comment.class, 3);
		System.out.println(commentDB3 + " commented a " + commentDB3.getPost());

//		 Close transaction
		session.close();
	}

}
