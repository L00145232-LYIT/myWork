Planet mars;

void setup()
{
  size(800, 800);

  // create a planet, two moons and call some of its methods, etc.
  mars = new Planet("Mars", 20, 300, 1.5);
  mars.addMoon(new Moon("Phobos", 5, 50, 2, 28));
  mars.addMoon(new Moon("Deimos", 2.5, -35, 1.5, 42));
  
  print("First moon of mars is:");
  println(mars.getMoonName(0));

  println(mars); // toString()

  print("The moons are: ");
  mars.printMoons();  
}

void draw()
{
  background(0, 0, 0);
  fill(255, 255, 0);
  ellipse(width/2, height/2, 100, 100);  
  translate(width/2, height/2);

  mars.display();
}