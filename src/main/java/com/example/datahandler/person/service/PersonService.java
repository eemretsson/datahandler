package com.example.datahandler.person.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.datahandler.person.model.Person;
import com.example.datahandler.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllOrLimitedPersons(Integer limit) {
        List<Person> all = repository.findAll();

        if (limit == null) {
            return all;
        }
        return all.stream()
                .limit(limit)
                .toList();
    }
}
