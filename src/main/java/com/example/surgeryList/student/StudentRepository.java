package com.example.surgeryList.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("SELECT * FROM Student s where s.email =?1")
    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findStudentById(Long id) ;
}
