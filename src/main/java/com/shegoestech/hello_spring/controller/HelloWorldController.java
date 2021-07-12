package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.AppConfig;
import com.shegoestech.hello_spring.exception.NotFoundException;
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
    @Autowired
    private AppConfig appConfig;


//    public HelloWorldController(CourseDetailService courseDetailService,
//                                ShapePrinter shapePrinter,
//                                @Value("${app.default-name:Default AppName}") String appName) {
//        this.courseDetailService = courseDetailService;
//        this.shapePrinter = shapePrinter;
//        this.defaultAppName = appName;
//    }


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!!!" +
                "Spring Container instance" +
                courseDetailService.print();
    }

    @GetMapping("/shapes")
    public String shapes() {
        throw new NotFoundException("We can't find any shape");
    }

    @GetMapping("/default")
    public String defaultAppName() {
        return appConfig.toString();
    }

    @GetMapping("/config")
    public String configDetails() {
        return appConfig.toString();
    }
}
