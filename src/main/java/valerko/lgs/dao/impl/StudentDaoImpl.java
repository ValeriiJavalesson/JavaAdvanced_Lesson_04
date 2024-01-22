package valerko.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import valerko.lgs.dao.StudentDao;
import valerko.lgs.domain.Student;

public class StudentDaoImpl implements StudentDao{
	private List<Student> listOfStudents = new ArrayList<Student>();

	@Override
	public Student create(Student student) {
		listOfStudents.add(student);
		return student;
	}

	@Override
	public Student read(Integer id) {
		Student student = null;
		student = listOfStudents.stream()
		.filter(s->s.getId().equals(id)).findFirst().get();
		return student;
	}

	@Override
	public Student update(Student student) {
		Student s = read(student.getId());
		s=student;
		return student;
	}

	@Override
	public void delete(Integer id) {
		Student s = read(id);
		listOfStudents.remove(s);
	}

	@Override
	public List<Student> readAll() {
		return listOfStudents;
	}

}
