package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.model.Student;
import com.shegoestech.hello_spring.services.StudentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentRecordService studentRecordService;

    public StudentController(StudentRecordService studentRecordService) {
        this.studentRecordService = studentRecordService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Student create(@RequestBody Student student) {
        return studentRecordService.register(student);
    }

    @GetMapping
    public Collection<Student> getAll() {
        return studentRecordService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable("id") Long id) {
        return studentRecordService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public Student updateStudent(@PathVariable("id") Long id,
                                 @RequestBody Student student) {
        return studentRecordService.updateStudent(id, student);
    }

    @DeleteMapping(value = "/{id}")
    public String updateStudent(@PathVariable("id") Long id) {
        studentRecordService.delete(id);
        return "Student deleted successfully";
    }
}
