public class TestParty {
	public static void main (String[] args) {
		Hero h1 = new Hero("Bob");
		h1.setRole("WIZARD");
		
		Hero h2 = new Hero("Galadriel");
		h2.setRole("priest");
		
		Hero h3 = new Hero("Thor");
		h3.setRole("thief");
		
		Party p = new Party();

		p.addHero(h1, 0);
		p.addHero(h2, 1);
		p.addHero(h3, 2);
		
		p.gainExperience(100);
		System.out.println(p.toString());
		
//		Hero h1 = new Hero("Bob");
//		h1.setRole("WIZARD");
//		h1.gainExperience(3);
//		
//		Hero h2 = new Hero("Galadriel");
//		h2.setRole("priest");
//		h2.gainExperience(1);
//		
//		Hero h3 = new Hero("Thor");
//		h3.setRole("thief");
//		h3.gainExperience(10);
//		
//		Hero h4 = new Hero("Ogre");
//		h4.setRole("Warrior");
//		
//		Party p = new Party();
//
//		p.addHero(h1, 0);
//		p.addHero(h2, 0);
//		p.addHero(h3, 1);
//		p.addHero(h4, 2);
//		p.addHero(h4, 0);
//		
//		System.out.println(p.toString());
//		
//		p.gainExperience(1);
//		System.out.println(p.toString());
//		
//		p.gainExperience(3);
//		System.out.println(p.toString());
//		
//		p.removeHero(0);
//		System.out.println(p.getHero(0).toString());
//		System.out.println(p.getHero(1).toString());
//		System.out.println(p.toString());
	}
}