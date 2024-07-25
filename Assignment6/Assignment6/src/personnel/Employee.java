package personnel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person {

	private double salary;
	private String title;
	private Date startDate;
	
	public Employee(String name, int age, char gender, 
			double salary, String title, Date startDate) {
		super(name, age, gender);
		this.salary = salary;
		this.title = title;
		this.startDate = startDate;
	}

	public Employee(String name, int age, char gender, 
			double salary, String title, String startDate) throws ParseException {
		super(name, age, gender);
		this.salary = salary;
		this.title = title;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			this.startDate = sdf.parse(startDate);
		} catch (ParseException e) {
			System.err.println("invalid date format. Use MM-dd-yyyy");
			throw e;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary, startDate, title);
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
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(title, other.title);
	}

//	@Override
//	public String toString() {
//		return "Employee [" + super.toString() + 
//				", salary=" + salary + ", title=" + title + 
//				", startDate=" + startDate + "]";
//	}
	
}
