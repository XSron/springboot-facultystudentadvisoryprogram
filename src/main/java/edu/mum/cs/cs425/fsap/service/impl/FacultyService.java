package edu.mum.cs.cs425.fsap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.repository.FacultyRepository;
import edu.mum.cs.cs425.fsap.service.IFacultyService;

@Service
public class FacultyService implements IFacultyService {
	@Autowired
	private FacultyRepository facultyRepository;
	@Override
	public Iterable<Faculty> getFaculty() {
		return facultyRepository.findAll(Sort.by(Direction.DESC, "fullName"));
	}
}
