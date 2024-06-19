package PartI;

import java.time.LocalDate;

public class Faculty extends Employee {
	private boolean tenured;
	private String department;
	
	public Faculty(String name, 
			int age, 
			char gender, 
			int salary, 
			String title, 
			LocalDate date, 
			boolean tenured, 
			String department) {
		super(name, age, gender, salary, title, date);
		this.tenured = tenured;
		this.department = department;
	}
	
	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}
	
	public boolean getTenured() {
		return this.tenured;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public String toString() {
		return super.toString() + ", tenured: " + tenured + ", department: " + department;
	}
}