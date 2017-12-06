package groupAsignment;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World{
  protected Room[][] rooms;
  protected Location entrance;
  protected Thing    goal;

  //locations
  private final Map<Integer, Location> locMap;
  {
    locMap = new HashMap<Integer, Location>();
    locMap.put(1, new Location(this,0,0));
    locMap.put(2, new Location(this,0,1));
    locMap.put(3, new Location(this,0,2));
    locMap.put(4, new Location(this,1,0));
    locMap.put(5, new Location(this,1,1));
    locMap.put(6, new Location(this,1,2));
  }




  public World(){
    Room r1 = new Room("the entrance", new Location(this,0,0), 
                      new java.util.ArrayList<Location>(),
                      new java.util.ArrayList<Player>(),
                      new java.util.ArrayList<Thing>());
    Room r2 = new Room("a dark room", new Location(this,0,1), 
                      new java.util.ArrayList<Location>(),
                      new java.util.ArrayList<Player>(),
                      new java.util.ArrayList<Thing>());
    r1.getAdjacentRooms().add(r2.getLocation());
    r2.getAdjacentRooms().add(r1.getLocation());
  
    rooms = new Room[1][2];
    rooms[0][0] = r1;
    rooms[0][1] = r2;
    entrance = rooms[0][0].getLocation();
    goal = new GoldenIdol("thing", r2.getLocation(), 1);
    r2.addThing(goal);
  }
  
  public World(String worldFileName){
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(0,new Pirate(this,"pirate", new Location(this, 0,0), 100,new java.util.ArrayList<Thing>(),new GoldenIdol("thing", new Location(this, 0, 0), 1)));
    playersList.add(1,new Zombie(this,"zombie", new Location(this, 0,0), 100,new java.util.ArrayList<Thing>(),new GoldenIdol("thing", new Location(this, 0, 0), 1)));
    playersList.add(2,new FrenchKnight(this,"french knight", new Location(this, 0,0), 100,new java.util.ArrayList<Thing>(),new GoldenIdol("thing", new Location(this, 0, 0), 1)));
    playersList.add(3, new Thief(this, "Thieff", new Location(this, 0, 0), 100, new java.util.ArrayList<Thing>(), new GoldenIdol("Thing", new Location(this, 0, 0), 1)));

    List<Thing> thingList = new ArrayList<Thing>();
    thingList.add(0,new GoldenIdol("Golden Idol", new Location(this,0,0),0));
    thingList.add(1,new MagicCard("Magic Card", new Location(this,0,0),0));
    thingList.add(2,new Cow("Cow", new Location(this,0,0),0));

    String fileName = worldFileName;
    String line = null;
    int x = 0;
    int y = 0;
    try{
      FileReader file = new FileReader( worldFileName );
      BufferedReader reader = new BufferedReader(file);

      line = reader.readLine();
      rooms = new Room[2][3];
      for(Room r[]: rooms) {
        for(Room s: r) {
          line = reader.readLine();
          s = new Room(line, new Location(this,x,y),new java.util.ArrayList<Location>(),new java.util.ArrayList<Player>(), new java.util.ArrayList<Thing>());
          line = reader.readLine();
          String[] parts = line.split(",");
          for(String pt: parts){
           s.getAdjacentRooms().add(locMap.get(Integer.parseInt(pt)));
          }
          line = reader.readLine();
          String[] parts2 = line.split(",");
          for(int p = 0;p<4;p++){
            if(Integer.parseInt(parts2[p]) == 1){
              playersList.get(p).setLocation(new Location(this,x,y));
              s.addPlayer(playersList.get(p));
            }
          }
          line = reader.readLine();
          String[] parts3 = line.split(",");
          for(int p = 0;p<4;p++){
            if(Integer.parseInt(parts3[p]) == 1){
              thingList.get(p).setLocation(new Location(this,x,y));
              s.addThing(thingList.get(p));
            }
          }
          y++;
        }
        x++;
      }
      reader.close();

    }catch(java.io.FileNotFoundException e){
      // might be thrown by FileReader constructor
      System.err.println("File " + fileName + " was not found");
    }catch(java.io.IOException e){
      // might be thrown when reading data
      System.err.println("IOException thrown : " + e);
    }
  }
  
  public Location getEntrance(){
    return entrance;
  }
  
  public Thing getGoal(){ return goal;}
  
  /** returns room of spcified Player */
  public Room getRoom(Player p){
    int r = p.getLocation().getRow();
    int c = p.getLocation().getCol();
    return rooms[r][c];
  }
  /** returns room of specified location 
    * 
    * @return the room that this is at this location in this world. 
    *         Returns null if there is no such room.
    */
  public Room getRoom(Location location){
    return rooms[location.getRow()][location.getCol()];
  }
}