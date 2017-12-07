public class Adventure{

  public static void main(String[] args){
    World world = new World("demo0.txt");

    Player human = new Human(world, "cat", world.getEntrance(), 100,
                              new java.util.ArrayList<Thing>(),
            world.getGoal() );

    world.getRoom(world.getEntrance()).addPlayer(human);

    while(true){
      human.play();

    }
  }
}