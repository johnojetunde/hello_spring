package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//@Repository
//@Component
@Service
public class CourseDetailService {
    @Autowired
    private StudentDatabase studentDatabase;

    public CourseDetailService(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public String print() {
        return "name -> CourseDetailService\n" +
                "dependencies -> {" + studentDatabase.print() +
                "}\n";
    }
}
