package com.example.demo2;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("studentService")
@Transactional
public class StudentService {

	@Autowired
	private StudentsDAO dao;

	

	
	public StudentsDAO getDao() {
		return dao;
	}


	public void setDao(StudentsDAO dao) {
		this.dao = dao;
	}


	public List<StudentDTO> studentDisplay() {
		List<StudentDTO> list = dao.findAll();
		return list;
	}

	
	public StudentDTO studentDisplayById(int studentId) {
		Optional<StudentDTO> optional = dao.findById(studentId);
		StudentDTO student = optional.get();
		return student;
	}


	public void createStudent(int studentID,String studentName,int studentAge) {
	    StudentDTO student=new StudentDTO();
	    student.setStudentId(studentID);
	    student.setStudentName(studentName);
	    student.setStudentAge(studentAge);
		dao.save(student);
		System.out.println("student Created");
		
	}

	
}