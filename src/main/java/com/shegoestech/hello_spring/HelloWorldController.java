package com.shegoestech.hello_spring;

import com.shegoestech.hello_spring.services.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class HelloWorldController {

    @Autowired
    private CourseDetailService courseDetailService;


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!!!" +
                "Spring Container instance" +
                courseDetailService.print();
    }
}
