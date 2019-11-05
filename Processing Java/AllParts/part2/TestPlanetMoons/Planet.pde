public class Planet
{

  // add class member variables here
  private String name;
  private float radius;
  private float distance;
  private float speed;
  private float angle=0.01;
  private Moon moon;

  // add constructor here
  public Planet(String name, float radius, float distance, float speed, Moon moon) 
  {
   this.name=name;
   this.radius=radius;  
   this.distance=distance;
   this.speed=speed;
   this.moon=moon;
  }

  // add other methods here
public String getName()
 {
  return name;
 }
 

 public float getRadius()
 {
  return radius;
 }
 
  public float getDistance()
 {
  return distance;
 }
 
   public float getSpeed()
 {
  return speed;
 }
 
 public Moon[] getMoon()
 {
 return moon;
 }

public void setRadius(float radius)
{
     this.radius=radius;  
}
  // This will display the moon when other code is completed.  You don't need to understand this code.
  public void display()
  {
 angle=angle+(0.01*speed);
  pushMatrix();
  rotate(angle);
  translate(distance,0);
  fill(255, 255, 255);
  ellipse(0, 0, radius*2, radius*2);    

  for(Moon moon: getMoon())
    moon.display();

  popMatrix();     
  }
  
    public String toString()
  {
   return
   "Name:"+this.name +
   " Radius: "+ this.radius+
   " Distance: "+this.distance +
   " Speed: "+this.speed +
   "\n"+ this.moon;
  }
}
