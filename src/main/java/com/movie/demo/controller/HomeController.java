package com.movie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.repository.StudentRepository;
import com.movie.demo.service.Student;

@RestController
public class HomeController {
	@Autowired
	StudentRepository studentrep;
	@GetMapping("/")
	public String index()
	{
		return "Welcome";
	}
	// Handler for creating new record in db
	@PostMapping("/savestudent")
	public Student savedata(@RequestBody Student student)
	{
		studentrep.save(student);
		return student;
	}
	// Handler for fetching all from db
	@GetMapping("/getallstudent")
	public List<Student> getAll()
	{
		List<Student> student = studentrep.findAll();
		return student;
	}
	@DeleteMapping("/deletestudent/{rollno}")
	public String deletestudent(@PathVariable int rollno)
	{
		Student student = studentrep.findById(rollno).get();
		if(student!=null)
		{
			studentrep.delete(student);
		}
		return "Deleted Successfully";
	}
	@PutMapping("/updatestudent")
	public Student updatestudent(@RequestBody Student student)
	{
		studentrep.save(student);
		return student;
	}
}
