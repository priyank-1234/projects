package com.mindtree.college.dto;

public class MarksDto {
	private int studentId;
	
	private double maths;
	
	private double science;
	
	
	private double socialScience;


	public double getMaths() {
		return maths;
	}


	public void setMaths(double maths) {
		this.maths = maths;
	}


	public double getScience() {
		return science;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public void setScience(double science) {
		this.science = science;
	}


	


	public MarksDto(int studentId, double maths, double science, double socialScience) {
		super();
		this.studentId = studentId;
		this.maths = maths;
		this.science = science;
		this.socialScience = socialScience;
	}


	public MarksDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getSocialScience() {
		return socialScience;
	}


	public void setSocialScience(double socialScience) {
		this.socialScience = socialScience;
	}
	
	

}
