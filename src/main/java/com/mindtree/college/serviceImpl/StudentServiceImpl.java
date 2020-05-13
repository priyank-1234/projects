package com.mindtree.college.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.iterators.RowIterator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.college.repository.StudentRepository;
import com.mindtree.college.repository.TeacherRepository;
import com.mindtree.college.service.*;

import com.mindtree.college.dto.*;
import com.mindtree.college.entity.Student;
import com.mindtree.college.entity.Teacher;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addStudent() {
		// TODO Auto-generated method stub

		try {
			FileInputStream file = new FileInputStream(new File("StudentList.xlsx"));

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				StudentDto user = new StudentDto();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (evaluator.evaluateInCell(cell).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						user.setAge((int) (cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						user.setStudentName(cell.getStringCellValue());
						break;

					}
				}
				Student student = modelMapper.map(user, Student.class);
				studentRepository.save(student);

			}
			file.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Successfully";
	}

	@SuppressWarnings("unused")
	@Override
	public String assignStudent() {
		// TODO Auto-generated method stub
		try {
			FileInputStream file = new FileInputStream(new File("StudentList.xlsx"));

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			XSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIt=sheet.iterator();
//            
//            while(rowIt.hasNext())
//            {
//            	Row row= rowIt.next();
//            	Iterator<Cell> cellIt=row.cellIterator();
//            	cellIt.next().setCellValue("Name");
//            	cellIt.next().setCellValue("Age");
//
//            }
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				StudentDto user = new StudentDto();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Student student = studentRepository.findById((int) cellIterator.next().getNumericCellValue())
						.orElse(null);
				Teacher teacher = teacherRepository.findById((int) cellIterator.next().getNumericCellValue())
						.orElse(null);
				student.setTeacher(teacher);
				studentRepository.save(student);
			}
			file.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Successfully";
	}

	@Override
	public Student updatemarks(MarksDto marks, int teacherid) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherRepository.findById(teacherid).orElse(null);
		List<Student> student = teacher.getStudent();
		student.forEach(u -> {

			if (marks.getStudentId() == u.getStudentId()) {
				u.setMaths(marks.getMaths());
				u.setScience(marks.getScience());
				u.setSocialScience(marks.getSocialScience());
				studentRepository.save(u);
			}
		});
		return studentRepository.findById(marks.getStudentId()).orElse(null);
	}

}
