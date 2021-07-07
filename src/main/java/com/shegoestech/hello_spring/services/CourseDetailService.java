package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.repository.StudentDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//@Repository
//@Component
//field injection
@Service
public class CourseDetailService {
    //field injection
    @Autowired
    private StudentDatabase studentDatabase;
//    Course3Service value = new Course3Service();
//    //constructor injection
//    public CourseDetailService(StudentDatabase studentDatabase) {
//        this.studentDatabase = studentDatabase;
//    }
//
//    //setter injection
//    @Autowired
//    public void setStudentDatabase(StudentDatabase studentDatabase) {
//        this.studentDatabase = studentDatabase;
//    }

    public String print() {
        return "name -> CourseDetailService\n" +
                "dependencies -> {" + studentDatabase.print() +
                "}\n";
    }
}
