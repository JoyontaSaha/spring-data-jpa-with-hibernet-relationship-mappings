package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Course;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.CourseMaterials;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Student;
import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
class CourseMaterialsRepositoryTest {
    @Autowired
    private CourseMaterialsRepository courseMaterialsRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void saveCourseMaterials() {

        CourseMaterials courseMaterials = CourseMaterials.builder()
                .course(courseRepository.findById(5L).get())
                .url("www.tutorial.com/jpa")
                .build();

        courseMaterialsRepository.save(courseMaterials);
    }

    @Test
    public void saveCourseMaterialWithCourseAndStudentAndTeacher() {
        /*Guardian guardian = Guardian.builder()
                .email("Sagnik@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();*/

        Student student = Student.builder()
                .firstName("Kalyan")
//                .emailId("Kalyan@gmail.com")
                .lastName("Kumar")
//                .guardian(guardian)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Sarthi")
                .lastName("Bhattachariya")
                .build();

        Course course = Course.builder()
                .title("Discrete Math")
//                .credit(8)
                .teacher(teacher)
                .build();

//        course.setStudents(Arrays.asList(student));

          course.addStudent(student);
          student.setCourses(Arrays.asList(course));

        CourseMaterials courseMaterials = CourseMaterials.builder()
                .url("www.tutorial.com/discrete-math")
                .course(course)
                .build();


        courseMaterialsRepository.save(courseMaterials);
    }

    @Test
    public void printCourseMaterials() {
        System.out.println(courseMaterialsRepository.findAll());
    }

}