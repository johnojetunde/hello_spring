package com.shegoestech.hello_spring.repository;

import com.shegoestech.hello_spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByFirstName(String firstname);

    Optional<Student> findByFirstNameAndLastName(String firstname, String lastName);

    List<Student> findAllByFirstName(String firstName);

    Long countAllByFirstName(String firstName);

    Long countAllByIdBetween(Long startId, Long endId);

    List<Student> findAllByIdBetween(Long startId, Long endId);

    @Query(value = "select s from Student  s where s.email=:mail AND s.firstName=:fName")
    List<Student> findByEmailAndFirstName(@Param("mail") String email, @Param("fName") String firstName);

    List<Student> findAllByFirstNameOrderByIdDesc(String firstName);

    List<Student> findByIdIsGreaterThanEqual(Long id);

    List<Student> findAllByFirstNameIn(List<String> firstName);
}
