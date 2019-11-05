Planet earth;

void setup()
{
  size(800, 800);  

  Moon moon = new Moon("moon", 7.5, 50, 2, 28);
  earth = new Planet("earth", 25, 200, 1, moon);
  println(moon);
  println(earth);
}

void draw()
{
  background(0, 0, 0);
  fill(255, 255, 0);
  ellipse(width/2, height/2, 100, 100);  
  translate(width/2, height/2);

  earth.display();
}
