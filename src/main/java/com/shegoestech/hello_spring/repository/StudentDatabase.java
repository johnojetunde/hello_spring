package com.shegoestech.hello_spring.repository;

import org.springframework.stereotype.Repository;


@Repository
public class StudentDatabase {
    private final RandomService randomService;

    public StudentDatabase(RandomService randomService) {
        this.randomService = randomService;
    }

    public String print() {
        return "StudentDatabase";
    }
}
