package com.movie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.demo.service.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
