package com.gene.demo.service;

import com.gene.demo.model.SearchCase;
import com.gene.demo.repository.SearchCaseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SearchCaseService {
    SearchCaseRepository searchCaseRepository;

    public SearchCase addSearchCase(SearchCase searchCase) {
        return searchCaseRepository.save(searchCase);
    }
}
