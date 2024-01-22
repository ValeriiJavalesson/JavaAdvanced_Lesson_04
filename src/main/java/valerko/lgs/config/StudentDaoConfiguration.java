package valerko.lgs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import valerko.lgs.dao.StudentDao;
import valerko.lgs.dao.impl.StudentDaoImpl;

@Configuration
public class StudentDaoConfiguration {
	
	@Bean(name="student")
	public StudentDao getStudentDao() {
		return new StudentDaoImpl();
	}

}
