package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Course;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Student;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.Arrays;


@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    EntityManager entityManager;

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
    public void saveCoursesWithStudentsAndTeacher() {

        /*Student johnDoe = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .build();


        Student willDoe = Student.builder()
                .firstName("Will")
                .lastName("Doe")
                .build();

//        entityManager.persist(johnDoe);
//        entityManager.persist(willDoe);

        Teacher teacher = Teacher.builder()
                .firstName("Mr.x")
                .lastName("y")
                .build();

        Course javaCourse = Course.builder()
                .title("CA 101")
                .teacher(teacher)
//                .students(Arrays.asList(johnDoe, willDoe))
                .build();

//        entityManager.persist(javaCourse);

        Course sqlCourse = Course.builder()
                .title("SQL 101")
                .teacher(teacher)
//                .students(Arrays.asList(willDoe))
                .build();

        javaCourse.setStudents(Arrays.asList(johnDoe, willDoe));
        sqlCourse.setStudents(Arrays.asList(willDoe));

//        johnDoe.setCourses(Arrays.asList(javaCourse));
//        willDoe.setCourses(Arrays.asList(javaCourse, sqlCourse));

//        entityManager.persist(sqlCourse);

        Iterable<Course> courseIterable = Arrays.asList(javaCourse,sqlCourse);

        courseRepository.saveAll(courseIterable);*/



        Student student = Student.builder()
                .firstName("Shivam")
//                .emailId("shivam@gmail.com")
                .lastName("Kumar")
//                .guardian(guardian)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Partho")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("Networking")
//                .credit(6)
                .teacher(teacher)
                .build();

        course.setStudents(Arrays.asList(student));

        courseRepository.save(course);
    }

    @Test
    public void printCourses() {
        System.out.println(courseRepository.findAll());
    }
}