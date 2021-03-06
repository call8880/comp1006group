package groupAsignment;
import java.util.List;
import java.util.Scanner;


/** A human (user) players in the game */

public class Human extends Player {

	private static boolean verbose = false; // set true for debugging
	// set false for submitted code
	private Location loc;

	/**
	 * Creates a player in the game
	 * 
	 * @param w
	 *            is the world that the player lives in
	 * @param name
	 *            is the name of the player
	 * @param location
	 *            is where in the world the player is
	 * @param health
	 *            is the health of the player (which may or may not be relevant in
	 *            your game)
	 * @param things
	 *            is a list of Thing objects that the player initially possesses
	 * @param goal
	 *            is the Thing that the human player is trying to retrieve in the
	 *            game
	 */
	public Human(World w, String name, Location location, int health, List<Thing> things, Thing goal) {
		super(w, name, location, health, things, goal);
		this.loc = location;
	}

	/**
	 * Plays a turn for this player
	 * 
	 * For computer players will have the AI for that player. For human player
	 * querie user for input and then react appropriately for the input.
	 */
	@Override
	public void play() {
		if (verbose) {
			System.err.println("the room as " + w.getRoom(getLocation()).getPlayers() + " players");
		}
		if (verbose) {
			System.err.println("the room as " + w.getRoom(getLocation()).getThings() + " things");
		}
		Scanner in = new Scanner(System.in);
		System.out.print("What would you like to do? [type h <enter> for help] ");
		String action = in.nextLine();
		if (action.trim().equals("h")) {
			help();
		} else if (action.trim().equals("l")) {
			look();
		} else if (action.trim().equals("i")) {
			this.interact();
		} else if (action.trim().equals("w")) {
			System.out.println("Your items are: ");
			String blah = "";
			for(Thing t: this.getThings()){
				blah += t.toString();
			}
			System.out.println(blah);
		} else if (action.trim().charAt(0) == 'g') {
			switch (action.trim().charAt(action.trim().length() - 1)) {
			case 'n':
				if (verbose) {
					System.err.print("human was in " + this.getLocation());
				}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation(this.getLocation().north());
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if (verbose) {
					System.err.print("human now in " + this.getLocation());
				}
				break;		
			case 'e':
				if (verbose) {
					System.err.print("human was in " + this.getLocation());
				}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation(this.getLocation().east());
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if (verbose) {
					System.err.print("human now in " + this.getLocation());
				}
				break;
			case 'w':
				if (verbose) {
					System.err.print("human was in " + this.getLocation());
				}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation(this.getLocation().west());
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if (verbose) {
					System.err.print("human now in " + this.getLocation());
				}
				break;
			case 's':
				if (verbose) {
					System.err.print("human was in " + this.getLocation());
				}
				this.w.getRoom(this.getLocation()).removePlayer(this);
				this.setLocation(this.getLocation().south());
				this.w.getRoom(this.getLocation()).addPlayer(this);
				if (verbose) {
					System.err.print("human now in " + this.getLocation());
				}
				break;
			}

		}
	}

	public void look() {
		String s = "You are currently in ";
		s += w.getRoom(getLocation()).toString();
		System.out.println(s);
	}

	public void help() {
		String s = "Your options are:\n ";
		s += "'h' for help \n ";
		s += "'l' to look around the room \n ";
		s += "'g x' to go in direction x (x can be n,e,w,s) \n ";
		s += "'w' to list what you have \n ";
		s += "'i' to interact with a thing or player in this room. \n";
		System.out.println(s);
	}
	public void interact(){
		System.out.println("Would you like to interact with a (p)layer or (t)hing?");
		Scanner in = new Scanner(System.in);
		if(in.nextLine().equals("p")) {
			System.out.println("Who would you like to interact with?");
			System.out.println(w.getRoom(getLocation()).getPlayers().toString());
			System.out.println("Enter integer value of player 0+ correspondingly");
			interact(w.getRoom(getLocation()).getPlayers().get(in.nextInt()));
		}else if(in.nextLine().equals("t")){
			System.out.println("What thing would you like to interact with?");
			System.out.println(w.getRoom(getLocation()).getThings().toString());
			System.out.println("Enter integer value of thing 0+ correspondingly");
			interact(w.getRoom(getLocation()).getThings().get(in.nextInt()));
		}
	}

	public void interact(Player p){
	  p.interact(this);
    }

    public void interact(Thing t){
	  t.interact(this);
    }
}
