package personnel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class SpecialStudent extends Student {
	private Date endDate;

	public SpecialStudent(String name, int age, char gender, String department, Date endDate) {
		super(name, age, gender, department);
		this.endDate = endDate;
	}

	public SpecialStudent(String name, int age, char gender, String department, 
			String endDate) throws ParseException {
		super(name, age, gender, department);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			System.err.println("invalid date format. Use MM-dd-yyyy");
			throw e;
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(endDate);
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
		SpecialStudent other = (SpecialStudent) obj;
		return Objects.equals(endDate, other.endDate);
	}

	@Override
	public String toString() {
		return "SpecialStudent [" + super.toString() +", endDate=" + endDate + "]";
	}
	
	
}
