package Shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Particle {

   private int x;
   private int y;
   private int dx;
   private int dy;
   private int size;
   private int life;
   private Color color;
   
   public Particle(int x, int y, int dx, int dy, int size, int life, Color c){
	      this.x = x;
	      this.y = y;
	      this.dx = dx;
	      this.dy = dy;
	      this.size = size;
	      this.life = life;
	      this.color = c;
	   }

   public boolean update(){
	      x += dx;
	      y += dy;
	      life--;
	      if(life <= 0)
	         return true;
	      return false;
	   }
   public void render(Graphics g){
	      Graphics gi = (Graphics2D) g.create();
	      gi.setColor(color);
	      gi.fillRect(x-(size/2), y-(size/2), size, size);
	      gi.dispose();
	   }
}