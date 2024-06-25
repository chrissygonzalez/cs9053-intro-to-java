package personnel;


import java.util.Date;
import java.util.Objects;

public class Faculty extends Employee {
	private boolean tenured;
	private String department;
	
	public Faculty(String name, int age, char gender, 
			double salary, String title, Date startDate, 
			boolean tenured, String department) {
		super(name, age, gender, salary, title, startDate);
		
		this.tenured = tenured;
		this.department = department;
	}

	public boolean isTenured() {
		return tenured;
	}

	public void setTenured(boolean tenured) {
		this.tenured = tenured;
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
		result = prime * result + Objects.hash(department, tenured);
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
		Faculty other = (Faculty) obj;
		return Objects.equals(department, other.department) && tenured == other.tenured;
	}

	@Override
	public String toString() {
		return "Faculty [" + super.toString() + ", tenured=" + tenured + 
				", department=" + department + "]";
	}
	
	
	
}
