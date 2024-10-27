package com.example.surgeryList.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/students")

public class StudentController {

    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent( @RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void clearExistStudent(@PathVariable("studentId") Long studentId) {
        System.out.println(studentId);
        studentService.deleteExistStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student) {
        studentService.updateStudent(studentId, student);
    }

}
