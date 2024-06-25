package personnel;


import java.util.Objects;

public class Student extends Person {

	private String department;

	public Student(String name, int age, char gender, String department) {
		super(name, age, gender);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(department, other.department);
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", department=" + department + "]";
	}
	
	
}
