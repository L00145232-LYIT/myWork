import lejos.nxt.*;
import java.util.Random;

public class TriBot{
  public void forward(int seconds)
  {
    Motor.B.forward();
    Motor.C.forward();
  
    Motor.B.stop();
    Motor.C.stop();
  }
   
	
 
	public void square(int seconds)
	{
		for (int i =0 ; i<4; i++)
		{
			forward(seconds);
			
		}
	}//end square()

/* ----------------- Snakes & Ladders Code START -------------------- */	 

private LightSensor ls;		 
private int pos;

public TriBot()
	{
	
		pos=0;
	}	

	public void turnRight()
	{
		Motor.B.rotate(-180,true);
		Motor.C.rotate(180,false);
	}
	
	public void turnLeft()
	{
		Motor.B.rotate(180,true);
		Motor.C.rotate(-180,false);
	}

public void setSpeed(int speed)
	{
		Motor.C.setSpeed(speed);
		Motor.B.setSpeed(speed);
	}
	//turn 
public void turn180()
	{
		Motor.B.rotate(-380,true);
		Motor.C.rotate(380,false);
	}

 public void wait(int seconds)
    {
    	try{
        	Thread.sleep(seconds*1000);
        }
        catch(InterruptedException e){}
    }
	 
	public void moveForwardTile()
{
    Motor.B.rotate(680,true);
    Motor.C.rotate(680,false);
	 // pos++;
	setSpeed(400);
}


	public void resetTachometers()
	{
	  Motor.B.resetTachoCount();
	  Motor.C.resetTachoCount();
	}

	public int getTachometersCount()
	{
	  int value1=Motor.B.getTachoCount();
	  int value2=Motor.C.getTachoCount();

	  return (int)((value1+value2)/2);
	}

public void waitForCommand(int bValue)
 
{
	 
    if(bValue==Button.ID_ENTER)
		 {
         moveForwardTile();
		 }
		 else if(bValue==Button.ID_LEFT) 
			 {
		 turnLeft();
		 }
		 else if(bValue==Button.ID_RIGHT)
			 {
		turnRight();
		 }
		  else if(bValue==Button.ID_ESCAPE)
			 {
		doActions();
		 }


 }
 //private LightSensor ls;		 

	

	//private int pos;

