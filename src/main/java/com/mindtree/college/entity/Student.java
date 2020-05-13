package com.mindtree.college.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	
	private String studentName;
	
	private int age;
	
	private double maths;
	
	private double science;
	
	private double socialScience;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Teacher teacher;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public double getMaths() {
		return maths;
	}

	public void setMaths(double maths) {
		this.maths = maths;
	}

	public double getScience() {
		return science;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, int age,double maths, double science,
			double socialScience, Teacher teacher) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		
		this.maths = maths;
		this.science = science;
		this.socialScience = socialScience;
		this.teacher = teacher;
	}

	public void setScience(double science) {
		this.science = science;
	}

	public double getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(double socialScience) {
		this.socialScience = socialScience;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	


}
