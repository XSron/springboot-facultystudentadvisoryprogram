package edu.mum.cs.cs425.fsap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.fsap.model.Student;
import edu.mum.cs.cs425.fsap.service.impl.FacultyService;
import edu.mum.cs.cs425.fsap.service.impl.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	@GetMapping("/student/studentlist")
	public ModelAndView getStudentList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", studentService.getStudent());
		modelAndView.setViewName("student/studentlist");
		return modelAndView;
	}
	@GetMapping("/student/addstudent")
	public ModelAndView addStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.addObject("facultys", facultyService.getFaculty());
		modelAndView.setViewName("student/addstudent");
		return modelAndView;
	}
	@PostMapping("/student/addstudent")
	public String postStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("facultys", facultyService.getFaculty());
			return "student/addstudent";
		}
		studentService.addStudent(student);
		return "redirect:/student/studentlist";
	}
}
