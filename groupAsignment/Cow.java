import java.util.List;

public class Cow extends Thing{
  
  public Cow(String name, Location location, int value){
    super(name, location, value);
  }
  
  @Override
  public void interact(Player p){
    String actionString = "You make yourself a nice burger. You heal " + value + ".";
    p.setHealth(p.getHealth() + value);
    System.out.println(actionString);
  }
}
