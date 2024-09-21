package com.gene.demo.service;

import com.gene.demo.model.Relative;
import com.gene.demo.repository.RelativeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeService {
    RelativeRepository relativeRepository;

    public void addRelative(Relative relative) {
        log.info("Save relative OK");
        relativeRepository.save(relative);
    }
}
