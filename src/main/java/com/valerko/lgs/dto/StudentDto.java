package com.valerko.lgs.dto;

import com.valerko.lgs.domain.Student;

public class StudentDto {

	private Student student;

	private String photo;

	public StudentDto() {
	}

	public StudentDto(Student student, String photo) {
		this.student = student;
		this.photo = photo;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "StudentDto [student=" + student + ", photo=" + photo + "]";
	}

}
