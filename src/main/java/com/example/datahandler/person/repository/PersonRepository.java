package com.example.datahandler.person.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.datahandler.person.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private Person person1 = Person.from(1L, "Anna", 30, "anna@hej.se");

    public Person findAll(){
        return person1;
    }
}
