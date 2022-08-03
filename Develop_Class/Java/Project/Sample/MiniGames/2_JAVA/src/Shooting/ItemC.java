package Shooting;

class ItemC {
 int x;
 int y;
 int w = 40;
 int h = 40;
 int speed;
 
 public ItemC(int x, int y,int speed) {
  this.x = x;
  this.y = y;
  this.speed = speed;
 }
 
 public void moveitem() {
	 //y--;
	 y += speed;
 }
}