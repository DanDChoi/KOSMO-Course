package Tetris;

import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class TetrisHandler implements KeyListener {
	Tetris t;
	TetrisHandler(Tetris t){
		this.t = t;
	}

	public synchronized void keyPressed(KeyEvent e){ // 키 입력 받는 메소드
		Timer time = new Timer();
		TimerTask t1 = new TimerTask(){
			public void run(){
				t.flag = false;
			}
		};
		if(e.getKeyCode()==37 && t.flag == false && t.blockCheck==true && t.start==true){//왼쪽
			t.flag = true;
			if (t.space == false){
				if(t.left==true && t.col>0){
					t.move1(0,-1);	
				}
				t.board.repaint();
			}
			time.schedule(t1,50);
        }else if(e.getKeyCode()==38 && t.flag == false && t.start==true){//위쪽
			if (t.space == false){
				t.turn();
			}
			time.schedule(t1,150);
        }else if(e.getKeyCode()==39 && t.flag == false && t.blockCheck==true && t.start==true){//오른쪽
			t.flag = true;
			if (t.space == false){
				if(t.right==true){
					if(t.col< 14-t.bCol){
						t.move1(0,1);	
					}
				}
				t.board.repaint();
			}
			time.schedule(t1,50);
		}  
		else if(e.getKeyCode()==40 && t.flag == false && t.blockCheck==true && t.start==true){// 아래
			t.flag = true;
			if (t.space == false){
				t.move1(1,0);
			}
			time.schedule(t1,50);
		}  
    }
	public void keyReleased(KeyEvent e) {   
		Timer time = new Timer();
		TimerTask t1 = new TimerTask(){
			public void run(){
				t.flag = false;
			}
		};
		TimerTask t2 = new TimerTask(){
			public void run(){
				if(t.row+t.bRow<21 && t.blockCheck==true);
				else{
					t.speed=t.bufSpeed;
					t.space=false;
					this.cancel();
				}
			}
		};
		TimerTask t3 = new TimerTask(){
			public void run(){
				t.play("imgs/tetris/bgm.wav");
			}
		};
		if(e.getKeyCode()==32 && t.flag == false && t.start==true){//스페이스 바
			t.space = true;
			t.flag = true;
			t.bufSpeed = t.speed;
			t.speed = 20;
			time.schedule(t2,0,50);
			time.schedule(t1,300);
        }else if(e.getKeyCode()==65 && t.start==false){ // A버튼(스타트)
			t.start = true;
			t.music = true;
			time.schedule(t3,0);
        }else if(e.getKeyCode()==81 && t.music == false && t.start==true){ // Q버튼(음악 재시작)
			t.music = true;
			time.schedule(t3,0);
        }else if(e.getKeyCode()==87 && t.music == true && t.start==true){ // W버튼(음악 끄기)
			t.music = false;
        }
    }
    
    public void keyTyped(KeyEvent e) {  
    }
}
