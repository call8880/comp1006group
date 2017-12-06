import java.util.List;

public class Cow extends Thing{
  
  public Cow(String name, Location location, int value){
    super(name, location, value);
  }
  
  @Override
  public void interact(){
    int heal = 40;
    String actionString = "You make yourself a nice burger. You heal " + heal + ".";
    System.out.println(actionString);
  }
}