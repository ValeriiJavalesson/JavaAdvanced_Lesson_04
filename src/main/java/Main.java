import dao.*;
import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        CategoryDao categoryDao = new CategoryDao();
        SubcategoryDao subcategoryDao = new SubcategoryDao();
        ArticleDao articleDao = new ArticleDao();

        // INSERT
        Article article1 = new Article("Холодильник", "Холодильник Nord", 1999.00, 4, 1);
        articleDao.insert(article1);
        User user1 = new User("Mologkh", "+380699669966");
        userDao.insert(user1);
        Category category1 = new Category("Зоотовари");
        categoryDao.insert(category1);
        Subcategory subcategory = new Subcategory("Корм для котів", 4);
        subcategoryDao.insert(subcategory);


        // READ-ALL
        System.out.println("Read * from user: ");
        userDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from category: ");
        categoryDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from subcategory: ");
        subcategoryDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from articles: ");
        articleDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        // READ-ById
        User userFromDB = userDao.read(2);
        Article articleFromDB = articleDao.read(2);
        Category categoryFromDB = categoryDao.read(2);
        Subcategory subcategoryFromDB = subcategoryDao.read(2);
        List<Object> readList = new ArrayList<>();
        readList.add(userFromDB);
        readList.add(articleFromDB);
        readList.add(categoryFromDB);
        readList.add(subcategoryFromDB);
        System.out.println("Read from DB by ID: ");
        readList.forEach(System.out::println);
        System.out.println("************************************************\n");

        // UPDATE - ById
        userFromDB.setPhone_number("+380456595452");
        userDao.update(userFromDB);
        articleFromDB.setPrice(4200.00);
        articleDao.update(articleFromDB);
        categoryFromDB.setTitle("Побутова та кліматична техніка");
        categoryDao.update(categoryFromDB);
        subcategoryFromDB.setTitle("Двигун");
        subcategoryDao.update(subcategoryFromDB);

        //DELETE-ById
        userDao.delete(1);
        categoryDao.delete(4);
        subcategoryDao.delete(3);
        articleDao.delete(7);

        // READ-ALL
        System.out.println("Read DB after changing: ");
        System.out.println("Read * from users: ");
        userDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from categories: ");
        categoryDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from subcategories: ");
        subcategoryDao.readAll().forEach(System.out::println);
        System.out.println("\nRead * from articles: ");
        articleDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");
    }
}
