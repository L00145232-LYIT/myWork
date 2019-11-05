/**
 * The "World".
 * Contains the objects in our world (composition), an update method (where
 * things move), and a draw method to "render" our world.
 */
public class World
{
  public static final int MAX_CELL=5;
  public static final int MIN_CELL=0;
  public static final int KEY_UP=38;
  public static final int KEY_DOWN=40;
  public static final int KEY_LEFT=37;
  public static final int KEY_RIGHT=39;
  public static final int KEY_NW=36;
  public static final int KEY_NE=33;
  public static final int KEY_SW=35;
  public static final int KEY_SE=34;
  
  public static final int CELL_SIZE=81;

  PImage grid;
  PImage me;
  PImage enemy;

  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private Player player;

  public World(Player player, int noOfEnemies)
  {
    grid=loadImage("images/grid.jpg");
    me=loadImage("images/Pacman.png");

    this.player = player;
    for (int i = 0; i < noOfEnemies; i++)
    {
      createEnemy(i+1);
    }
  }

  private void createEnemy(int enemyNumber)
  {
    // random cell location for enemy
    enemyNumber=(int)random(4,MAX_CELL);
    // (Q.4)
    
    enemies.add(new Enemy(enemyNumber, new Location(World.MAX_CELL, World.MAX_CELL)));
  }

  /**
   * Move the Player (via input from the user)
   * Move the enemies
   */
  public void update(int keycode) 
  {
    if (player.isAlive())
    {
      //move the player based on user input
      player.move(keycode);

      // Attempt to move each of the enemies and then check
      // if they caught the Player
      for (Enemy e : enemies)
      {
        e.move();

        if (e.caught(player))
        {        
          player.isDead();
          println("Score="+player.getScore());
          me=loadImage("images/deadpacman.png");
          image(me, player.getLocation().getX()*World.CELL_SIZE+2, player.getLocation().getY()*World.CELL_SIZE+2);
          println("Enemy " +            e.getEnemyNumber() + "catches Player");

          return;
        }
      }
      player.updateScore(1);
      println("Score="+player.getScore());
      
      // (Q.6)
    }
  }

  /**
   * Draw the grid world
   */
  public void drawWorld()
  {
    // code to draw the world...
    image(grid, 0, 0);

    int i=0;
    for (Enemy e : enemies)
    {
      enemy=loadImage("images/enemy"+(i%4+1)+".png");
      i++;
      image(enemy, e.getLocation().getX()*World.CELL_SIZE+2, e.getLocation().getY()*World.CELL_SIZE+2);
    }
    image(me, player.getLocation().getX()*World.CELL_SIZE+2, player.getLocation().getY()*World.CELL_SIZE+2);
  }

  /**
   * Other classes will also need to communicate with the player object.
   */
  public Player getPlayer()
  {
    return player;
  }
  

  // (Q.5)
   public String printLocationInfo()
   {
   return "";
   }
}
