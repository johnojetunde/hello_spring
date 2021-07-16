package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.exception.BadRequestException;
import com.shegoestech.hello_spring.exception.NotFoundException;
import com.shegoestech.hello_spring.model.Student;
import com.shegoestech.hello_spring.model.StudentSearch;
import com.shegoestech.hello_spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.matchingAll;


@Transactional
@RequiredArgsConstructor
@Service
public class DBStudentService implements StudentRecordService {
    private final StudentRepository studentRepository;

    @Override
    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> search(StudentSearch studentSearch) {
        Student student = new Student();
        student.setPhone(studentSearch.getPhone());
        student.setEmail(studentSearch.getEmail());
        student.setFirstName(studentSearch.getFirstName());
        student.setLastName(studentSearch.getLastName());

        Example<Student> studentExample = Example.of(student, matchingAll().withIgnoreNullValues());
        return studentRepository.findAll(studentExample);
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
        if (!studentRepository.existsById(id))
            throw new BadRequestException("Student record with id " + id + "does not exist");

        studentRepository.deleteById(id);
//        studentRepository.count()
//        studentRepository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

    public boolean doesStudentIdExist(Long id) {
        return studentRepository.existsById(id);
    }

    public List<Student> findByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

    public Optional<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
