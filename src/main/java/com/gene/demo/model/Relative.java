package com.gene.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Relative")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int relativeId;

    @Column(name = "PersonId", nullable = false)
    private int personId;  // Foreign key to Person

    @Column(name = "RelationshipId", nullable = false)
    private int relationshipId;  // Foreign key to Relationship
}
