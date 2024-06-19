public class TestHero {
	public static void main (String[] args) {
		Hero h = new Hero("Bob");
		System.out.println(h.toString());
		
		h.gainExperience(5);
		System.out.println(h.toString());
		
		h.gainExperience(75);
		System.out.println(h.toString());
		
		h.setRole("Warrior");
		System.out.println(h.toString());
		
		h.setRole("Dwarf");
		System.out.println(h.toString());
		
		h.setRole("priest");
		System.out.println(h.toString());
		
		h.setRole("WIZARD");
		System.out.println(h.toString());
	}
}