	public void doActions()
  {
	
	  String tile="@tile:0";
	  LCD.clear();
	  LCD.drawString(tile,0,0);
	  LCD.refresh();
	  Sound.beep();
	  //printTileNumber();
	  wait(3);
	}


	
//Reading THE LIGHT Values
	

/* ----------------- Snakes & Ladders Code STOP  -------------------- */



/* ----------------- Connect 4 Code START -------------------- */
private LightSensor light;

public int[] exploreGrid()
{
	int[] grid=new int[16]; // 16 tiles
	int gridPostion=0;
	
	for (int i = 0; i < 3; i++)//0-3
		{
			
			moveForwardTile();
			grid[gridPostion]=readLightValue();
	      gridPostion++;
		   
			}

	
	turnRight();
	moveForwardTile();//3-4
	grid[gridPostion]=readLightValue();
	       gridPostion++;
	
	
	turnRight();
	
		for (int i = 0; i < 3; i++)//4-7
		{
			
			moveForwardTile();
			grid[gridPostion]=readLightValue();
	       gridPostion++;
			
		}
	
	turnLeft();
	
	moveForwardTile();//7-8
	
	grid[gridPostion]=readLightValue();
	       gridPostion++;
	turnLeft();
	
	
		
	for (int i = 0; i < 3; i++)//8-11
		{
			
			moveForwardTile();
			grid[gridPostion]=readLightValue();
	       gridPostion++;
		   
			}
		
	
	turnRight();
	moveForwardTile();//11-12
	
	
	grid[gridPostion]=readLightValue();
	       gridPostion++;
	turnRight();
	
	
	for (int i = 0; i < 3; i++)//12-15
	{
			
			moveForwardTile();
			grid[gridPostion]=readLightValue();
	       gridPostion++;
		   
	}
	
	return grid;
}
public void printGrid(int[] grid)
{
   LCD.clear();         //x, y
	LCD.drawInt(grid[0],  0, 0);
   LCD.drawInt(grid[1],  2, 0);
	LCD.drawInt(grid[2],  4, 0);
   LCD.drawInt(grid[3],  6, 0);
	
	
	LCD.drawInt(grid[4],  6, 2);
	LCD.drawInt(grid[5],  4, 2);
	LCD.drawInt(grid[6],  2, 2);
	LCD.drawInt(grid[7],  0, 2);
	
	LCD.drawInt(grid[8],  0, 4);
	LCD.drawInt(grid[9],  2, 4);
	LCD.drawInt(grid[10],  4, 4);
	LCD.drawInt(grid[11],  6, 4);
	
	LCD.drawInt(grid[12],  6, 6);
	LCD.drawInt(grid[13],  4, 6);
	LCD.drawInt(grid[14],  2, 6);
	LCD.drawInt(grid[15],  0, 6);
		
		wait(10);

}

//calibrateLightSensor() 
public void calibrateLightSensor()
	{
	//private LightSensor ls;
		ls = new LightSensor(SensorPort.S4);
		wait(2);
		ls.calibrateLow();  //  recalibrates black tile reading as 0 (zero)
		
		wait(2);
		int black = ls.readValue();  // take light reading again
		LCD.clear();
		LCD.drawInt(black,0,0);      // should print a value of 0
		LCD.refresh();
		//Beep 
		Sound.beep();
		wait (3);
 
		moveForwardTile();	
		wait(2);
		ls.calibrateHigh(); //  recalibrates white tile reading as 100 (zero)
		
		wait(2);
		int white = ls.readValue();  // take light reading again
		LCD.clear();
		LCD.drawInt(white,0,0);      // should print a value of 0
		LCD.refresh();
		//Beep
		Sound.beep();
		
		wait(3);
		

		
	}//end calibrateLightSensor()
public int readLightValue()
	{
	
		wait(2); 
		//ls = new LightSensor(SensorPort.S4);
		
		int lightValue = ls.readValue() ;
		Sound.beep();
		
		LCD.clear();
		LCD.drawInt(lightValue,0,0);
		LCD.refresh();
		wait(3);	

		//if tile is black
		if(lightValue >= -10 && lightValue < 20) 		
		{    	
			LCD.clear();
			LCD.drawString("black`",0,0);
			
			LCD.refresh();	
			wait(1); 
			return 1;    //1 is for black    
		}                 		
		//if tile is white
		else if(lightValue >= 90 && lightValue < 110) 		
		{    	
			LCD.clear();
			LCD.drawString("white",0,0);
			
			LCD.refresh();	
			wait(1); 
			return 2;  //2 is for white       	
		}    
		//every other tile is brown
		else  	
			
		LCD.clear();
		LCD.drawString("brown(neutral)",0,0);
		
		LCD.refresh();	
		wait(1); 
		return 0;    //0 is brown because it is neutral     	
	    
	}
	public void makeRandomMove()
{
	Random rand = new Random();
/* VARIABLE number=0
	number=random number between 12 to 15
	print tile number the tribot wants to move to
	move the tribot to the tile number
	beep twice*/
	
   
	int number=0;
	int high=15;
   int low=12;
	number=rand.nextInt(high-low) + low;
	
		
			
				if(number == 12)
				{
					
		       LCD.clear();
		       LCD.drawString("going to tile 12",0,0);
		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 3; i++)//15-12
					{
		          
			       moveForwardTile();
				 }
		
	         
			    Sound.beep();	
				 Sound.beep();		
				} 
				
				
				if(number == 13)
				{
					LCD.clear();
		       LCD.drawString("going to tile 13",0,0);
		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 2; i++)//15-12
					{
		          
			       moveForwardTile();
				 }
		
	         
			    Sound.beep();	
				 Sound.beep();			
				}
				
				
				if(number == 14)
				{
				 LCD.clear();
		       LCD.drawString("going to tile 14",0,0);
		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 3; i++)//15-12
					{
		          
			       moveForwardTile();
				 }
		
	         
			    Sound.beep();	
				 Sound.beep();		
				}
				
				
				if(number == 15)
				{
					LCD.clear();
		         LCD.drawString("staying at tile 15",0,0);
		         LCD.refresh();	
				
	         
				 Sound.beep();	
				 Sound.beep();		`
				}
				

}
public void makeValidMove(int[] grid)
{
/*VARIABLE number=0
        VARIABLE valid=false
        do
        {
                number=random number between 12 to 15

                // Check it is a valid column to drop a tile. Use grid array.
                ...
                ...

        } while(valid==false)
        print tile number the tribot wants to move to
        move the tribot to the tile number
        beep twice */
	
	   Random randy = new Random();//create a Random object
		boolean validMove = false;//declare validMove boolean
		//do while valid move is false
		do
		{
			int high=0;
			int low=0;
			int randomNum = randy.nextInt(); 
			
			validMove = false;//reset value
		
			if(grid[randomNum] == 12)
			{
				validMove = true;

				
				
			
				if(randomNum == 12)
				{
					
		       LCD.clear();
		       LCD.drawInt(12,0,0);//print position to be moved to

		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 3; i++)//15-12
					{
		          
			       moveForwardTile();
				 }
		
	         
			    Sound.beep();	
				 Sound.beep();		
				} 
				
				
				if(randomNum == 13)
				{
					LCD.clear();
		       LCD.drawInt(13,0,0);//print position to be moved to

		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 2; i++)//15-13
					{
		          
			       moveForwardTile();
				 }
		
	         
			    Sound.beep();	
				 Sound.beep();			
				}
				
				
				if(randomNum == 14)
				{
				 LCD.clear();
		       LCD.drawInt(14,0,0);//print position to be moved to

		       LCD.refresh();	
             turnRight();
             turnRight();					
				 for (int i = 0; i < 1; i++)//15-14
					{
	
				    moveForwardTile();
				   }
		
	         
			    Sound.beep();	
				 Sound.beep();		
				}
				
				
				if(randomNum == 15)
				{
					LCD.clear();
		         LCD.drawString("staying at tile 15",0,0);
		         LCD.refresh();	
				
	         
				 Sound.beep();	
				 Sound.beep();		
				}
				else 
			{
				validMove = false;
				LCD.clear();
				LCD.drawString("Invalid - Try Again", 0, 0);
				wait(5);
			}
		}

	}while(!validMove);	
		
	
}
}
/* ----------------- Connect 4 Code STOP -------------------- */
public static void main(String[] args){}
}//end tribot class