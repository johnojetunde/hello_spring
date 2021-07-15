package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.model.Student;

import java.util.Collection;

public interface StudentRecordService {
    Student register(Student student);

    Collection<Student> getAll();

    Student getById(Long id);

    Student updateStudent(Long id, Student updatedStudent);

    void delete(Long id);
}
