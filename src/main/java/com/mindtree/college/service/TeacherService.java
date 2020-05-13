package com.mindtree.college.service;

import java.util.List;

import com.mindtree.college.entity.Student;

public interface TeacherService {

	public String addTeacher();

	public List<Student> getStudent(int teacherId);

}
