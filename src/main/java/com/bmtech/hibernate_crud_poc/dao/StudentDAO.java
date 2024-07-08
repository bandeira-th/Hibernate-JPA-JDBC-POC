package com.bmtech.hibernate_crud_poc.dao;

import com.bmtech.hibernate_crud_poc.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

}
