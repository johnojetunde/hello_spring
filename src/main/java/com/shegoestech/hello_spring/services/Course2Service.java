package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.stereotype.Service;

//constructor injection
@Service
public class Course2Service {
    private final StudentDatabase studentDatabase;

    public Course2Service(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }
}
