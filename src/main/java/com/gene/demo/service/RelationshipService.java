package com.gene.demo.service;

import com.gene.demo.model.Relationship;
import com.gene.demo.repository.RelationshipRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RelationshipService {
    RelationshipRepository relationshipRepository;

    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }

    public void add(Relationship relationship) {
        relationshipRepository.save(relationship);
    }

    public Relationship findRelationshipBySelection(String relationshipType, String description) {
        return relationshipRepository.findByRelationshipTypeAndDescription(relationshipType, description);
    }
}
