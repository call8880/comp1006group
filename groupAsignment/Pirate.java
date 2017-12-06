package groupAsignment;
import java.util.List;
import java.util.Random;

/**
 * Created by Clarke on 02/12/2017.
 */
public class Pirate extends Player{


    public Pirate(World w, String name, Location location, int health, List<Thing> things, Thing goal){
        super(w, name, location, health, things, goal);
    }

    public void interact(){
        System.out.println("The pirate drinks some rum.");
        this.setHealth(this.getHealth()+15);
    }

    public void interact(Player p){
        Random rand = new Random();
        int  n = rand.nextInt(100) + 1;
        if(n>50){
            System.out.println("The drunk pirate tells you to bug off and shoots you.");
            p.setHealth(p.getHealth()-50);
        }else{
            System.out.println("The drunk pirate gives you a gold coin.");
            p.goal.setValue(p.goal.getValue()+1);
        }
    }

    @Override
       public void play(){
        interact();
    }
}
