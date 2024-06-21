package PartI;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class SpecialStudent extends Student {
	private LocalDate endDate;
	
	public SpecialStudent(String name, int age, char gender, String department, LocalDate endDate) {
		super(name, age, gender, department);
		this.endDate = endDate;
	}
	
	public SpecialStudent(String name, int age, char gender, String department, String endDate) {
		super(name, age, gender, department);
		try {
			LocalDate end = LocalDate.parse(endDate);
			this.endDate = end;
		} catch(DateTimeParseException e) {
			System.err.println("Please enter the end date in the format yyyy-mm-dd.");
		}
	}
	
	public void setEndDate(LocalDate date) {
		this.endDate = date;
	}
	
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	public String toString() {
		return super.toString() + ", end date: " + endDate;
	}
	
	public boolean equals(Object o) {
		if (o instanceof SpecialStudent && !endDate.equals( ((SpecialStudent)o).getEndDate())) {
			return false;
		} else {
//			System.out.println("calling super equals in SpecialStudent");
			return super.equals(o);
		}
	}

}