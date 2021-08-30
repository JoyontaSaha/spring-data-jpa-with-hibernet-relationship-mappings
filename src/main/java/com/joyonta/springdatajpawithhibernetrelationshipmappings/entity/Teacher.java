package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;


/**
 * fetch = FetchType.EAGER directs jpa to fetch teacher data fetch assigned courses as well
 * One-to-Many relationships load lazily by DEFAULT
 *
 * Optionality = true; in One-to-Many side — it is always optional
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String firstName;
    private String lastName;
    @OneToMany(
            mappedBy = "teacher",
            fetch = FetchType.EAGER
    )
    private List<Course> courses;

}