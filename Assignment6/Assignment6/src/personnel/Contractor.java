package personnel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Contractor extends Employee {

	private String contractCompany;
	private Date endDate;
	
	public Contractor(String name, int age, char gender, 
			double salary, String title, Date startDate,
			String contractCompany, Date endDate) {
		super(name, age, gender, salary, title, startDate);
		this.contractCompany = contractCompany;
		this.endDate = endDate;
	}

	public Contractor(String name, int age, char gender, 
			double salary, String title, Date startDate,
			String contractCompany, String endDate) throws ParseException {
		
		super(name, age, gender, salary, title, startDate);
		this.contractCompany = contractCompany;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			System.err.println("invalid date format. Use MM-dd-yyyy");
			throw e;
		}
	}

	public String getContractCompany() {
		return contractCompany;
	}

	public void setContractCompany(String contractCompany) {
		this.contractCompany = contractCompany;
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
		result = prime * result + Objects.hash(contractCompany, endDate);
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
		Contractor other = (Contractor) obj;
		return Objects.equals(contractCompany, other.contractCompany) && Objects.equals(endDate, other.endDate);
	}

//	@Override
//	public String toString() {
//		return "Contractor [" + super.toString() + 
//				", contractCompany=" + contractCompany + 
//				", endDate=" + endDate + "]";
//	}
	
	
	
}
