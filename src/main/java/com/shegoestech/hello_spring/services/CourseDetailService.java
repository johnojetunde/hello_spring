package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailService {
    public final StudentDatabase studentDatabase;

    public CourseDetailService(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public String print(){
        return "name -> CourseDetailService\n" +
                "dependencies -> {"+studentDatabase.print()+
                "}\n";
    }
}
