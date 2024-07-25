package personnel;


import java.util.Objects;

public class UndergraduateStudent extends Student {
	private int graduationYear;

	public UndergraduateStudent(String name, int age, char gender, 
			String department, int graduationYear) {
		super(name, age, gender, department);
		this.graduationYear = graduationYear;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(graduationYear);
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
		UndergraduateStudent other = (UndergraduateStudent) obj;
		return graduationYear == other.graduationYear;
	}

//	@Override
//	public String toString() {
//		return "UndergraduateStudent ["+super.toString() + 
//				", graduationYear =" + graduationYear + "]";
//	}
	
	
}
