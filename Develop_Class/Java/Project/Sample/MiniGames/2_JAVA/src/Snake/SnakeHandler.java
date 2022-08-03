package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeHandler implements KeyListener{
	Snake snake;
	
	public SnakeHandler(Snake snake) {
		this.snake = snake;
	}
	public void keyPressed(KeyEvent e){
		try{
			snake.board.repaint();
            if(e.getKeyCode()==37||e.getKeyCode()==65){//왼쪽
            	if(snake.way!=snake.RIGHT && snake.way!=snake.LEFT) {
            		if(snake.bodyList.get(0).getName()==null) snake.way=snake.LEFT;
            		if(!(snake.bodyList.get(1).getName().equals("1"))) {
            			snake.way=snake.LEFT;
            			snake.moveSnake(0,-1);
            			snake.bodyList.get(0).setIcon(snake.leftHead); 
            		}
            	}
            }else if(e.getKeyCode()==38||e.getKeyCode()==87){//위쪽
            	if(snake.way!=snake.DOWN && snake.way!=snake.UP) {
            		if(snake.bodyList.get(0).getName()==null) snake.way=snake.UP;
            		if(!(snake.bodyList.get(1).getName().equals("4"))) {
            			snake.way=snake.UP;
            			snake.moveSnake(-1,0);
            			snake.bodyList.get(0).setIcon(snake.upHead);
            		}
            	}
            }else if(e.getKeyCode()==39||e.getKeyCode()==68){//오른쪽
            	if(snake.way!=snake.LEFT && snake.way!=snake.RIGHT) {
            		if(snake.bodyList.get(0).getName()==null) snake.way=snake.RIGHT;
            		if(!(snake.bodyList.get(1).getName().equals("2"))) {
            			snake.way=snake.RIGHT;
            			snake.moveSnake(0,1);
            			snake.bodyList.get(0).setIcon(snake.rightHead);
            		}
            	}
            }else if(e.getKeyCode()==40||e.getKeyCode()==83){//아래
            	if(snake.way!=snake.UP && snake.way!=snake.DOWN) {
            		if(snake.bodyList.get(0).getName()==null) snake.way=snake.DOWN;
            		if(!(snake.bodyList.get(1).getName().equals("3"))) {
            			snake.way=snake.DOWN;
            			snake.moveSnake(1,0);
            			snake.bodyList.get(0).setIcon(snake.downHead);
            		}
            	}
            }
            snake.board.repaint();
        }catch(Exception ex) {}
	}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
