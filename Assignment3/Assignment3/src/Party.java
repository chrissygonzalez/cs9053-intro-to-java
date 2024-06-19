
public class Party {
	private Hero[] heroes;
	
	public Party() {
		this.heroes = new Hero[] {null, null, null};
	}
	
	public void addHero(Hero hero, int index) {
		for(Hero h : this.heroes) {
			if(h == hero) {
				System.out.println(h.getName() + " is already in the party.");
				return;
			}
		}
		this.heroes[index] = hero;
	}
	
	public void removeHero(int index) {
		// remove hero
		this.heroes[index] = null;
		
		// start checking indices after removed
		int next = index + 1;
		while(next < this.heroes.length) {
			if(this.heroes[next] == null) {
				next++;
			} else {
				// put first non-null in the empty spot,
				// then clear space and move pointers
				this.heroes[index] = this.heroes[next];
				this.heroes[next] = null;
				next++;
				index++;
			};
		}
	}
	
	public Hero getHero(int index) {
		return this.heroes[index];
	}
	
	public void gainExperience(int experience) {
		for(Hero h : this.heroes) {
			if(h != null) {
				h.gainExperience(experience);
			}
		}
		System.out.println("The party gained " + experience + " experience. ");
	}
	
	public String toString() {
		String output = "Party: \n";
		for(Hero h : this.heroes) {
			if(h != null) {
				output = output +  h.toString() + "\n";
			}
		}
		return output;
	}
}
