package Shooting;

class Ms {
 int x;
 int y;
 int w = 5;
 int h = 35;
 int speed;
 public Ms(int x, int y,int w,int speed) {
  this.x = x;
  this.y = y;
  this.speed = speed;
  this.w = w;
 }
 public void moveMs() {
	 //y--;
	 y -= speed;
 }
}