package com.bmtech.hibernate_crud_poc.dao;

import com.bmtech.hibernate_crud_poc.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field to entity manager
    EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //from spring framework
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> students = entityManager.createQuery("FROM Student", Student.class);
        return students.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> queryLastName = entityManager.createQuery("select s FROM Student s WHERE s.lastName = :lastName", Student.class);
        return queryLastName.setParameter("lastName", lastName).getResultList();
    }
}
