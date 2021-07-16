package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.model.CreateValidation;
import com.shegoestech.hello_spring.model.Student;
import com.shegoestech.hello_spring.model.UpdateValidation;
import com.shegoestech.hello_spring.services.DBStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
public class StudentController {

    private final DBStudentService studentRecordService;

//    public StudentController(StudentRecordService studentRecordService) {
//        this.studentRecordService = studentRecordService;
//    }

    //@Valid -
    //@Validates -  allows the use of validation group

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Student create(@Validated(CreateValidation.class) @RequestBody Student student) {
        return studentRecordService.register(student);
    }

    @GetMapping
    public Collection<Student> getAll(@RequestParam(value = "firstName", required = false) String firstName) {
        if (firstName != null) {
            return studentRecordService.findByFirstName(firstName);
        } else {
            return studentRecordService.getAll();
        }
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Long id) {
        return studentRecordService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public Student updateStudent(@PathVariable("id") Long id,
                                 @Validated(UpdateValidation.class) @RequestBody Student student) {
        return studentRecordService.updateStudent(id, student);
    }

    @DeleteMapping(value = "/{id}")
    public String updateStudent(@PathVariable("id") Long id) {
        studentRecordService.delete(id);
        return "Student deleted successfully";
    }
}
