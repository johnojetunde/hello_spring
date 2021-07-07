package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//setter injection
@Service
public class Course3Service {
    private StudentDatabase studentDatabase;

    @Autowired
    public void setStudentDatabase(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }
}

