package com.valerko.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valerko.lgs.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
