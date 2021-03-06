package groupAsignment;

import java.util.*;


public class Thief extends Player {
	
	public String name;
	private Location loc;
	private List<Thing> inventory;
	private Room currentRoom;
	private Random r = new Random();
	private int whereMove = 0;

	public Thief(World w, String name, Location location, int health, List<Thing> things, Thing goal) {
		super(w, name, location, health, things, goal);
		this.name = name;
		this.loc = location;
		this.inventory = things;
	}
	//have the player pick up an item if it doesnt have any and if it does have any items in its inventory place one item in the room 
	public void playerAction() {
		
		List<Thing> t = currentRoom.getThings();
		
		if(inventory.size() == 0) {
			this.inventory.addAll(t);
		}else {
			currentRoom.addThing((Thing) inventory);
			this.inventory.remove(0);
		}
	}
	//custom move method to move between rooms in the world 
	@Override
	public void play() {
		currentRoom = w.getRoom(location);
		playerAction();
		whereMove = r.nextInt(5);
		if(whereMove == 1) {
			this.setLocation(location.north());
		}else if(whereMove == 2) {
			this.setLocation(location.east());
		}else if(whereMove == 3) {
			this.setLocation(location.south());
		}else if(whereMove == 4) {
			this.setLocation(location.west());
		}
		
	}

}
