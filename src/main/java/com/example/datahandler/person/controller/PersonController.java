package com.example.datahandler.person.controller;

import com.example.datahandler.person.model.Person;
import com.example.datahandler.person.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/api/data")
    public Person all() {
        return service.getAllPersons();
    }

}
