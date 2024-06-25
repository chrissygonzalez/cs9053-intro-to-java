package personnel;


import java.util.Date;
import java.util.Objects;

public class Staff extends Employee {

	// I didn't specify whether "manager" was a boolean
	// or a reference variable to another Staff member.
	// I'll do this because it shows a few things we have to
	// worry about, but both are allowed.
	private Staff manager;

	public Staff(String name, int age, char gender, double salary, String title, Date startDate, Staff manager) {
		super(name, age, gender, salary, title, startDate);
		this.manager = manager;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(manager);
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
		Staff other = (Staff) obj;

		// the small but very real possbility of a managerial cycle
		// means that I need to avoid an infinite loop by just getting
		// the id of the manager
		if (manager == null && other.manager == null) {
			return true;
		} else if (manager != null && other.manager != null && manager.getId() == other.manager.getId()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		// the small but very real possbility of a managerial cycle
		// means that I need to avoid an infinite loop by just getting
		// the id of the manager
		return "Staff [" + super.toString() +", manager=" + 
			(manager != null ? manager.getId() : "None") + "]";
	}
	
	
	
}
