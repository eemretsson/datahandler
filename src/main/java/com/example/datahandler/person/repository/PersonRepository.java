package com.example.datahandler.person.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.datahandler.datasource.CsvDataSource;
import com.example.datahandler.person.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private final CsvDataSource csvDataSource;

    public PersonRepository(CsvDataSource csvDataSource) {
        this.csvDataSource = csvDataSource;
    }

    public List<Person> findAll(){
        return csvDataSource.readData();
    }
}
