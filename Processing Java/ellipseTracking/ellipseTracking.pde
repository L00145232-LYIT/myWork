// runs one time
void setup() 
{
  // Set the size of the window
  size(640, 360);
  background(0, 0, 0);
}

// loops continuously 
void draw() 
{
  //background(0, 0, 0);
 

fill(255,255,0);
rect(mouseX+80,mouseY+35,40,40);//head

fill(0,0,255);
rect(mouseX+60,mouseY+75,80,50);//torso

fill(255,255,0);
rect(mouseX+50,mouseY+75,25,50);
rect(mouseX+125,mouseY+75,25,50);//arms

fill(0,255,0);
rect(mouseX+75,mouseY+125,25,40);
rect(mouseX+100,mouseY+125,25,40);//legs

line(mouseX+95,mouseY+50,mouseX+95,mouseY+45);
line(mouseX+105,mouseY+50,mouseX+105,mouseY+45);//eyes

line(mouseX+95,mouseY+60,mouseX+100,mouseY+70);
line(mouseX+105,mouseY+60,mouseX+100,mouseY+70);//lips
 // draw using mouse x coordinate
}
