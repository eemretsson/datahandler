package com.example.datahandler.person.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Person {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    private Person(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static Person from(Long id, String name, Integer age, String email) {
        return new Person(id, name, age, email);
    }
}
