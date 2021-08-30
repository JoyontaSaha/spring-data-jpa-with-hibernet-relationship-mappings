package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.*;

import javax.persistence.*;

/**
 * This is uni-directional Many-to-One Relationship
 * Course entity is owning side,
 * Teacher entity is referencing side of this relationship
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
@ToString(exclude = "teacher")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String title;
    /**
     * example could be on social media —
     * One to many -> a photo can have many comments,
     * i.e include a list of entities(comments) within another entity(photo)
     * Many to one -> but each of those comments belongs to that one photo. - using @ManyToOne annotation
     *
     *
     * @JoinColumn tells JPA that
     * the COURSE table must have a foreign key column teacherId
     * that references the Teacher table's teacherId column
     *
     * Course class is called the owning side of the Many-To-One relationship.
     * This is because it defines the join column between the two tables(Course, Teacher).
     * The Teacher is called the referencing side in that relationship.
     *
     * Note: It’s a good practice to put the owning side of a relationship in the class/table
     * where the foreign key will be held.
     *
     * cascade = CascadeType.ALL, directs jpa that a teacher need to be created before assigning to a course
     * than persist that teacher as created
     * optional in Many-to-One side, on the other hand, offers us the option of making it mandatory
     * optional = false, directs jpa that No courses can be created without a teacher assigned to it
     * fetch = FetchType.LAZY, directs jpa that while fetching courses data ,
     * do not fetch teacher data [best practise for Many-to-One relationship mapping]
     * Many-to-One relationships are eager by DEFAULT
     */
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "teacherId",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
    /*@OneToOne(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private CourseMaterial courseMaterial;*/
}