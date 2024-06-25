package personnel;


import java.util.Objects;

public class GraduateStudent extends Student {
	private Faculty advisor;

	public GraduateStudent(String name, int age, char gender, String department, Faculty advisor) {
		super(name, age, gender, department);
		this.advisor = advisor;
	}

	public Faculty getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Faculty advisor) {
		this.advisor = advisor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(advisor);
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
		GraduateStudent other = (GraduateStudent) obj;
		return Objects.equals(advisor, other.advisor);
	}

	@Override
	public String toString() {
		return "GraduateStudent [" + super.toString() + ", advisor=" + advisor + "]";
	}
	
	
}
