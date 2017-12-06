import java.util.Random;
import java.util.List;
public class FrenchKnight extends Player{
  Random rand = new Random();
  int cowHeal = 40;
  final String castle = "The French Knight somehow found a castle to reside in. ";
  boolean isCastle;
  Cow cow;
  
  public FrenchKnight (World w, String name, Location location, int health,
                       List<Thing>  things, Thing goal){
    super(w, name, location, health, things, goal);
    this.isCastle = false;
    this.cow = new Cow("cow", location, cowHeal);
    addThing(cow);
  }
  
  @Override
  public void play(){
          boolean moved = false;
          Location newLocation;
          while (moved == false){
            int r = rand.nextInt(5);
            switch (r){
              case 0:
                newLocation = this.getLocation().north();
                moved = move(newLocation);
                if (moved == true){
                  this.setLocation(newLocation);
                  this.isCastle = false;
                }
                break;
              case 1:
                newLocation = this.getLocation().east();
                moved = move(newLocation);
                if (moved == true){
                  this.setLocation(newLocation);
                  this.isCastle = false;
                }
                break;
              case 2:
                newLocation = this.getLocation().south();
                moved = move(newLocation);
                if (moved == true){
                  this.setLocation(newLocation);
                  this.isCastle = false;
                }
                break;
              case 3:
                newLocation = this.getLocation().west();
                moved = move(newLocation);
                if (moved == true){
                  this.setLocation(newLocation);
                  this.isCastle = false;
                }
                break;
              case 4:
                moved = true;
                this.isCastle = true;
                break;
            }
          }
  }
  
  @Override 
  public boolean move(Location newLocation){
    boolean canMove = this.getLocation().isConnected(newLocation);
    if (canMove){
      this.w.getRoom(this.getLocation()).removePlayer(this);
      this.w.getRoom(newLocation).addPlayer(this);
    }
    return canMove;
  }
  
  @Override
  public void interact(Player p){
    if (p instanceof Human){
      int r = rand.nextInt(3);
      int damage;
      String actionString = "";
      switch(r){
        case 0:
          actionString = "You approach the French Knight and ask if he can direct you to the Golden Idol. He says he already has one.";
          break;
        case 1:
          damage = 5;
          actionString = "The French Knight compares your mother to some variety of small rodent and likens your fathers scent to that of wild vegetation. You take " + damage + " damage.";
          p.setHealth(p.getHealth() - damage);
          break;
        case 2:
          damage = 20;
          actionString = "The French Knight throws a cow at you. You take " + damage + " damage.";
          p.setHealth(p.getHealth() - damage);
          addThing(cow);
          removeThing(cow);
          p.addThing(cow);
          break;
      }
      if (this.isCastle){
        actionString = castle + actionString;
      }
      System.out.println(actionString);
    }
  }
}