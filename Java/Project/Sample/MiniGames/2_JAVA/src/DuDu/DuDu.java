package DuDu;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

import Main.GameUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class DuDu extends JFrame implements ActionListener,MouseListener,MouseMotionListener,Runnable{

	JButton jb[] = new JButton[30];
	JLabel jumsu = new JLabel("점수 : 0");
	JLabel time1 = new JLabel("시간 : 1:00");
	BorderLayout bl = new BorderLayout(25,25);
	GridLayout glo1 = new GridLayout(5,5);
	GridLayout glo2 = new GridLayout(1,2);
	FlowLayout fl21 = new FlowLayout(FlowLayout.CENTER);
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	int randomsu = 0;
	int count = -1;
	int j,z,x;
	boolean start1 = false, start2 = false, timerStart=true, music=false;
	ImageIcon ii = new ImageIcon("imgs/dudu/du_01.jpg");
	ImageIcon ii1 = new ImageIcon("imgs/dudu/du_02.jpg");
	ImageIcon ii2 = new ImageIcon("imgs/dudu/du_03.jpg");
	ImageIcon ii3 = new ImageIcon("imgs/dudu/h.png");
	ImageIcon ii4 = new ImageIcon("imgs/dudu/hammer.png");
	ImageIcon ii5 = new ImageIcon("imgs/dudu/두더지 망치 때릴때.png");
	Toolkit tk = Toolkit.getDefaultToolkit();
	//Cursor cursor;
	Point point;
	Image img, mouseImg, mouseClickImg;
	Timer timer; 
	Timer timer1;
	int mouseX, mouseY;
	JButton start = new JButton() {
        public void paintComponent(Graphics g) {
        	super.paintComponent(g);
            g.drawImage(new ImageIcon("imgs/dudu/스타트.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    };
	JButton end = new JButton() {
        public void paintComponent(Graphics g) {
        	super.paintComponent(g);
            g.drawImage(new ImageIcon("imgs/dudu/게임종료.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    };
    JButton musicstart = new JButton() {
        public void paintComponent(Graphics g) {
        	super.paintComponent(g);
            g.drawImage(new ImageIcon("imgs/dudu/두더지 음악버튼.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    };
    
	public DuDu() {
		init();
		start();
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		end.setBorderPainted(false);
		end.setContentAreaFilled(false);
		musicstart.setBorderPainted(false);
		musicstart.setContentAreaFilled(false);
		mouseImg = tk.getImage("imgs/dudu/hammer.png");
		mouseClickImg = tk.getImage("imgs/dudu/두더지 망치 때릴때.png");
		point = new Point(32,32);
		//cursor = tk.createCustomCursor(mouseImg, point, "hammer");
		//setCursor(cursor);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(screen.getWidth()/2 - super.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2 - super.getHeight()/2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
		time1.setFont(new Font("Serif", Font.PLAIN, 11));
		time1.setForeground(Color.BLACK);
		time1.setFont(time1.getFont().deriveFont(30.0f));
		start.setPreferredSize(new Dimension(150, 95));
		end.setPreferredSize(new Dimension(150, 95));
		musicstart.setPreferredSize(new Dimension(100, 95));
		jumsu.setFont(new Font("Serif", Font.PLAIN, 11));
		jumsu.setForeground(Color.BLACK);
		jumsu.setFont(time1.getFont().deriveFont(30.0f));
	}
	void init() {
		jp1.setBackground(new Color(58,156,23));
		jp2.setBackground(new Color(58,156,23));
		jp3.setBackground(new Color(58,156,23));
		time1.setOpaque(true);
		time1.setBackground(new Color(58,156,23));
		jumsu.setOpaque(true);
		jumsu.setBackground(new Color(58,156,23));
		addMouseListener(this);
		Container con = this.getContentPane();
		con.setBackground(new Color(58,156,23));
		con.setLayout(bl);
		con.add("Center",jp1);
		con.add("North",time1);
		jp2.add("South",musicstart);
		jp1.setLayout(glo1);
		for(int i=0; i<30; i++){ 
			jb[i] = new JButton();
			jb[i].setIcon(ii3);
			jp1.add(jb[i]);
			jb[i].addMouseListener(this);
		}
		count+=1;
		off_button();
		con.add("South", jp2);
		jp2.setLayout(glo2);
		jp2.add(jumsu);
		jp2.add(jp3);
		jp3.setLayout(fl21);
		jp3.add(start);
		jp3.add(end);
		addMouseListener(this);
		addMouseMotionListener ( this );
		setUI();
	}
	void setUI() {
		setTitle("두더지 게임");
		setSize(1000,1000);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void start() {
		start.addActionListener(this);
		end.addActionListener(this);
		musicstart.addActionListener(this);
		for(int i=0; i<30; ++i){ 
			jb[i].addActionListener(this);
		}
	}
	public void run() {
		int time = 60;
		while(true){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
			time--;
			if (time == 0) {
				start1 = false;
				time1.setText("Game Over...");
				timerStart=false;
				off_button();
				for(int i=0; i<30; i++) {
					jb[i].setIcon(ii3);
				}
				break;
			}
			time1.setText("시간 => 0:"+time);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Timer timer = new Timer();
		TimerTask t = new TimerTask(){
	         public void run(){
	        	 play("imgs/dudu/두더지잡기노래.wav");
	         }
	      };
		if (e.getSource() == start && start1 == false){ 
			start2 = true;
			start1 = true;
			timerStart = true;
			time1.setText("시간 => 1:00");
			jumsu.setText("점수 : 0");
			on_button(); 
			random();
			start2=false;
		}else if (e.getSource() == end){
			music=false;
			removeAll();
			setVisible(false);
	    	new GameUI().setUI();
		}
		else if(e.getSource() == musicstart) {
			if(music == false) {
				music = true;
		        timer.schedule(t,0);
			}
			else music = false;
			
		}
		for(int i=0; i<30; i++) {
			if(e.getSource() == jb[i]) {
				if(jb[i].getIcon().equals(ii)) {
					count+=1;
					jumsu.setText("점수 : " + count);
				}if(jb[i].getIcon().equals(ii1)) {
					count+=2;
					jumsu.setText("점수 : " + count);
				}if(jb[i].getIcon().equals(ii2)) {
					count+=3;
					jumsu.setText("점수 : " + count);
				}
				if( jb[i].getIcon().equals(ii3) ) {
					count--;
					jumsu.setText("점수 : " + count);
				}
				else {
					jb[i].setIcon(ii3);
				}	
			}
		}
	}
	public void off_button(){
		for(int i=0; i<30; i++){ 
			jb[i].setEnabled(false);
		}
	}
	public void on_button(){
		Thread th = new Thread(this); 
		th.start();
		for(int i=0; i<30; i++){
			jb[i].setEnabled(true); //활성화
		}
	}
	public void random2(){
		if(timerStart==true) {
			Timer timer = new Timer();
			TimerTask t2 = new TimerTask(){
		         public void run(){
		        	 if(timerStart==false) this.cancel();
		        	 if(!(jb[j].getIcon().equals(ii3))) {
		        		 jb[j].setIcon(ii3);
		        		 random2();
		        	 }else random2();
		         }
		      };
			Random r = new Random();
	 		while(true) {
 				j=r.nextInt(30);
 				if(jb[j].getIcon().equals(ii3)) {
 					jb[j].setIcon(ii);
 					timer.schedule(t2,1000);
 					break;
 				}
	 		}
		}
	}
	public void random3(){
		if(timerStart==true) {
			Timer timer = new Timer();
			TimerTask t2 = new TimerTask(){
		         public void run(){
		        	 if(timerStart==false) this.cancel();
		        	 if(!(jb[z].getIcon().equals(ii3))) {
		        		 jb[z].setIcon(ii3);
		        		 random3();
		        	 }else random3();
		         }
		      };
			Random r = new Random();
	 		while(true) {
 				z=r.nextInt(30);
 				if(jb[z].getIcon().equals(ii3)) {
 					jb[z].setIcon(ii1);
 					timer.schedule(t2,700);
 					break;
 				}
	 		}
		}
	}
	public void random4(){
		if(timerStart==true) {
			Timer timer = new Timer();
			TimerTask t2 = new TimerTask(){
		         public void run(){
		        	 if(timerStart==false) this.cancel();
		        	 if(!(jb[x].getIcon().equals(ii3))) {
		        		 jb[x].setIcon(ii3);
		        		 random4();
		        	 }
		        	 else random4();
		         }
		      };
			Random r = new Random();
	 		while(true) {
 				x=r.nextInt(30);
 				if(jb[x].getIcon().equals(ii3)) {
 					jb[x].setIcon(ii2);
 					timer.schedule(t2,500);		
 					break;
 				}
	 		}
		}
	}
	public void random(){
		Timer timer = new Timer();
	    TimerTask t1 = new TimerTask(){
	         public void run(){
	        	random2();
	         }
	      };
      TimerTask t2 = new TimerTask(){
	         public void run(){
	        	random3();
	         }
	      };
      TimerTask t3 = new TimerTask(){
	         public void run(){
	        	random4();
	         }
	      };
	    timer.schedule(t1,0);
	    timer.schedule(t2,0);
	    timer.schedule(t3,0);
		if(start2 == false)
		jumsu.setText("점수 : " + count);
	}
	
	 public void play(String fileName) {
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
	
	public void mousePressed(MouseEvent e) {
		//cursor = tk.createCustomCursor(mouseClickImg, point, "click hammer");
		//setCursor(cursor);
	}
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		//cursor = tk.createCustomCursor(mouseImg, point, "hammer");
		//setCursor(cursor);
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
	}
}
