package com.example.datahandler.person.controller;

import java.util.List;

import com.example.datahandler.person.exception.DataLimitException;
import com.example.datahandler.person.model.Person;
import com.example.datahandler.person.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/api/data")
    public ResponseEntity<List<Person>> getPersonData(@RequestParam(required = false) Integer limit) {
        if (limit != null && limit <= 0) {
            throw new DataLimitException("Parametern limit måste vara ett positivt heltal");
        }

        List<Person> persons = service.getAllOrLimitedPersons(limit);

        return persons.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(persons);
    }

}
