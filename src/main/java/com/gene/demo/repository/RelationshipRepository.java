package com.gene.demo.repository;

import com.gene.demo.model.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
    public Relationship findByRelationshipTypeAndDescription(String RelationshipType, String description);
}
