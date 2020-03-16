package edu.mum.cs.cs425.fsap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Student;

@Service
public interface IStudentService {
	public void addStudent(Student student);
	public List<Student> getStudent();
}
