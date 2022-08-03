package Miro;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import Main.GameUI;

public class Miro1 extends JFrame implements ActionListener,KeyListener,Runnable {
	JPanel p0,p1,p2,p3,p4;
	final JLabel [][] la = new JLabel[14][22];
	static ImageIcon user = new ImageIcon("imgs/miro/user.png");
	ImageIcon finish = new ImageIcon("imgs/miro/finish.png");
	ImageIcon tree = new ImageIcon("imgs/miro/tree.png");
	ImageIcon tree2 = new ImageIcon("imgs/miro/tree2.png");
	ImageIcon tree3 = new ImageIcon("imgs/miro/tree3.png");
	ImageIcon backImg = new ImageIcon("imgs/miro/backImg.png");
	int x,y,time;
	boolean music;

	public void map0() {		
		p0 =  new JPanel(){           
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				setOpaque(true);
			}
		};
		Timer time = new Timer();
		TimerTask t = new TimerTask(){
			public void run(){
				bgm("imgs/miro/newthang.wav");
			}
		};
		x=11;y=6;
		p0.setLayout(new GridLayout(14,22));
		add(p0);
		for (int i=0; i<MAP.b0.length; i++) {
			for (int j=0; j<MAP.b0[i].length; j++){
				if(MAP.b0[i][j]==1){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree);
				}
				else if(MAP.b0[i][j]==0){
					la[i][j] = new JLabel();
				}		
				else if(MAP.b0[i][j]==2){
					JLabel bono = new JLabel();
					la[i][j] = bono;
					la[i][j].setIcon(user);
				}
				else if(MAP.b0[i][j]==3){
					la[i][j] = new JLabel();
					la[i][j].setIcon(finish);
					la[i][j].setBackground(new Color(58,156,23));
				}
				else if(MAP.b0[i][j]==4){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree2);
					la[i][j].setBackground(new Color(58,156,23));
				}
				else if(MAP.b0[i][j]==5){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree3);
					la[i][j].setBackground(new Color(58,156,23));
				}
				p0.add(la[i][j]);
			}
		}
		music = true;
		time.schedule(t,0);
		setUI();	
	}
	void map1(){
		new Thread(this).start();
		x=13;y=21;
		p1 = new JPanel(){           
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				g.drawString("남은 시간 : "+time, 1100, 750);
				setOpaque(true);
			}
		};
		p1.setLayout(new GridLayout(14,22)); //맵크기 설정
		add(p1);
		for (int i=0; i<MAP.b1.length; i++) {
			for (int j=0; j<MAP.b1[i].length; j++){
				if(MAP.b1[i][j]==1){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree);
				}
				else if(MAP.b1[i][j]==0){
					la[i][j] = new JLabel();
				}		
				else if(MAP.b1[i][j]==2){
					JLabel bono = new JLabel();
					la[i][j] = bono;
					bono.setBackground(new Color(58,156,23));
					la[i][j].setIcon(user);
				}
				else if(MAP.b1[i][j]==3){
					la[i][j] = new JLabel();
					la[i][j].setIcon(finish);
					la[i][j].setBackground(new Color(58,156,23));
				}
				else if(MAP.b1[i][j]==4){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree2);
					la[i][j].setBackground(new Color(58,156,23));
				}else if(MAP.b1[i][j]==5){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree3);
					la[i][j].setBackground(new Color(58,156,23));
				}
				p1.add(la[i][j]);
			}
		}
	}
	void map2(){
		x=13;
		y=21;
		p2 = new JPanel(){           
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				g.drawString("남은 시간 : "+time, 1100, 750);
				setOpaque(true);
			}
		};
		p2.setLayout(new GridLayout(14,22));
		add(p2);
		for (int i=0; i<MAP.b2.length; i++) {
			for (int j=0; j<MAP.b2[i].length; j++){
				if(MAP.b2[i][j]==1){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree);
				}
				else if(MAP.b2[i][j]==0){
					la[i][j] = new JLabel();
				}		
				else if(MAP.b2[i][j]==2){
					JLabel bono = new JLabel();
					la[i][j] = bono;
					la[i][j].setIcon(user);
				}
				else if(MAP.b2[i][j]==3){
					la[i][j] = new JLabel();
					la[i][j].setIcon(finish);
				}
				else if(MAP.b2[i][j]==4){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree2);
				}else if(MAP.b2[i][j]==5){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree3);
				}
				p2.add(la[i][j]);
			}
		}
	}
	void map3(){
		x=13;
		y=21;
		p3 = new JPanel(){           
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
				g.drawString("남은 시간 : "+time, 1100, 750);
				setOpaque(true);
			}
		};
		p3.setLayout(new GridLayout(14,22));
		add(p3);
		for (int i=0; i<MAP.b3.length; i++) {
			for (int j=0; j<MAP.b3[i].length; j++){
				if(MAP.b3[i][j]==1){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree);
				}
				else if(MAP.b3[i][j]==0){
					la[i][j] = new JLabel();
				}		
				else if(MAP.b3[i][j]==2){
					la[i][j].setIcon(user);
				}
				else if(MAP.b3[i][j]==3){
					la[i][j] = new JLabel();
					la[i][j].setIcon(finish);
				}
				else if(MAP.b3[i][j]==4){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree2);
				}else if(MAP.b3[i][j]==5){
					la[i][j] = new JLabel();
					la[i][j].setIcon(tree3);
				}
				p3.add(la[i][j]);
			}
		}
	}
	void end() {
		int answer = JOptionPane.showConfirmDialog(null,"게임 끝! 다시 할까용?", "Game Over", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, user);
		if(answer == JOptionPane.YES_OPTION) {
			music=false;
			dispose();
			Miro1 m = new Miro1();
			m.map0();
		}else {
			music=false;
			removeAll();
			setVisible(false);
			new GameUI().setUI();
		}
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37) {  //왼 
			moveIcon(0,-1);
		}
		if(e.getKeyCode()==39) { //오   
			moveIcon(0,1);
		}
		if(e.getKeyCode()==38) { //위   
			moveIcon(-1,0);
		}
		if(e.getKeyCode()==40) { // 밑   
			moveIcon(1,0);
		}
	}
	int a=11;
	int b=15;
	int count = 0;
	void nextMAP(int n, int m) {
		if(la[x][y]== la[a][b]) {
			if(count==0) {
				map1();
				remove(p0);
				a=0;
				b=0;
				count++;
			}else if(count ==1) {
				map2();
				remove(p1);
				a=0;
				b=0;
				count++;
			}else if(count ==2) {
				map3();
				remove(p2);
				a=0;
				b=0;
				count++;
			}else if(count ==3) {
				end();
			}
		}
	}
	public void moveIcon(int n,int m) {
		try {
			if(la[x+n][y+m].getIcon()==null || la[x+n][y+m].getIcon().equals(finish)||la[x+n][y+m].getIcon().equals(tree2)||la[x+n][y+m].getIcon().equals(tree3)) {
				la[x+n][y+m].setIcon(user);
				la[x][y].setBackground(new Color(58,156,23));
				la[x][y].setIcon(null);
				x = x+n;
				y = y+m;
				nextMAP(x,y);
			}
		}catch(Exception e) {}		
	}
	void setUI() {
		setTitle("서누보노");
		setVisible(true);
		setSize(1200,800);
		addKeyListener(this);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {
	}
	public void keyTyped(KeyEvent e) {		
	}
	public void keyReleased(KeyEvent e) {		
	}
	public void run() {
		time = 30;
		while (time >= 0) {
			time--;
			if(time==0) {end();}
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
	}

	public void bgm(String fileName) {
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			if(music==true)
				clip.start();
				clip.loop(100);
			while(music){
				try{
					Thread.sleep(10);
				}catch(Exception e){}
			}
			clip.stop();
		}catch (Exception ex){}
	}
}
