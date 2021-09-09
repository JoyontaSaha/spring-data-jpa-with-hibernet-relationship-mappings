package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = "courses")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean wantsNewsletter;
    @ManyToMany(
            mappedBy = "students",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Course> courses = new ArrayList<Course>();

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

}