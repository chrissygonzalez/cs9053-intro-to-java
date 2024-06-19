package PartI;

import java.time.LocalDate;

public class SpecialStudent extends Student {
	private LocalDate endDate;
	
	public SpecialStudent(String name, int age, char gender, String department, LocalDate endDate) {
		super(name, age, gender, department);
		this.endDate = endDate;
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