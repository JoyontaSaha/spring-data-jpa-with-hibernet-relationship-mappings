package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
       /* Course course1 = Course.builder()
                .title()
                .teach
                .build();
        insert into COURSE(ID, TEACHER_ID, TITLE) values(1, 1, 'Java 101');
        insert into COURSE(ID, TEACHER_ID, TITLE) values(2, 1, 'SQL 101');
        insert into COURSE(ID, TEACHER_ID, TITLE) values(3, 1, 'JPA 101');*/
    }

    @Test
    public void printCourses() {
        System.out.println(courseRepository.findAll());
    }
}