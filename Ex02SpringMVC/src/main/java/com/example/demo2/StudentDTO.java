package com.example.demo2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDTO {
	@Id
	private int studentId; 
	private String studentName; 
	private int studentAge;


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}



	// Getter and setter methods for the properties

}
