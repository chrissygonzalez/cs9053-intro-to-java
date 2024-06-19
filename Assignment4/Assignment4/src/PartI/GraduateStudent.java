package PartI;

public class GraduateStudent extends Student {
	private Faculty advisor;
	
	public GraduateStudent(String name, int age, char gender, String department, Faculty advisor) {
		super(name, age, gender, department);
		this.advisor = advisor;
	}
	
	public void setAdvisor(Faculty advisor) {
		this.advisor = advisor;
	}
	
	public Faculty getAdvisor() {
		return this.advisor;
	}
	
	public String toString() {
		return super.toString() + ", advisor: " + advisor;
	}
	
	public boolean equals(Object o) {
		if (o instanceof GraduateStudent) {
			return advisor.equals(((GraduateStudent)o).advisor);
		} else {
			return super.equals(o);
		}
	}
}