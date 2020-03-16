package edu.mum.cs.cs425.fsap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Student;
import edu.mum.cs.cs425.fsap.repository.StudentRepository;
import edu.mum.cs.cs425.fsap.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void addStudent(Student student) {
		if(student != null)
			studentRepository.save(student);
	}
	@Override
	public List<Student> getStudent() {
		return studentRepository.findAll(Sort.by(Direction.ASC, "fullName"));
	}
}
