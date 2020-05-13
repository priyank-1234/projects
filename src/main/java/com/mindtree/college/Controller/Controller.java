package com.mindtree.college.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.college.dto.MarksDto;
import com.mindtree.college.entity.Student;
import com.mindtree.college.service.StudentService;
import com.mindtree.college.service.TeacherService;

@RestController
public class Controller {

	@Autowired
	StudentService studentService;

	@Autowired
	TeacherService teacherService;

	@GetMapping("/addStudentList")
	public String addStudent() {

		return studentService.addStudent();
	}

	@GetMapping("/addTeacherList")
	public String addTeacher() {
		return teacherService.addTeacher();
	}

//	@GetMapping("/assignStudent")
//	public String assignStudent()
//	{
//		return studentService.assignStudent();
//	}
	
	@GetMapping("/getStudent/{teacherId}")
	public List<Student> getStudent(@PathVariable int teacherId) {
		return teacherService.getStudent(teacherId);
	}

	@PostMapping("/UpdateMarks/{teacherid}")
	public ResponseEntity<?> updateMarks(@RequestBody MarksDto marks, @PathVariable int teacherid) {
		return new ResponseEntity<Student>(studentService.updatemarks(marks, teacherid), HttpStatus.OK);

	}
	
}
