package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Course;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourses() {
        Teacher teacher = Teacher.builder()
                .firstName("Jane")
                .lastName("Doe")
                .build();

        Course course1 = Course.builder()
                .title("Java 101")
                .teacher(teacher)
                .build();
        Course course2 = Course.builder()
                .title("SQL 101")
                .teacher(teacher)
                .build();
        Course course3 = Course.builder()
                .title("JPA 101")
                .teacher(teacher)
                .build();


        Iterable<Course> iterable = Arrays.asList(course1, course2, course3);

        courseRepository.saveAll(iterable);
    }

    @Test
    public void printCourses() {
        System.out.println(courseRepository.findAll());
    }
}