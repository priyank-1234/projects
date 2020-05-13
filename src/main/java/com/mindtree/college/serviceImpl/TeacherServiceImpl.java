package com.mindtree.college.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.college.entity.Student;
import com.mindtree.college.entity.Teacher;
import com.mindtree.college.repository.TeacherRepository;
import com.mindtree.college.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	
	@Autowired
	TeacherRepository teacherRepository;
	
	
	@Override
	public String addTeacher() {
		// TODO Auto-generated method stub
		
		try
	       {
	    	   FileInputStream file=new FileInputStream(new File("TeacherList.xlsx"));
	    	   
	    	   @SuppressWarnings("resource")
			   XSSFWorkbook workbook=new XSSFWorkbook(file);
	    	   
	    	   FormulaEvaluator evaluator=workbook.getCreationHelper().createFormulaEvaluator();
	    	   XSSFSheet sheet =workbook.getSheetAt(0);
	    	   
	    	   Iterator<Row> rowIterator=sheet.iterator();
	    	   while(rowIterator.hasNext())
	    	   {
	    		   Teacher teacher=new Teacher();
	    		   Row row=rowIterator.next();
	    		   Iterator<Cell> cellIterator=row.cellIterator();
	    		   while(cellIterator.hasNext())
	    		   {
	    		      Cell cell=cellIterator.next();
	    		      switch(evaluator.evaluateInCell(cell).getCellType())
	    		      {
	    		      case Cell.CELL_TYPE_STRING:
	    		    	teacher.setTeacherName(cell.getStringCellValue());
	    		    	  break;
	    		      
	    		      }
	    		   }
	    		    teacherRepository.save(teacher);
	    		     
	    		   }
	    	   file.close();
	    	   }
	    	   
	        catch(Exception e)
	       {
	    	   System.out.println(e.getMessage());
	       }
	    
		return "Successfully";
	}


	@Override
	public List<Student> getStudent(int teacherId) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherRepository.findById(teacherId).orElse(null);
		return teacher.getStudent();
	}
	
	

}
