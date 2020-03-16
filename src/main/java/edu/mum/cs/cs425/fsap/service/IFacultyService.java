package edu.mum.cs.cs425.fsap.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Faculty;

@Service
public interface IFacultyService {
	public Iterable<Faculty> getFaculty();
}
