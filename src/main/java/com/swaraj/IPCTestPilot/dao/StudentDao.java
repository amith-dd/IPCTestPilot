package com.swaraj.IPCTestPilot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaraj.IPCTestPilot.entity.Student;
import com.swaraj.IPCTestPilot.repo.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepo repo;
	
	public Student saveStudent(Student student) {
		Student st = repo.save(student);
		if(st!=null) {
			return st;
		}
		return null;
	}
	
	public Student findStudent(int studentId) {
    	Optional<Student> opStudent=repo.findById(studentId);
		if(opStudent.isPresent()) {
			return opStudent.get();
			}
		return null;
		}


    public List<Student> findAllStudents(int subjectid) {
        return repo.findAll();
    }

    public Student deleteStudent(int studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
        	repo.delete(student);
            return student;
        }
        return null;
    }

    public Student updateStudent(Student student, int studentId) {
        Student dbStudent = findStudent(studentId);
        if (dbStudent != null) {
            student.setStudentId(studentId);
            return repo.save(student);
        }
        return null;
    }
	
}
