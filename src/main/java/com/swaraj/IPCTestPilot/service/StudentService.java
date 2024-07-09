package com.swaraj.IPCTestPilot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swaraj.IPCTestPilot.dao.StudentDao;
import com.swaraj.IPCTestPilot.dto.StudentDto;
import com.swaraj.IPCTestPilot.entity.Student;
import com.swaraj.IPCTestPilot.util.ResponseStructure;

@Service
public class StudentService {
	
	@Autowired
	StudentDao dao;
	
	@Autowired
	ModelMapper mapper;
	
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(Student student){
		Student savedStudent = dao.saveStudent(student);
		if(savedStudent!=null) {
			StudentDto dto = new StudentDto(); 
			mapper.map(savedStudent, dto);
			ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
			structure.setData(dto);
			structure.setMessage("student save success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.CREATED);
		}
		return null; // exception for student save failure
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> findStudent(int studentId){
		Student foundStudent = dao.findStudent(studentId);
		if(foundStudent!=null) {
			StudentDto dto = new StudentDto(); 
			mapper.map(foundStudent, dto);
			ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
			structure.setData(dto);
			structure.setMessage("student found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.FOUND);
		}
		return null; // exception for student not found
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> deleteStudent(int studentId){
		Student deletedStudent = dao.deleteStudent(studentId);
		if(deletedStudent!=null) {
			StudentDto dto = new StudentDto(); 
			mapper.map(deletedStudent, dto);
			ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
			structure.setData(dto);
			structure.setMessage("student delete success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
		}
		return null; // exception for student not found
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(Student student,int studentId){
		Student updatedStudent = dao.updateStudent(student,studentId);
		if(updatedStudent!=null) {
			StudentDto dto = new StudentDto(); 
			mapper.map(updatedStudent, dto);
			ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
			structure.setData(dto);
			structure.setMessage("student update success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
		}
		return null; // exception for student not found
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> studentLogin(String email, String password){
		Student student = dao.findByEmail(email);
		if(student!=null) {
			if(student.getStudentPassword().equals(password)) {
				StudentDto dto = new StudentDto(); 
				mapper.map(student, dto);
				ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
				structure.setData(dto);
				structure.setMessage("student login success");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
			}
			return null; // exception for incorrect password
		}
		return null; // exception for invalid invalid email
	}
	
	// find students by course ID
	
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findStudentsByCourseId(int courseId){
		List<Student> students = dao.findStudentsByCourseId(courseId);
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		if(!students.isEmpty()) {
			for(Student st : students) {
				StudentDto dto = new StudentDto();
				mapper.map(st, dto);
				dtos.add(dto);
			}
			ResponseStructure<List<StudentDto>> structure = new ResponseStructure<List<StudentDto>>();
			structure.setData(dtos);
			structure.setMessage("student data found");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure,HttpStatus.OK);	
		}
		return null; // exception for no students exist for given course ID	
	}
	
}
