package com.gene.demo.repository;

import com.gene.demo.model.Relationship;
import com.gene.demo.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Integer> {
}
