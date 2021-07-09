package com.shegoestech.hello_spring.services;

import com.shegoestech.hello_spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentRecordService {
    private static final Map<Long, Student> STUDENT_MAP = new HashMap<>();
    private static final Long[] LAST_ID = new Long[]{0L};

    public Student register(Student student) {
        Long newId = LAST_ID[0] + 1; //generate new id
        student.setId(newId); //sets the student id

        STUDENT_MAP.put(student.getId(), student); // insert the student into the map
        LAST_ID[0] = newId; //update the id generator

        return student;
    }

    public Collection<Student> getAll() {
        return STUDENT_MAP.values();
    }

    public Optional<Student> getById(Long id) {
        return Optional.ofNullable(STUDENT_MAP.get(id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student studentRecord = STUDENT_MAP.get(id);
        if (studentRecord == null)
            return null;

        studentRecord.setFirstName(updatedStudent.getFirstName());
        studentRecord.setLastName(updatedStudent.getLastName());
        studentRecord.setPhone(updatedStudent.getPhone());

        STUDENT_MAP.put(id, studentRecord);
        return studentRecord;
    }

    public void delete(Long id) {
        STUDENT_MAP.remove(id);
    }
}
