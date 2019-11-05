/**
 * The Player class represents the player, with its main characteristics
 * being a location and alive indicator
 * In the game, the user will attempt to move a player in the optimum
 * direction to avoid being caught by enemies.
 */

public class Player 
{
  private Location location;
  private boolean alive;
  private int score;

  public Player(Location location) 
  {
    this.alive=true;
    this.location = location;
    this.score=0;

    println(location);
  }

  public boolean isAlive() 
  {
    return alive;
  }

  public void isDead() 
  {
    this.alive=false;
  }

  public Location getLocation() 
  {
    return location;
  }

  public int getScore()
  {
    return score;
  }
  
  public void updateScore(int value)
  {
    this.score+=value;
  }
  
  public void move(int keycode)
  {
    println("player keycode="+keycode);
    switch(keycode)
    {
    case World.KEY_UP:    
      location.changeY(-1);
      if (location.getY()<World.MIN_CELL)
        location.setY(World.MAX_CELL);
      break;
       
       case World.KEY_DOWN:    
      location.changeY(+1);
      if (location.getY()<World.MIN_CELL)
        location.setY(World.MAX_CELL);
      break;
      
       case World.KEY_RIGHT:    
      location.changeX(+1);
      if (location.getX()<World.MIN_CELL)
        location.setX(World.MAX_CELL);
      break;
      
       case World.KEY_LEFT:    
      location.changeX(-1);
      if (location.getX()<World.MIN_CELL)
        location.setX(World.MAX_CELL);
      break;

    // (Q.2)
    
    }

  }
}
