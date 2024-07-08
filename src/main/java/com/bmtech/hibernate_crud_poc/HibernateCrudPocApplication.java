package com.bmtech.hibernate_crud_poc;

import com.bmtech.hibernate_crud_poc.dao.StudentDAO;

import com.bmtech.hibernate_crud_poc.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudPocApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student myStudent = new Student("Jon", "Smith", "js@mail.com");
		Student myStudentB = new Student("Jane", "Smith", "js@mail.com");
		System.out.println("Saving student...");
		studentDAO.save(myStudent);
		studentDAO.save(myStudentB);

		System.out.println("Retrieving student...");
		Student retrievedStudent = studentDAO.findById(myStudent.getId());
		Student retrievedStudentB = studentDAO.findById(myStudentB.getId());

		System.out.println("The students have been retrieved: " + retrievedStudent + " and " + retrievedStudentB);
	}


}
