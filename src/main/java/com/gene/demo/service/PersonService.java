package com.gene.demo.service;

import com.gene.demo.model.Person;
import com.gene.demo.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {
    PersonRepository personRepository;
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

}
