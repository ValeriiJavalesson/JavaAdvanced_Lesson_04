package valerko.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import valerko.lgs.dao.StudentDao;
import valerko.lgs.domain.Student;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		
		StudentDao studentDao = ctx.getBean(StudentDao.class);
		
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Іван");
		s1.setAge(11);
		studentDao.create(s1);
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Сергій");
		s2.setAge(22);
		studentDao.create(s2);
		
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Віталій");
		s3.setAge(33);
		studentDao.create(s3);
		
		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Олексій");
		s4.setAge(44);
		studentDao.create(s4);
		
		System.out.println();
		System.out.println("База даних після додавання:");
		studentDao.readAll().forEach(System.out::println);
		
		Student s5 = studentDao.read(3);
		s5.setName("Ігор");
		s5.setAge(56);
		studentDao.update(s5);
		System.out.println();
		System.out.println("База даних після операції оновлення:");
		studentDao.readAll().forEach(System.out::println);
		
		studentDao.delete(2);
		System.out.println();
		System.out.println("База даних після операції видалення:");
		studentDao.readAll().forEach(System.out::println);

		

	}

}
