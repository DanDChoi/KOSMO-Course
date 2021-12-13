package Snake;

import java.util.*;
import java.util.Timer;
import java.io.*;
import java.awt.*;
import javax.swing.*;

import Main.GameUI;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Snake extends JFrame implements Runnable{
    final int WIDTH = 30;
    final int HEIGHT = 30;
    final int RIGHT = 1;
    final int LEFT = 2;
    final int UP = 3; 
    final int DOWN = 4;
    int low, loh, bodyCount, foodCount, score, speed, way;
    Boolean snakeColor = false;
    Boolean game = true;
    Boolean music;
    
    ImageIcon backImg, foodImg, itemImg, medicineImg, snakeLogo, grapeImg, com6Img,
    leftHead, upHead, downHead, rightHead,
    leftBody, upBody, downBody, rightBody,
    leftTail, upTail, downTail, rightTail,
    leftUp, upRight, downLeft, rightDown;
    
    JPanel board;
    JLabel snake[][] = new JLabel[WIDTH][HEIGHT];
    
    ArrayList<JLabel> bodyList = new ArrayList<JLabel>();
    Random r = new Random();
    
    public void init() {
    	loadImg();
    	setUI();
        setBoard();
        Timer time = new Timer();
		TimerTask t = new TimerTask(){
			public void run(){
				music = true;
				mplay("imgs/snake/bgm.wav");
			}
		};
		time.schedule(t, 0);
        new Thread(this).start();
    }
    void setUI() {
    	setTitle("Snake Game");
        setSize(690,690);
        setLocationRelativeTo(null);
		setFocusable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void setBoard(){
		way = 0;
		low = WIDTH/2;
		loh = HEIGHT/2;
	    bodyCount = 0;
	    foodCount = 0;
	    score = 0;
	    speed = 192;
    	add(board, BorderLayout.CENTER);
        board.setLayout(new GridLayout(WIDTH,HEIGHT));
        addKeyListener(new SnakeHandler(this));
        for(int i=0; i<WIDTH; i++){
            for(int j=0; j<HEIGHT; j++){
                snake[i][j] = new JLabel();
                board.add(snake[i][j]);
            }
        }
        bodyList.add(snake[low][loh]);	//head
        bodyList.get(0).setIcon(upHead);
        makeFood();
        addBody();
        addBody();
        addBody();
    }
    void addBody(){
    	bodyCount++;
        bodyList.add(bodyCount, bodyList.get(bodyCount-1));
        if(bodyCount % 6 == 0) makeItem();
        if(speed>50) speed-=4;
        board.repaint();
    }
    void makeFood(){
        int ranW = r.nextInt(WIDTH);
        int ranH = r.nextInt(HEIGHT);
        if(snake[ranW][ranH].getIcon()==null) {
            snake[ranW][ranH].setIcon(foodImg);
        	foodCount++;
        	board.repaint();
        }else makeFood();
    }
    void makeItemFood() {
        int ranW = r.nextInt(WIDTH);
        int ranH = r.nextInt(HEIGHT);
        if(snake[ranW][ranH].getIcon()==null) {
            snake[ranW][ranH].setIcon(grapeImg);
        	board.repaint();
        }else makeItemFood();
    }
    void makeItem() {
        int ranW = r.nextInt(WIDTH);
        int ranH = r.nextInt(HEIGHT);
        if(snakeColor == false) {
            if(snake[ranW][ranH].getIcon()==null) snake[ranW][ranH].setIcon(itemImg);
            else makeItem(); 	
        }
    }
    void useItem() {
    	int item = r.nextInt(6);
    	if(item==0) {	//꼬리 늘리기 
    		for(int i=0; i<7; i++) {
    			addBody();
    			score++;
    		}
    	}else if(item==1) { //꼬리 자르기 
    		if(bodyCount>10) {
    			try {
        			for(int i = 0; i<7; i++) {
            			bodyList.get(bodyCount).setIcon(null);
            			bodyList.remove(bodyCount);
            			bodyCount--;
            			score--;
            			speed+=5;
            		}board.repaint();
    			}catch(Exception e) {}
    		}else useItem();
    	}else if(item==2) {	//먹이 1개 추가 
    		if(foodCount<3) makeFood();
    		else useItem();
    	}else if(item==3) {	//속도 늘리기
    		if(speed>90) speed -= 40;
    		else useItem();
    	}else if(item==4) { // 속도 감소 
    		if(speed<153) speed += 40;
    		else useItem();
    	}else if(item==5) {
    		changeSnake();
    	}else if(item==6) {
    		makeItemFood();
    	}
    }
    void changeSnake() {
		if(snakeColor == false) {
			int ranW = r.nextInt(WIDTH);
			int ranH = r.nextInt(HEIGHT);
			if(snake[ranW][ranH].getIcon()==null) {
				snake[ranW][ranH].setIcon(medicineImg);
				snakeColor=true;
				changeSnakeImg();
				board.repaint();
				speed = 50;
			}else changeSnake();
		}else if(snakeColor == true) useItem();
    }
    synchronized void moveSnake(int w, int h) {
    	try {
			if(snake[low+w][loh+h].getIcon()==null){
            	bodyList.get(0).setName(Integer.toString(way));
                for(int j=bodyCount; j>0; j--){
                	bodyList.get(j).setIcon(null);
                    bodyList.set(j, bodyList.get(j-1));
                    bodyList.get(j).setName(bodyList.get(j-1).getName());
                }
                setSnake();
                low += w;
                loh += h;
                bodyList.set(0, snake[low][loh]);
                board.repaint();
            }else if(snake[low+w][loh+h].getIcon().equals(foodImg) || snake[low+w][loh+h].getIcon().equals(grapeImg)){
            	if(snake[low+w][loh+h].getIcon().equals(foodImg)) {
                	snake[low+w][loh+h].setIcon(null);
                	score++;
                	addBody();
                	makeFood();
                	foodCount--;
            	}else {
                	snake[low+w][loh+h].setIcon(null);
                	score +=10;
            	}
                moveSnake(w,h);
            }else if(snake[low+w][loh+h].getIcon().equals(itemImg)){
            	snake[low+w][loh+h].setIcon(null);
            	useItem();
            	moveSnake(w,h);
            }else if(snake[low+w][loh+h].getIcon().equals(medicineImg)) {
            	snake[low+w][loh+h].setIcon(null);
            	snakeColor = false;
            	changeSnakeImg();
            	speed = 150;
            	moveSnake(w,h);
            }else if(snake[low+w][loh+h].getName().equals("1")||snake[low+w][loh+h].getName().equals("2")||snake[low+w][loh+h].getName().equals("3")||snake[low+w][loh+h].getName().equals("4")) {
        		gameOver();
            }
    	}catch(ArrayIndexOutOfBoundsException ae){
    		gameOver();
        }
    }
   void autoMove(){
		while(game){
            try{
            	Thread.sleep(speed);
            	if(way==UP){
            		moveSnake(-1,0);
            		bodyList.get(0).setIcon(upHead);
                }else if(way==RIGHT){
            		moveSnake(0,1);
                    bodyList.get(0).setIcon(rightHead);
                }else if(way==LEFT){
            		moveSnake(0,-1);
            		bodyList.get(0).setIcon(leftHead);
                }else if(way==DOWN){
            		moveSnake(1,0);
                    bodyList.get(0).setIcon(downHead);
                }
            }catch(Exception e){}
    	}
    }
    void setSnake() {
    	for(int i=1; i<bodyList.size(); i++) {
        	switch (bodyList.get(i).getName()) {
    			case "1": bodyList.get(i).setIcon(rightBody); break;
    			case "2": bodyList.get(i).setIcon(leftBody); break;    	
    			case "3": bodyList.get(i).setIcon(upBody); break;
    			case "4": bodyList.get(i).setIcon(downBody); break;
    		}
    	}
    	for(int i=1; i<bodyList.size(); i++) {
    		if(bodyList.get(i-1).getName().equals("1")&&bodyList.get(i).getName().equals("3"))
    			bodyList.get(i-1).setIcon(rightDown);
    		else if(bodyList.get(i-1).getName().equals("1")&&bodyList.get(i).getName().equals("4"))
    			bodyList.get(i-1).setIcon(upRight);
    		else if(bodyList.get(i-1).getName().equals("2")&&bodyList.get(i).getName().equals("3"))
    			bodyList.get(i-1).setIcon(downLeft);
    		else if(bodyList.get(i-1).getName().equals("2")&&bodyList.get(i).getName().equals("4"))
    			bodyList.get(i-1).setIcon(leftUp);
    		else if(bodyList.get(i-1).getName().equals("3")&&bodyList.get(i).getName().equals("1"))
    			bodyList.get(i-1).setIcon(leftUp);
    		else if(bodyList.get(i-1).getName().equals("3")&&bodyList.get(i).getName().equals("2"))
    			bodyList.get(i-1).setIcon(upRight);
    		else if(bodyList.get(i-1).getName().equals("4")&&bodyList.get(i).getName().equals("1"))
    			bodyList.get(i-1).setIcon(downLeft);
    		else if(bodyList.get(i-1).getName().equals("4")&&bodyList.get(i).getName().equals("2"))
    			bodyList.get(i-1).setIcon(rightDown);
    	}
    	switch (bodyList.get(bodyList.size()-1).getName()) {
			case "1": bodyList.get(bodyList.size()-1).setIcon(rightTail); break;
			case "2": bodyList.get(bodyList.size()-1).setIcon(leftTail); break;    	
			case "3": bodyList.get(bodyList.size()-1).setIcon(upTail); break;
			case "4": bodyList.get(bodyList.size()-1).setIcon(downTail); break;
    	}     
    }
    void gameOver() {
    	setVisible(false);
    	game = false;
		int answer = JOptionPane.showConfirmDialog(null, "점수: " + score + "\n다시 시작 할까요?", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, snakeLogo);	
        for(int i=0; i<WIDTH; i++)
            for(int j=0; j<HEIGHT; j++) {
            	snake[i][j].setIcon(null);
                board.remove(snake[i][j]);
            }
        bodyList.removeAll(bodyList);
        music = false;
    	if(answer == JOptionPane.YES_OPTION) {
    		music = true;
    		setVisible(true);
    		snakeColor = false;
    		loadImg();
    		setBoard();
    		game=true;
    	}else {
    		removeAll();
    		setVisible(false);
    		new GameUI().setUI();
    	}
    }
    public void mplay(String fileName) {
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
    public void run(){
        autoMove();
    }
    void loadImg(){
		try{
			changeSnakeImg();
			medicineImg = new ImageIcon(ImageIO.read(new File("imgs/snake/medicine.png")));
            itemImg = new ImageIcon(ImageIO.read(new File("imgs/snake/item.jpeg")));
            foodImg = new ImageIcon(ImageIO.read(new File("imgs/snake/food.png")));
            snakeLogo = new ImageIcon(ImageIO.read(new File("imgs/snake/snakeLogo.png")));
            grapeImg = new ImageIcon(ImageIO.read(new File("imgs/snake/grape.png")));
            com6Img = new ImageIcon(ImageIO.read(new File("imgs/snake/com6Img.png")));
    		board = new JPanel() {
                public void paintComponent(Graphics g) {
                	super.paintComponent(g);
                    g.drawImage(backImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                    g.drawImage(com6Img.getImage(), 620, 640, this);
                    g.setFont(new Font(null, Font.BOLD ,15));
                    g.drawString("점수 : "+score, 10, 20);
                    g.drawString("Speed: "+(180-speed), 10, 40);
                    setOpaque(true);
                }
            };
		}catch(IOException ie){}
    }
    void changeSnakeImg() {
    	try {
    		if(snakeColor==false) {
    			backImg = new ImageIcon(ImageIO.read(new File("imgs/snake/back1.jpg")));
                upHead = new ImageIcon(ImageIO.read(new File("imgs/snake/up.png")));         
                downHead = new ImageIcon(ImageIO.read(new File("imgs/snake/down.png")));
                leftHead = new ImageIcon(ImageIO.read(new File("imgs/snake/left.png")));
                rightHead = new ImageIcon(ImageIO.read(new File("imgs/snake/right.png")));
                upBody = new ImageIcon(ImageIO.read(new File("imgs/snake/upbody.png")));         
                downBody = new ImageIcon(ImageIO.read(new File("imgs/snake/downbody.png")));
                leftBody = new ImageIcon(ImageIO.read(new File("imgs/snake/leftbody.png")));
                rightBody = new ImageIcon(ImageIO.read(new File("imgs/snake/rightbody.png")));
                upTail = new ImageIcon(ImageIO.read(new File("imgs/snake/uptail.png")));         
                downTail = new ImageIcon(ImageIO.read(new File("imgs/snake/downtail.png")));
                leftTail = new ImageIcon(ImageIO.read(new File("imgs/snake/lefttail.png")));
                rightTail = new ImageIcon(ImageIO.read(new File("imgs/snake/righttail.png")));
                leftUp = new ImageIcon(ImageIO.read(new File("imgs/snake/leftup.png")));
                upRight = new ImageIcon(ImageIO.read(new File("imgs/snake/upright.png")));
                downLeft = new ImageIcon(ImageIO.read(new File("imgs/snake/downleft.png")));
                rightDown = new ImageIcon(ImageIO.read(new File("imgs/snake/rightdown.png")));
    		}else {
    			backImg = new ImageIcon(ImageIO.read(new File("imgs/snake/green/back.jpg")));
           	 	upHead = new ImageIcon(ImageIO.read(new File("imgs/snake/green/up.png")));         
                downHead = new ImageIcon(ImageIO.read(new File("imgs/snake/green/down.png")));
                leftHead = new ImageIcon(ImageIO.read(new File("imgs/snake/green/left.png")));
                rightHead = new ImageIcon(ImageIO.read(new File("imgs/snake/green/right.png")));
                upBody = new ImageIcon(ImageIO.read(new File("imgs/snake/green/upbody.png")));         
                downBody = new ImageIcon(ImageIO.read(new File("imgs/snake/green/downbody.png")));
                leftBody = new ImageIcon(ImageIO.read(new File("imgs/snake/green/leftbody.png")));
                rightBody = new ImageIcon(ImageIO.read(new File("imgs/snake/green/rightbody.png")));
                upTail = new ImageIcon(ImageIO.read(new File("imgs/snake/green/uptail.png")));         
                downTail = new ImageIcon(ImageIO.read(new File("imgs/snake/green/downtail.png")));
                leftTail = new ImageIcon(ImageIO.read(new File("imgs/snake/green/lefttail.png")));
                rightTail = new ImageIcon(ImageIO.read(new File("imgs/snake/green/righttail.png")));
                leftUp = new ImageIcon(ImageIO.read(new File("imgs/snake/green/leftup.png")));
                upRight = new ImageIcon(ImageIO.read(new File("imgs/snake/green/upright.png")));
                downLeft = new ImageIcon(ImageIO.read(new File("imgs/snake/green/downleft.png")));
                rightDown = new ImageIcon(ImageIO.read(new File("imgs/snake/green/rightdown.png")));
    		}
    	}catch(IOException ie) {}
    }
}