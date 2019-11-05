/**
 * The Enemy class encapsulates the notion of an enemy having
 * a number (for display), a location and a shooting range.
 * The enemy can move can attempt to move in a random direction and
 * can "shoot" the player if he is in range.
 */

public class Enemy 
{
  private int enemyNumber; //useful to identify the enemy
  private Location location;

  public Enemy(int enemyNumber, Location location) 
  {
    this.enemyNumber = enemyNumber;
    this.location = location;
  }

  public int getEnemyNumber() 
  {
    return enemyNumber;
  }
  public Location getLocation() 
  {
    return this.location;
  }
  /**
   * Move the enemy in a random direction by one position, if possible
   * @return whether the move was possible or not.
   */
  public void move() 
  {
    int direction = (int)random(World.KEY_LEFT,World.KEY_DOWN);

    switch(direction)
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
   
    }
    println("Enemy:"+getEnemyNumber()+location);    
  }

  public boolean caught(Player player) 
  {
    if(this.getLocation().toString().equals(player.getLocation().toString()))
      return true;
    else
      return false;
  }
}
