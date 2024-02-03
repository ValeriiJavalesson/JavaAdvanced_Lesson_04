package com.valerko.lgs.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.valerko.lgs.domain.Student;
import com.valerko.lgs.service.impl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;
	
	@RequestMapping("/")
	public String init() {
		return "index";
	}
	
	@PostMapping("/register")
	public String saveUser(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") Integer age,
			@RequestParam("photo") MultipartFile file) throws IOException {
		Student student = new Student(firstName, lastName, age);
		studentService.create(student, file);
			
		return "redirect:/student?student_id=" + student.getId();
	}

	@GetMapping("/student")
	public String findAllStudents(@RequestParam("student_id")Integer id, ModelMap model) throws UnsupportedEncodingException {
		
		List<Student> students = studentService.findAll();
		Student student = studentService.findById(id);
		byte[] fileBytes = student.getPhoto().getFileData();
		byte[] fileEncodeBase64 = Base64.encodeBase64(fileBytes);
		String fileBase64Encoded = new String(fileEncodeBase64, "UTF-8");
		
		model.addAttribute("students_list", students);
		model.addAttribute("current_student", student);
		model.addAttribute("photo", fileBase64Encoded);
		return "student";
	}	
}
