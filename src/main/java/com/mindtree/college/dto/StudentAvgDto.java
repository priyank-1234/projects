package com.mindtree.college.dto;

public class StudentAvgDto 
{
	private String studentName;

	private double maths;

	private double science;

	private double socialScience;

	private double avgMarks;
	public String getStudentName() 
	{
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public void setScience(double science) {
		this.science = science;
	}

	public double getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(double socialScience) {
		this.socialScience = socialScience;
	}

	public double getAvgMarks() {
		return avgMarks;
	}

	public void setAvgMarks(double avgMarks) {
		this.avgMarks = avgMarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgMarks);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maths);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(science);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(socialScience);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAvgDto other = (StudentAvgDto) obj;
		if (Double.doubleToLongBits(avgMarks) != Double.doubleToLongBits(other.avgMarks))
			return false;
		if (Double.doubleToLongBits(maths) != Double.doubleToLongBits(other.maths))
			return false;
		if (Double.doubleToLongBits(science) != Double.doubleToLongBits(other.science))
			return false;
		if (Double.doubleToLongBits(socialScience) != Double.doubleToLongBits(other.socialScience))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	public StudentAvgDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentAvgDto(String studentName, double maths, double science, double socialScience, double avgMarks) {
		super();
		this.studentName = studentName;
		this.maths = maths;
		this.science = science;
		this.socialScience = socialScience;
		this.avgMarks = avgMarks;
	}
	
	
	
	

}
