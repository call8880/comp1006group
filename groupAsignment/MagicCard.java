package groupAsignment;
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
        if(r <= 2){
            p.w.getRoom(this.getLocation()).removePlayer(p);
            p.setLocation(p.w.entrance);
            p.w.getRoom(p.w.getEntrance()).addPlayer(p);
        }else{
            System.out.println("Nothing seems to happen.");
        }
    }

    public String toString(){
        return this.getName();
    }

}
