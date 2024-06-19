package PartI;

import java.time.LocalDate;

public class Staff extends Employee {
	private Employee manager;
	
	public Staff(String name, 
			int age, 
			char gender, 
			int salary, 
			String title, 
			LocalDate date, 
			Employee manager) {
		super(name, age, gender, salary, title, date);
		this.manager = manager;
	}
	
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	public Employee getManager() {
		return this.manager;
	}
	
	public String toString() {
		return super.toString() + ", manager: " + manager;
	}
}