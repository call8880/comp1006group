package groupAsignment;

public class Rock extends Thing {
	
	private Location loc; 
	private static String name = "Rock";
	private final int damage = -20;
	//info statement describing the thing and what it does
	private String rockInfo = "You found a Rock its hot and will hurn you if you carry it for to long so must drop it after moving between each room";

	public Rock(Location location, int value) {
		super(name, location, value);
		this.value = damage;
		this.loc = location;
	}

	public Rock(Location location, int value, int e) {
		super(name, location, value, e);
		this.loc = location;
	}
	//method to get the info statement from the rock class
	public String getInfo() {
		return rockInfo;
	}
	
	public int dealDamage() {
		if (this.loc != Human.getLocation()) {
			return damage;
		}
		else { return 0;}
	}
	

}
