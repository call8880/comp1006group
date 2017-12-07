import java.util.List;


public class Zombie extends Player {
	//Salah's player class
	public Zombie (World w, String name, Location location, int health, List<Thing> things, Thing goal){
        super(w, name, location, health, things, goal);
        
    }	
	
	public void interact() {
		System.out.println("grrrrrrr");
	}
	
	public void interact( Player p) {
		
		System.out.println("Zombie attacks player for brains");
		p.setHealth(p.getHealth() - 25);
		
	}
	
@Override
	
	public void play() {
	this.interact();
	
	
	
}

}
