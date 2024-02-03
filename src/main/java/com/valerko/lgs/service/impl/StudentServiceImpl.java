package com.valerko.lgs.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.valerko.lgs.domain.Photo;
import com.valerko.lgs.domain.Student;
import com.valerko.lgs.repository.StudentRepository;
import com.valerko.lgs.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student create(Student student, MultipartFile file) throws IOException {
		Photo photo = new Photo();
		photo.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
		photo.setFileType(file.getContentType());
		photo.setFileData(file.getBytes());
		
		student.setPhoto(photo);
		photo.setStudent(student);
		
		return studentRepository.save(student);
	}

	public Student findById(int id) {
		return studentRepository.getOne((long) id);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
