package com.example.surgeryList.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;


@Entity
@Table

public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1 //step to add new item with the id
	)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	
	private long id;
	private String name;
	private String email;
	private LocalDate dob;

	@Transient
	private Integer age;
	
	  public Student() {
	    }
	
	public Student(long id, String name, String email, LocalDate dob
//				   Integer age
	) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
//		this.age = age;
	}


	public Student(String name, String email, LocalDate dob
//				   Integer age
	) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
//		this.age = age;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Integer getAge() {
//		return age;
		return Period.between(this.dob, LocalDate.now()).getYears();
	}



	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
	
	
	
	
	
}

