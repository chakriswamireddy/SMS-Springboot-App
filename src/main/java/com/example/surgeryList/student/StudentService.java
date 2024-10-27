package com.example.surgeryList.student;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;


/*@Component*/

@Service 

/*

 * we use service for readability both works same

 */

public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents () {
		return studentRepository.findAll();

	}


	public void addNewStudent(Student student) {
		Optional<Student> isStudentByEmail =
				studentRepository.findStudentByEmail(student.getEmail());

		if (isStudentByEmail.isPresent()) {
			throw  new IllegalStateException("Email Taken");
		}
		studentRepository.save(student);
	}

	public void deleteExistStudent(Long studentId) {
		Optional<Student> isStudentById =
				studentRepository.findStudentById(studentId);

		if ( isStudentById.isEmpty()) {
			throw  new IllegalStateException("Email Not Found");
		}
		studentRepository.delete(isStudentById.get());
	}

	@Transactional
	public void updateStudent(Long studentId, Student student) {
		boolean isExists = studentRepository.existsById(studentId);

		if (! isExists) {
			throw  new IllegalStateException("Id not Found");
		}
		Student oldstudent = studentRepository.getReferenceById(studentId);
		System.out.println(oldstudent);

		oldstudent.setName(student.getName());
		oldstudent.setEmail(student.getEmail());
		oldstudent.setDob(student.getDob());

//		studentRepository.save(oldstudent);




	}
}


