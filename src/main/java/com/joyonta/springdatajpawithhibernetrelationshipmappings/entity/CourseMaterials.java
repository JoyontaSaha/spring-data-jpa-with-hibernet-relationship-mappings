package com.joyonta.springdatajpawithhibernetrelationshipmappings.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * CourseMaterials owning side — preferably the side which will hold the (@JoinColumn) foreign key in the database
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            optional = false
    )
    @JoinColumn(
            name = "courseId",
            referencedColumnName = "courseId"
    )
    private Course course;
}