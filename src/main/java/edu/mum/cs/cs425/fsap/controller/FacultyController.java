package edu.mum.cs.cs425.fsap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.fsap.service.IFacultyService;

@Controller
public class FacultyController {
	@Autowired
	private IFacultyService facultyService;
	@GetMapping("/faculty/facultylist")
	public ModelAndView getFacultyList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("facultys", facultyService.getFaculty());
		modelAndView.setViewName("faculty/facultylist");
		return modelAndView;
	}
}
