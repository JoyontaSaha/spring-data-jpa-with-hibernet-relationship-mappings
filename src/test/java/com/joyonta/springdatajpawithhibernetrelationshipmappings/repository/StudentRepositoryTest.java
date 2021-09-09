package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void printStudents() {
        List<Student> students = studentRepository.findAll();
        // blocking student - course many to many circular loop by setting one end null
        students.forEach(student -> student.getCourses().forEach(course -> course.setStudents(null)));
        System.out.println(students);
    }
}