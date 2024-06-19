package PartI;

import java.time.LocalDate;

public class Employee extends Person {
	private int salary;
	private String title;
	private LocalDate startDate;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, char gender, int salary, String title, LocalDate date) {
		super(name, age, gender);
		this.salary = salary;
		this.title = title;
		this.setStartDate(date);
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setStartDate(LocalDate date) {
		this.startDate = date;
	}
	
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	public String toString() {
		return super.toString()
				+ ", salary: " + this.salary 
				+ ", title: " + this.title 
				+ ", start date: " + this.startDate;
	}
}