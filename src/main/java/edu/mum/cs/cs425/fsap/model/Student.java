package edu.mum.cs.cs425.fsap.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "students")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	@Column(name="student_number", nullable = false, unique = true)
	@NotBlank
	private String studentNumber;
	@Column(nullable = false)
	@NotBlank
	private String fullName;
	private String phoneNumber;
	@Column(nullable = false)
	@NotBlank @Email
	private String emailAddress;
	@Column(nullable = false)
	@NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAdmission;
	private double cgpa;
	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	public Student() {}
	public Student(@NotBlank String studentNumber, @NotBlank String fullName, String phoneNumber,
			@NotBlank @Email String emailAddress, @NotBlank LocalDate dateOfAdmission, double cgpa, Faculty faculty) {
		super();
		this.studentNumber = studentNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.dateOfAdmission = dateOfAdmission;
		this.cgpa = cgpa;
		this.faculty = faculty;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
}
