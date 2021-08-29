package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;


/**
 * This is uni-directional One-to-Many Relationship
 * Teacher entity is owning side,
 * Course entity is referencing side of this relationship
 *
 *  A teacher can give multiple courses,
 *  but a course is given by only one teacher
 *  (that's the Many-to-One perspective - many courses to one teacher)
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "courses")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String firstName;
    private String lastName;
    /**
     * example could be on social media —
     * One to many -> a photo can have many comments,
     * i.e include a list of entities(comments) within another entity(photo) - using @OneToMany annotation
     * Many to one -> but each of those comments belongs to that one photo.
     *
     *
     * @JoinColumn tells JPA that
     * the COURSE table must have a foreign key column teacherId
     * that references the Teacher table's teacherId column
     *
     * Teacher class is called the owning side of the One-To-Many relationship.
     * This is because it defines the join column between the two tables(Teacher, Course).
     * The Course is called the referencing side in that relationship.
     *
     */
    @OneToMany(
            cascade=CascadeType.ALL
    )
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    private List<Course> courses;

}