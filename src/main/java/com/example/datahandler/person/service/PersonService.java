package com.example.datahandler.person.service;

import com.example.datahandler.person.model.Person;
import com.example.datahandler.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person getAllPersons(){
        return repository.findAll();
    }
}
