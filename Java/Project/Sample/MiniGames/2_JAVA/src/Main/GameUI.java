package Main;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import DuDu.DuDu;
import Miro.Miro1;
import SSB.Ssb_Main;
import SSB.Ssb_Nick_Gui;
import Shooting.Shoot;
import Snake.Snake;
import Tetris.Tetris;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameUI extends JFrame implements ActionListener{
	ImageIcon startImg, backGroundImg, snakeBtn, titleImg, g1, g11, g2, g22, g3, g33, g4, g44, g5, g55, g6, g66 ;
	JPanel main, menu, title, border1, border2;
	JButton btnStart;
	JButton snakeStart;
	JButton btns[] = new JButton[6];
	boolean game1 , game2, game3 , game4 , game5, game6;
	ImageIcon ii[]= {g1,g2,g3,g4,g5,g6};
	boolean music;
	
    public void setUI() {
    	loadImg();
    	add(title, BorderLayout.NORTH);
        add(main, BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);
        add(border1, BorderLayout.WEST);
        add(border2, BorderLayout.EAST);
        title.add(new JLabel(titleImg));
        title.setPreferredSize(new Dimension(850, 180));
        main.setLayout(new GridLayout(2,3,8,8));
        for(int i=0; i<6; i++) {
        	btns[i] = new JButton(ii[i]);
        	btns[i].setBorderPainted(false);
        	btns[i].setContentAreaFilled(false);
			btns[i].addActionListener(this);
        	main.add(btns[i]);
        }
    	btnStart = new JButton(startImg);
    	btnStart.setPreferredSize(new Dimension(200, 63));
    	btnStart.addActionListener(this);
    	menu.add(btnStart);
    	menu.setPreferredSize(new Dimension(850, 100));
    	setTitle("Com6iiX Games");
    	setVisible(true);
    	setSize(850,800);
    	setLocationRelativeTo(null);
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Timer time = new Timer();
		TimerTask t = new TimerTask(){
			public void run(){
				music = true;
				play("imgs/main/main.wav");
			}
		};
		time.schedule(t, 0);
	}

	void loadImg() {
		try {
			startImg = new ImageIcon(ImageIO.read(new File("imgs/main/btnStart.png")));
			backGroundImg = new ImageIcon(ImageIO.read(new File("imgs/main/back.jpg")));
			snakeBtn = new ImageIcon(ImageIO.read(new File("imgs/main/gameboy.png")));
			titleImg = new ImageIcon(ImageIO.read(new File("imgs/main/title.png")));
			ii[0] = new ImageIcon(ImageIO.read(new File("imgs/main/01.png")));
			g11 = new ImageIcon(ImageIO.read(new File("imgs/main/01_on.png")));
			ii[1] = new ImageIcon(ImageIO.read(new File("imgs/main/02.png")));
			g22 = new ImageIcon(ImageIO.read(new File("imgs/main/02_on.png")));
			ii[2] = new ImageIcon(ImageIO.read(new File("imgs/main/03.png")));
			g33 = new ImageIcon(ImageIO.read(new File("imgs/main/03_on.png")));
			ii[3] = new ImageIcon(ImageIO.read(new File("imgs/main/04.png")));
			g44 = new ImageIcon(ImageIO.read(new File("imgs/main/04_on.png")));
			ii[4] = new ImageIcon(ImageIO.read(new File("imgs/main/05.png")));
			g55 = new ImageIcon(ImageIO.read(new File("imgs/main/05_on.png")));
			ii[5] = new ImageIcon(ImageIO.read(new File("imgs/main/06.png")));
			g66 = new ImageIcon(ImageIO.read(new File("imgs/main/06_on.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		title = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
                g.drawImage(backGroundImg.getImage(), 0, 0, null);
                setOpaque(true);
            }
        };
		main = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
                g.drawImage(backGroundImg.getImage(), 0, 0, null);
                setOpaque(true);
            }
        };
		menu = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
                g.drawImage(backGroundImg.getImage(), 0, 0, null);
                setOpaque(true);
            }
        };
		border1 = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
                g.drawImage(backGroundImg.getImage(), 0, 0, null);
                setOpaque(true);
            }
        };
		border2 = new JPanel() {
            public void paintComponent(Graphics g) {
            	super.paintComponent(g);
                g.drawImage(backGroundImg.getImage(), 0, 0, null);
                setOpaque(true);
            }
        };
	}
    public void onOff() {
    	if(game1==true) btns[0].setIcon(g11);
		else btns[0].setIcon(ii[0]);
    	
    	if(game2==true) btns[1].setIcon(g22);
		else btns[1].setIcon(ii[1]);
    	
    	if(game3==true) btns[2].setIcon(g33);
		else btns[2].setIcon(ii[2]);
    	
    	if(game4==true) btns[3].setIcon(g44);
		else btns[3].setIcon(ii[3]);
    	
    	if(game5==true) btns[4].setIcon(g55);
		else btns[4].setIcon(ii[4]);
    	
    	if(game6==true) btns[5].setIcon(g66);
		else btns[5].setIcon(ii[5]);
    }
    public void play(String fileName) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            //clip.stop();
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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnStart) {
			if(game1==true){
				music = false;
				dispose();
				new Miro1().map0();
			}
			else if(game2==true){
				music = false;
				dispose();
				new Snake().init();
			}
			else if(game3==true){
				music = false;
				dispose();
				 new DuDu();
			}
			else if(game4==true){
				music = false;
				dispose();
				new Tetris().init();
			}
			else if(game5==true){
				music = false;
				dispose();
				new Shoot();
			}
			else if(game6==true){
				music = false;
				dispose();
				new Ssb_Main(); 
			}
		}else if(obj == btns[0]){
			if(game1==false) {
				game1= true; game2=false; game3=false; game4=false; game5=false; game6=false;
				}
			else game1= false;
			onOff();
		}else if(obj == btns[1]){
			if(game2==false) {
				game2= true; game1= false; game3=false; game4=false; game5=false; game6=false;
				}
			else game2= false;
			onOff();
		}else if(obj == btns[2]){
			if(game3==false) {
				game3= true; game1= false; game2=false; game4=false; game5=false; game6=false;
				}
			else game3= false;
			onOff();
		}else if(obj == btns[3]){
			if(game4==false) {
				game4= true; game1= false; game2=false; game3=false; game5=false; game6=false;
				}
			else game4= false;
			onOff();
		}else if(obj == btns[4]){
			if(game5==false) {
				game5= true; game1= false; game2=false; game3=false; game4=false; game6=false;
				}
			else game5= false;
			onOff();
		}else if(obj == btns[5]){
			if(game6==false) {
				game6= true; game1= false; game2=false; game3=false; game4=false; game5=false;
				}
			else game6= false;
			onOff();
		}
	}
	
	public static void main(String[] args) {
		new GameUI().setUI();
	}
}
