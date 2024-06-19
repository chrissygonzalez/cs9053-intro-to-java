package PartI;

public class UndergraduateStudent extends Student {
	private int graduationYear;
	
	public UndergraduateStudent(String name, int age, char gender, String department, int year) {
		super(name, age, gender, department);
		this.graduationYear = year;
	}
	
	public void setGraduationYear(int year) {
		this.graduationYear = year;
	}
	
	public int getGraduationYear() {
		return this.graduationYear;
	}
	
	public String toString() {
		return super.toString()+ ", graduation year: " + graduationYear;
	}
	
	public boolean equals(Object o) {
		if (o instanceof UndergraduateStudent) {
			return graduationYear == ((UndergraduateStudent)o).graduationYear;
		} else {
			return super.equals(o);
		}
	}
}
