package com.mindtree.college.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teacherId;
	private String teacherName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="teacher")
	List<Student> student=new LinkedList<Student>();

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int teacherId, String teacherName, List<Student> student) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.student = student;
	}


}
