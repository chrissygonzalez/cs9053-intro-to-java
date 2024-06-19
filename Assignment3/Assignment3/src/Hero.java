
public class Hero {
	private String name;
	private String role;
	private int level;
	private int experience;
	private static final int MAX_LEVEL = 100;
	private static final String[] ROLES = {"Warrior", "Priest", "Wizard", "Thief"};
	
	public Hero(String name) {
		this.name = name;
		this.role = "Unassigned";
		this.level = 1;
		this.experience = 0;
	}
	
	public void setRole(String role) {
		boolean isRole = false;
		String validRole = "";
		
		for(String r : ROLES) {
			// check if role entered is valid
			if(r.toLowerCase().equals(role.toLowerCase())) {
				isRole = true;
				validRole = r;
			}
		}
		if(isRole) {
			this.role = validRole;
		} else {
			this.role = "Unassigned";
			System.out.println("Invalid role");
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public int expToLevelUp() {
		return this.level * this.level;
	}
	
	public void gainExperience(int experience) {
		int totalExperience = this.experience + experience;
		int needed = this.expToLevelUp();
		
		while (totalExperience >= needed && this.level < MAX_LEVEL) {
			this.level = this.level + 1;
			totalExperience = totalExperience - needed;
			needed = expToLevelUp();
		}
		
		this.experience = totalExperience;
	}
	
	public String toString() {
		return this.name + " the " + this.role + " is level " + this.level + " with " + this.experience + " experience.";
	}
}

















