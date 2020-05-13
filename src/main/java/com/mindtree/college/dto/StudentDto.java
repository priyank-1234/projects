package com.mindtree.college.dto;

public class StudentDto {
	
	
	private String studentName;
	private int age;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StudentDto(String studentName, int age) {
		super();
		this.studentName = studentName;
		this.age = age;
		
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
