Moon moon;

void setup()
{
  size(800, 800);  

moon = new Moon("Moon", 20, 100, 2, 28);
println(moon); // calls toString()
moon.setName("Earth Moon");
println(moon);
  
}

void draw()
{
  background(0, 0, 0);
  translate(width/2, height/2);
  moon.display();
}
