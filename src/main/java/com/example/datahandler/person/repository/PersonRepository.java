package com.example.datahandler.person.repository;

import java.util.List;

import com.example.datahandler.datasource.CsvPersonDataSource;
import com.example.datahandler.person.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private final CsvPersonDataSource csvDataSource;

    public PersonRepository(CsvPersonDataSource csvDataSource) {
        this.csvDataSource = csvDataSource;
    }

    public List<Person> findAll(){
        return csvDataSource.readData();
    }
}
