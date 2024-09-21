package com.gene.demo.repository;

import com.gene.demo.model.SearchCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchCaseRepository extends JpaRepository<SearchCase, Integer> {
}
