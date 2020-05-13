package com.mindtree.college.service;

import com.mindtree.college.dto.MarksDto;
import com.mindtree.college.entity.Student;

public interface StudentService {

	public String addStudent();

	public String assignStudent();

	public Student updatemarks(MarksDto marks, int teacherid);

}
