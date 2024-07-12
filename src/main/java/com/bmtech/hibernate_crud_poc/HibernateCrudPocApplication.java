package com.bmtech.hibernate_crud_poc;

import com.bmtech.hibernate_crud_poc.dao.StudentDAO;

import com.bmtech.hibernate_crud_poc.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudPocApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//findStudentsBylastName(studentDAO);
			findStudentsByFirstName(studentDAO);
		};
	}

	private void findStudentsByFirstName(StudentDAO studentDAO) {

		Student student = new Student("Lily", "Moss", "lm@gmail.com");

		studentDAO.save(student);

		List<Student> students = studentDAO.findByFirstName(student.getFirstName());

		for (Student s : students) {
			System.out.println(s.getFirstName() + " " + s.getLastName());
		}
	}

	private void findStudentsBylastName(StudentDAO studentDAO) {
		List<Student> studentsByLastName = studentDAO.findByLastName("Adam");

		for (Student student : studentsByLastName) {
			System.out.println(student.getLastName() + ", " + student.getFirstName());
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating student...");
		Student myStudent = new Student("Jamile", "Foster", "jf@mail.com");

		System.out.println("Saving student...");
		studentDAO.save(myStudent);

		System.out.println("Retrieving student...");
		Student retrievedStudent = studentDAO.findById(myStudent.getId());

		System.out.println("The student has been retrieved: " + retrievedStudent);


	}


	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple students...");

		Student myStudentA = new Student("Math", "Johnson", "mj@mail.com");
		Student myStudentB = new Student("Lane", "Adam", "la@mail.com");
		Student myStudentC = new Student("George", "Costanza", "gc@mail.com");

		System.out.println("Saving multiple students...");
		studentDAO.save(myStudentA);
		studentDAO.save(myStudentB);
		studentDAO.save(myStudentC);

		System.out.println("Retrieving all students");
		List<Student> studentsList = studentDAO.findAll();

		for (Student student : studentsList) {
			System.out.println(student.toString());

		}
	}

}
