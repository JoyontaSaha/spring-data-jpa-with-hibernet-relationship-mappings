package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.*;

import javax.persistence.*;

/**
 * CourseMaterials owning side — preferably the side which will hold the (@JoinColumn) foreign key in the database
 *
 * In One-to-One bi-directional relationship owning entity set optional = false, fetch = FETCHTYPE.LAZY
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            optional = false,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "courseId",
            referencedColumnName = "courseId"
    )
    private Course course;
}