package Shooting;

class Enemy {
 int x;
 int y;
 int w = 25;
 int h = 25;
 int speed;
 public Enemy(int x, int y,int speed) {
  this.x = x;
  this.y = y;
  this.speed = speed;
 }
 
 public void moveEn() {
  //y++;
	 int dx = (int) (Math.random()*-3);
	y+=speed;
	x+=dx;
	
 } 
 public void moveEn2() {
	  //y++;
		 int dx = (int) (Math.random()*4);
		y+=speed;
		x+=dx;
		
	 } 
}