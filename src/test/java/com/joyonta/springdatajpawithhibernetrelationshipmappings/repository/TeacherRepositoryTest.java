package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Course;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private EntityManager entityManager;


    @Test
    public void saveTeacher() {
       Course course1 = Course.builder()
                .title("Java 101")
                .build();
       Course course2 = Course.builder()
                .title("SQL 101")
                .build();
       Course course3 = Course.builder()
                .title("JPA 101")
                .build();

       Teacher teacher = Teacher.builder()
               .firstName("Jane")
               .lastName("Doe")
               .courses(Arrays.asList(course1, course2, course3))
               .build();


       teacherRepository.save(teacher);


    }

    @Test
    public void findTeacher() {
        Teacher foundTeacher = entityManager.find(Teacher.class, 1L);
        assertThat(foundTeacher.getTeacherId()).isEqualTo(1L);
        assertThat(foundTeacher.getLastName()).isEqualTo("Doe");
        assertThat(foundTeacher.getFirstName()).isEqualTo("Jane");

        assertThat(foundTeacher.getCourses()).extracting(Course::getTitle)
                .containsExactly("Java 101", "SQL 101", "JPA 101");

    }

    @Test
    public void printTeachers() {
        System.out.println(teacherRepository.findAll());
    }

}