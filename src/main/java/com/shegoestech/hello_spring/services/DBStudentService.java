package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.exception.BadRequestException;
import com.shegoestech.hello_spring.exception.NotFoundException;
import com.shegoestech.hello_spring.model.Student;
import com.shegoestech.hello_spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class DBStudentService implements StudentRecordService {
    private final StudentRepository studentRepository;

    @Override
    public Student register(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student record does not exist"));
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid student id " + id));

        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setEmail(updatedStudent.getEmail());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
//        studentRepository.count()
//        studentRepository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

    public boolean doesStudentIdExist(Long id) {
        return studentRepository.existsById(id);
    }

    public Optional<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public Optional<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
