package valerko.lgs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import valerko.lgs.domain.Accreditation;
import valerko.lgs.domain.University;
import valerko.lgs.service.UniversityService;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		UniversityService universityService = context.getBean(UniversityService.class);

		//create
		List<University> listOfUniversity = new ArrayList<>();
		listOfUniversity.add(new University("Київський столичний університет імені Бориса Грінченка",Accreditation.LEVEL_4, 10, 1863, "м. Київ"));
		listOfUniversity.add(new University("Білоцерківський національний аграрний університет",Accreditation.LEVEL_4, 8, 2400, "м. Біла Церква"));
		listOfUniversity.add(new University("Київський національний університет культури і мистецтв",Accreditation.LEVEL_3, 3, 683, "м. Київ"));
		listOfUniversity.add(new University("Тернопільський національний медичний університет ім. І.Я. Горбачевського",Accreditation.LEVEL_3, 12, 2400, "м. Тернопіль"));
		listOfUniversity.add(new University("IT STEP University",Accreditation.LEVEL_2, 2, 400, "м. Львів"));
		listOfUniversity.add(new University("Бердянський державний педагогічний університет",Accreditation.LEVEL_2, 3, 1100, "м. Бердянськ"));
		listOfUniversity.add(new University("Білоцерківський інститут економіки та управління університету",Accreditation.LEVEL_3, 2, 400, "м. Біла Церква"));
		listOfUniversity.add(new University("Вінницький інститут конструювання одягу і підприємництва",Accreditation.LEVEL_4, 8, 400, "м. Вінниця"));
		listOfUniversity.add(new University("Вінницький національний медичний університет ім. М. Пирогова",Accreditation.LEVEL_2, 2, 400, "м. Вінниця"));

		listOfUniversity.forEach(u -> universityService.create(u));	
		
		//read
		System.out.println();
		System.out.println("<---READ BY--->");
		System.out.println("<-Accreditation->");
		universityService.findByAccreditation(Accreditation.LEVEL_3).forEach(System.out::println);
		
		System.out.println("<---Address--->");
		universityService.findByAddress("м. Біла Церква").forEach(System.out::println);
		
		System.out.println("<----ID----->");
		System.out.println(universityService.findById(4));
		
		System.out.println("<----Name---->");
		System.out.println(universityService.findByName("Білоцерківський національний аграрний університет"));
		
		System.out.println("<--NumberOfInstitutes---->");
		universityService.findByNumberOfInstitutes(8).forEach(System.out::println);
		
		System.out.println("<---NumberOfStudents--->");
		universityService.findByNumberОfStudents(2400).forEach(System.out::println);
		System.out.println("<------------->");
		
		//update
		System.out.println();
		System.out.println("<---UPDATE---->");
		University universityToUpdate = universityService.findByName("IT STEP University");
		System.out.println("<---BEFORE--->");
		System.out.println(universityToUpdate);
		universityToUpdate.setAccreditation(Accreditation.LEVEL_3);
		universityToUpdate.setNumberОfStudents(500);
		universityService.update(universityToUpdate);
		System.out.println("<---AFTER--->");
		System.out.println(universityService.findByName("IT STEP University"));
		System.out.println("<------------->");
		
		//delete
		System.out.println();
		System.out.println("<----DELETE---->");
		//deleteById
		universityService.deleteById((long)6);
		System.out.println("<--NumberOfDeletedUniversitiesByName--->");
		System.out.println(universityService.deleteByName("Київський столичний університет імені Бориса Грінченка"));	
		System.out.println("<--NumberOfDeletedUniversitiesByNameAddress--->");
		System.out.println(universityService.deleteByAddress("м. Вінниця"));	
		System.out.println("<--NumberOfDeletedUniversitiesByNameAccreditation--->");
		System.out.println(universityService.deleteByAccreditation(Accreditation.LEVEL_4));	
		System.out.println("<------------->");
		
		//read all
		System.out.println();
		System.out.println("<--READ ALL--->");
		universityService.findAll().forEach(System.out::println);
		System.out.println("<------------->");
		System.out.println();
		
		
	}
}
