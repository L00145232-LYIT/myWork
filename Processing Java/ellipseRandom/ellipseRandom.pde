void setup()
{
  size(640, 360);
  background(0, 0, 0);
}

void draw()
{
  float x = random(width);
  float y= random(height);
  
  fill(random(x),random(x) ,random(x) );
  ellipse(mouseX, mouseY, 50, 50);  // draw a ellipse at mouse (x,y) coords
}
