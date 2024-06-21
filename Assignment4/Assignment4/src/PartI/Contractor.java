package PartI;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Contractor extends Employee{
	private String contractCompany;
	private LocalDate endDate;
	
	public Contractor(String name, 
			int age, 
			char gender, 
			int salary, 
			String title, 
			LocalDate date,
			String contractCompany,
			LocalDate endDate) {
		super(name, age, gender, salary, title, date);
		this.endDate = endDate;
		this.contractCompany = contractCompany;
	}
	
	public Contractor(String name, 
			int age, 
			char gender, 
			int salary, 
			String title, 
			LocalDate date,
			String contractCompany,
			String endDate) {
		super(name, age, gender, salary, title, date);
		this.contractCompany = contractCompany;
		try {
			LocalDate end = LocalDate.parse(endDate);
			this.endDate = end;
		} catch(DateTimeParseException e) {
			System.err.println("Please enter the end date in the format yyyy-mm-dd.");
		}
	}
	
	public void setContractCompany(String company) {
		this.contractCompany = company;
	}
	
	public String getContractCompany() {
		return this.contractCompany;
	}
	
	public void setEndDate(LocalDate date) {
		this.endDate = date;
	}
	
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	public String toString() {
		return super.toString() + ", contract company: " + contractCompany + ", end date: " + endDate;
	}
}