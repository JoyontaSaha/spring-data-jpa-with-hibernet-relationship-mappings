package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.CourseMaterials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
    public void printCourseMaterials() {
        System.out.println(courseMaterialsRepository.findAll());
    }

}