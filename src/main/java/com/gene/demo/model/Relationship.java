package com.gene.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Relationship")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "relationship_type", length = 50)
    private String relationshipType;

    @Column(name = "Description", length = 20)
    private String description;
}
