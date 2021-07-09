package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.services.CourseDetailService;
import com.shegoestech.hello_spring.services.ShapePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/greetings")
public class HelloWorldController {

    @Autowired
    private CourseDetailService courseDetailService;
    @Autowired
    private ShapePrinter shapePrinter;


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!!!" +
                "Spring Container instance" +
                courseDetailService.print();
    }

    @GetMapping("/shapes")
    public String shapes() {
        return shapePrinter.getShapeName();
    }
}
