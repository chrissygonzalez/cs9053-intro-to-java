package PartI;

public class Student extends Person {
	private String department;
	
	public Student() {
		
	}
	
	public Student(String name, int age, char gender, String department) {
		super(name, age, gender);
		this.department = department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public String toString() {
		return super.toString() + ", department: " + this.department;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Student && this.department != ((Student)o).getDepartment()) {
			return false;
		} else {
//			System.out.println("calling super equals in Student");
			return super.equals(o);
		}
	}
}