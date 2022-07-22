package com.example.MyStudentCrudAPI.repository;

import com.example.MyStudentCrudAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();
    Student findById(int id);
    void deleteById(int id);
    void deleteByRoll(int roll);
    Student findByRoll(int roll);

}
