import java.util.List;

public class GoldenIdol extends Thing{
  
  public GoldenIdol(String name, Location location, int value){
    super(name, location, value);
  }
  
  @Override
  public void interact(){
    String actionString = "The idol shines dimly.";
    System.out.println(actionString);
  }
}