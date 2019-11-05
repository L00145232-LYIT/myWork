void setup()
{
  size(640, 360);
  background(0, 0, 0);
}

void draw()
{
  // draw nothing here
}

void mousePressed()
{
  ellipse(mouseX, mouseY, 50, 50);  // draw a ellipse at mouse (x,y) coords
}

void keyPressed()
{
  if (key=='r'){
    background(0, 0, 0);  // clear if spacebar pressed
    fill(255,0,0);
  }
   else if (key=='b'){
    background(0, 0, 0);  // clear if spacebar pressed
    fill(0,0,255);
   }
   else if (key=='g'){
    background(0, 0, 0);  // clear if spacebar pressed
    fill(0,255,0);
   }
}
