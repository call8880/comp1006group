import java.util.Random;

/**
 * Created by Clarke on 03/12/2017.
 */
public class MagicCard extends Thing{
    public MagicCard(String name, Location location, int value){
        super("Magical Card", location, value);
    }
    public MagicCard(String name, Location location, int value, int e) {
        super("Magical Card", location, value, e);
    }

    public void interact(Player p){
        Random rand = new Random();
        int r = rand.nextInt(4);
        if(r == 0){
            p.w.getRoom(this.getLocation()).removePlayer(p);
            p.setLocation( this.getLocation().east() );
            p.w.getRoom(this.getLocation()).addPlayer(p);
            System.out.println("You seem to have moved because of the card!");
        }else if(r == 1){
            p.w.getRoom(this.getLocation()).removePlayer(p);
            p.setLocation( this.getLocation().west() );
            p.w.getRoom(this.getLocation()).addPlayer(p);
            System.out.println("You seem to have moved because of the card!");

        }else if(r == 2){
            p.w.getRoom(this.getLocation()).removePlayer(p);
            p.setLocation( this.getLocation().south() );
            p.w.getRoom(this.getLocation()).addPlayer(p);
            System.out.println("You seem to have moved because of the card!");
        }else if(r==3){
            p.w.getRoom(this.getLocation()).removePlayer(p);
            p.setLocation( this.getLocation().north() );
            p.w.getRoom(this.getLocation()).addPlayer(p);
            System.out.println("You seem to have moved because of the card!");
        }else{
            System.out.println("Nothing seems to happen.");
        }
    }

}
