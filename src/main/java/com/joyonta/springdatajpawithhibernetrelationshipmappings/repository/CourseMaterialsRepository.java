package com.joyonta.springdatajpawithhibernetrelationshipmappings.repository;

import com.joyonta.springdatajpawithhibernetrelationshipmappings.entity.CourseMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialsRepository extends JpaRepository<CourseMaterials, Long> {
}
