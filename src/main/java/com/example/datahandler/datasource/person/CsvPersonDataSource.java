package com.example.datahandler.datasource.person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.datahandler.person.exception.DataReadException;
import com.example.datahandler.person.model.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CsvPersonDataSource {

    public List<Person> readData(){
        List<Person> persons = new ArrayList<>();

        try {
            Resource resource = new ClassPathResource("data/data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(";");
                Person person = Person.from(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3]);
                persons.add(person);
            }
            reader.close();

        } catch (IOException e) {
            throw new DataReadException("Kunde inte läsa CSV-filen", e);
        }
        return persons;
    }
}
