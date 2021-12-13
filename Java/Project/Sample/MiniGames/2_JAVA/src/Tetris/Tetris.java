package Tetris;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Main.GameUI;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Tetris extends JFrame implements Runnable{
	Container co;
	static final int height=22 ,width=14;
	ImageIcon BackGround, red,orange,pink,blue,green,yellow,mint,com;
	ImageIcon red1, orange1, pink1, blue1, green1, yellow1, mint1;
	JPanel p, p2, p3, board, preview;
    JLabel bo[][] = new JLabel[height][width];
	JLabel pre[][] = new JLabel[4][4];
	JLabel bk[][][][] = new JLabel[7][4][4][4];
	boolean blockCheck=true, right=true, left=true, space=false, flag=false, flag2=false, start=false, thread=true, music = false;
	Random r;
	int ran, col, row, col2, row2, bRow, bCol, tCol, tRow, turn, count, count2, speed=250, bufSpeed, score;
	int  a, b, c, d, a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, buf;
	String speedStr="보통";

	public void init(){ // 기본 실행 메소드
        loadImg();
		co = getContentPane();
		co.setLayout(null);

		p = new JPanel(new BorderLayout());
		p.setBounds(0 ,0,450, 697);
		board = new JPanel(new GridLayout(height,width,1,1));
		board.setBackground(Color.darkGray);

		p2 = new JPanel(new BorderLayout());
		p2.setBounds(510,50,170, 170);
		preview = new JPanel(new GridLayout(4,4,1,1));
		preview.setBackground(Color.black);

		p3 = new JPanel(new BorderLayout());
		p3.setBounds(450 ,0,450, 750);

		co.add(p);
		p.add(board);
		co.add(p2);
		p2.add(preview);
		co.add(p3);
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(BackGround.getImage(),0,0,null);
				g.setColor(Color.white);
				g.drawString("점수 : "+score, 30, 300);
				g.drawString("속도 : "+speedStr, 30, 320);
				g.drawString("시작 버튼 : A", 30, 340);
				g.drawString("노래 끄기 : W ", 30, 360);
				g.drawString("노래 켜기 : Q ", 30, 380);
				g.drawString("방향키", 30, 400);
				g.drawString(" ←  ↓  →", 30, 420);
				g.drawString("↑ : 블록 회전", 30, 440);
				g.drawString("Space : 밑으로 떨어지기 ", 30, 460);

			}
		};
		p3.add(panel);

		boardset();
		previewset();
		blockset();
		compare();

		TetrisHandler th =new TetrisHandler(this);
		addKeyListener(th);
		ran();
		thread = true;
		new Thread(this).start();
        setUI();
    }

	void loadImg(){ // 이미지 삽입
		try{
			BackGround = new ImageIcon(ImageIO.read(new File("imgs/tetris/BackGround.png")));
			red = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_r.jpg")));
			orange = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_o.jpg")));
			pink = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_m.jpg")));
			blue = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_l.jpg")));
			green = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_g.jpg")));
			yellow = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_y.jpg")));
			mint = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_c.jpg")));
			red1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_r1.jpg")));
			orange1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_o1.jpg")));
			pink1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_m1.jpg")));
			blue1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_l1.jpg")));
			green1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_g1.jpg")));
			yellow1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_y1.jpg")));
			mint1 = new ImageIcon(ImageIO.read(new File("imgs/tetris/b_c1.jpg")));
			com = new ImageIcon(ImageIO.read(new File("imgs/tetris/com.png")));
		}catch(IOException ie){
			System.out.println("이미지 불러오기 실패");
		}
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
	void previewset(){
		for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
				pre[i][j] = new JLabel("0");
                preview.add(pre[i][j]);
            }
        }
		compare2();
	}
	void previewReset(){
		for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
				pre[i][j].setText("0");
            }
        }
		compare2();
	}
	void boardset(){ // 기본 보드 세팅
		for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
				bo[i][j] = new JLabel("0");
                board.add(bo[i][j]);
            }
        }
	}
	void boardReset(){ // 재시작 보드 세팅
		for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
				bo[i][j].setText("0");
            }
        }
	}
	void blockset(){ 
		for(int l=0; l<bk.length; l++){	
			for(int k=0; k<bk[l].length; k++){	
				for (int i=0; i<Block.bk[l][k].length; i++) {
					for (int j=0; j<Block.bk[l][k][i].length; j++){
						if(Block.bk[l][k][i][j]==1){
							if(l==0){
								bk[l][k][i][j] = new JLabel("1");}
							else if(l==1){
								bk[l][k][i][j] = new JLabel("2");}
							else if(l==2){
								bk[l][k][i][j] = new JLabel("3");}
							else if(l==3){
								bk[l][k][i][j] = new JLabel("4");}
							else if(l==4){
								bk[l][k][i][j] = new JLabel("5");}
							else if(l==5){
								bk[l][k][i][j] = new JLabel("6");}
							else if(l==6){
								bk[l][k][i][j] = new JLabel("7");}
						}
						else bk[l][k][i][j] = new JLabel("0");
					}
				}
			}
		}
	}
	void compare(){ // 보드 리페인트
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(bo[i][j].getText().equals("0")) // 아무것도 없음
					bo[i][j].setIcon(BackGround);
				else if(bo[i][j].getText().equals("1")) // 블럭
					bo[i][j].setIcon(red);
				else if(bo[i][j].getText().equals("2")) // 블럭
					bo[i][j].setIcon(orange);
				else if(bo[i][j].getText().equals("3")) // 블럭
					bo[i][j].setIcon(pink);
				else if(bo[i][j].getText().equals("4")) // 블럭
					bo[i][j].setIcon(blue);
				else if(bo[i][j].getText().equals("5")) // 블럭
					bo[i][j].setIcon(green);
				else if(bo[i][j].getText().equals("6")) // 블럭
					bo[i][j].setIcon(yellow);
				else if(bo[i][j].getText().equals("7")) // 블럭
					bo[i][j].setIcon(mint);
			}
		}
	}
	void compare2(){ // 프리뷰 리페인트
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(pre[i][j].getText().equals("0")) // 아무것도 없음
					pre[i][j].setIcon(BackGround);
				else if(pre[i][j].getText().equals("1")) // 블럭
					pre[i][j].setIcon(red1);
				else if(pre[i][j].getText().equals("2")) // 블럭
					pre[i][j].setIcon(orange1);
				else if(pre[i][j].getText().equals("3")) // 블럭
					pre[i][j].setIcon(pink1);
				else if(pre[i][j].getText().equals("4")) // 블럭
					pre[i][j].setIcon(blue1);
				else if(pre[i][j].getText().equals("5")) // 블럭
					pre[i][j].setIcon(green1);
				else if(pre[i][j].getText().equals("6")) // 블럭
					pre[i][j].setIcon(yellow1);
				else if(pre[i][j].getText().equals("7")) // 블럭
					pre[i][j].setIcon(mint1);
			}
		}
	}
	void preview(int ran){
		for (int i=0; i<4; i++) {// 프리뷰 블록 찍어내기
			for (int j=0; j<4; j++){
				if(pre[i][j].getText().equals("0"))
					pre[i][j].setText(bk[ran][turn][i][j].getText());
			}
		}
	}
	public void run(){ // 쓰레드
		while(thread){ 
			try{
				Thread.sleep(10);
			}catch(Exception e5){}
			if(start == true){
				col = 6; // 시작 행 위치값
				turn = 0;
				choice(); 
				if(space==true){
					try{
						Thread.sleep(speed+100);
					}catch(Exception e4){}
				}
					blockCheck=true;
			}
		}
	}
	void choice(){ // 블럭 랜덤 선택
			r = new Random();
			buf = r.nextInt(7);
			preview(buf);
			compare2();
			drop();
			ran =buf;
	}
	void drop(){ // 블럭 떨어지는 로직
		col = 6;
		row = -1;
		while(blockCheck==true){
			try{
				move1(1,0);
				Thread.sleep(speed);
			}catch(Exception e){}
		}
	}
	synchronized void move1(int row2, int col2){
		speed();
		count();
		if(col2==1) col = col+col2;					
		else if(col2==-1) col = col+col2;		
		else if(row2==1) row = row+row2;
		

		for (int i=0; i<bRow; i++) {// 블록 찍어내기
			for (int j=0; j<bCol; j++){
				if(bo[row+i][col+j].getText().equals("0"))
					bo[row+i][col+j].setText(bk[ran][turn][i][j].getText());
			}
		}
		compare(); // 아이콘 삽입
		col2=0;
		row2=0;
		left=true;
		right=true;
		lCompare(); // 왼쪽에 블럭이 있는지 확인
		rCompare(); // 오른쪽에 블럭이 있는지 확인
		dCompare(); // 밑에 블럭이 있는지 확인
		if(blockCheck==true)
			delete(); 
		else move2();
	}
	void count(){ // 상하좌우 공백 확인
		upCount();
		downCount();
		leftCount();
		rightCount();
		rCount(0);
		cCount(0);
	}
	void speed(){
		if(space==false){
			if (score < 11){
				speed= 250;
				if(flag2==false) speedStr="평범";
				flag2=true;
			}
			else if (score < 71){
				speed= 200;
				if(flag2==true) speedStr="슬슬빠름";
				flag2=false;
			}
			else if (score < 201){
				speed= 150;
				if(flag2==false) speedStr="빠름";
				flag2=true;
			}
			else{
				speed= 100;
				if(flag2==true) speedStr="매우 빠름";
				flag2=false;
			}
		}
	}
	void move2(){
		preDelete();
		for(int i=0; i<14; i++){
			if(!(bo[0][i].getText().equals("0"))){
				gameOver();
				break;
			}
		}
		for(int i=height-1; i>-1; i--){
			count=0;
            for(int j=0; j<width; j++){
				if(!(bo[i][j].getText().equals("0"))){
					count++;}
				if(count == 14){
					score+=10;
					p3.repaint();
					clear(i);
					compare();
					i++;
				}
            }
        }
	}
	void clear(int i){ // 한줄 차면 삭제
		for(int j=0; j<14; j++){
			bo[i][j].setText("0");
		}
		while(i>-1){
			for(int j=0; j<width; j++){
				if(i>0){
					bo[i][j].setText(bo[i-1][j].getText());
					bo[i-1][j].setText("0");
				}
			}
			i--;
		}
		
	}
	void delete(){ // 삭제
		if(bCol >3){
			for(int i=d3; i<d+1; i++)
				bo[row+i][col+3].setText("0");
		}
		if(bCol >2){
			for(int i=c3; i<c+1; i++)
				bo[row+i][col+2].setText("0");
		}
		if (bCol>1){
			for(int i=b3; i<b+1; i++)
				bo[row+i][col+1].setText("0");
		}
		if (bCol >0){
			for(int i=a3; i<a+1; i++)
				bo[row+i][col].setText("0");
		}
	}
	void preDelete(){ // 프리뷰 블록 삭제
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				pre[i][j].setText("0");
			}
		}
	}
	void rCount(int n){ // 블럭의 오른쪽 가로 갯수 판별
		aa:
		for(int j=3; j>-1; j--){ 
			for(int i=0; i<4; i++){
				if(!(bk[ran][turn+n][i][j].getText().equals("0"))){
					if(n>0){
						tCol = j;
						break aa;
					}
					else{
						bCol = j+1;
						break aa;
					}
				}
			}
		}	
	}
	void cCount(int n){ // 블럭의 세로 갯수 판별
		aa:
		for(int i=3; i>-1; i--){ 
			for(int j=0; j<3; j++){
				if(!(bk[ran][turn+n][i][j].getText().equals("0"))){
					if(n>0){
						tRow = i;
						break aa;
					}
					else{
						bRow = i+1;
						break aa;
					}
				}
			}
		}
	}
	void downCount(){ // 블럭의 밑쪽 세로 공백 판별
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][i][0].getText().equals("0")))
				a = i;
			if(!(bk[ran][turn][i][1].getText().equals("0")))
				b = i;
			if(!(bk[ran][turn][i][2].getText().equals("0")))
				c = i;
			if(!(bk[ran][turn][i][3].getText().equals("0")))
				d = i;
		}
	}
	void rightCount(){ // 블럭의 오른쪽 가로 공백 판별
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][0][i].getText().equals("0")))
				a1 = i;
			if(!(bk[ran][turn][1][i].getText().equals("0")))
				b1 = i;
			if(!(bk[ran][turn][2][i].getText().equals("0")))
				c1 = i;
			if(!(bk[ran][turn][3][i].getText().equals("0")))
				d1 = i;
		}
	}
	void leftCount(){ // 블럭의 왼쪽 가로 공백 판별
		for(int i=3; i>-1; i--){
			if(!(bk[ran][turn][0][i].getText().equals("0")))
				a2 = i;
			if(!(bk[ran][turn][1][i].getText().equals("0")))
				b2 = i;
			if(!(bk[ran][turn][2][i].getText().equals("0")))
				c2 = i;
			if(!(bk[ran][turn][3][i].getText().equals("0")))
				d2 = i;
		}
	}
	void upCount(){ // 블럭의 위쪽 세로 공백 판별
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][i][0].getText().equals("0"))){
				a3 = i;
				break;
			}
		}
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][i][1].getText().equals("0"))){
				b3 = i;
				break;
			}
		}
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][i][2].getText().equals("0"))){
				c3 = i;
				break;
			}
		}
		for(int i=0; i<4; i++){
			if(!(bk[ran][turn][i][3].getText().equals("0"))){
				d3 = i;
				break;
			}
		}
	}
	void turn(){ // 블럭 체인지
		if(turn<3){
			rCount(1);
			cCount(1);
			for (int i=0; i<tRow; i++) {// 블록 비교하기
				for (int j=0; j<tCol; j++){
					if(bo[row+i][col+j].getText().equals("0"));
					else count2++;
				}
			}	
			if(row+tRow<20 && col+tCol<14 && count2==0){
				turn++;
			}
			count2=0;
		}
		else{
			rCount(0);
			cCount(0);
			for (int i=0; i<tRow; i++) {
				for (int j=0; j<tCol; j++){
					if(bo[row+i][col+j].getText().equals("0"));
					else count2++;
				}
			}
			if(row+tRow<20 && col+tCol<14 && count2==0){
				turn=0;
			}
			count2=0;
		}
	}
	void dCompare(){
		if(row+(bRow-1)==21){ // 밑의 블럭과 비교 구문
				blockCheck=false;
			}
		else{
			if(bCol >3){
				if(!(bo[row+d][col+3].getText().equals("0")) && !(bo[row+d+1][col+3].getText().equals("0")))
				blockCheck=false;
			}
			if(bCol >2){
				if(!(bo[row+c][col+2].getText().equals("0")) && !(bo[row+c+1][col+2].getText().equals("0")))
				blockCheck=false;
			}
			if (bCol >1){
				if(!(bo[row+b][col+1].getText().equals("0")) && !(bo[row+b+1][col+1].getText().equals("0")))
				blockCheck=false;
			}
			if (bCol >0){
				if(!(bo[row+a][col].getText().equals("0")) && !(bo[row+a+1][col].getText().equals("0")))
				blockCheck=false;
			}
		}
	}
	void rCompare(){
		if(col+bCol == 14); // 오른쪽 블럭과 비교 구문
		else{
			if(bRow >3 && row<18){
				if(!(bo[row+3][col+d1].getText().equals("0")) && !(bo[row+3][col+d1+1].getText().equals("0")))
				right = false;
			}
			if(bRow >2 && row<19){
				if(!(bo[row+2][col+c1].getText().equals("0")) && !(bo[row+2][col+c1+1].getText().equals("0")))
				right = false;
			}
			if (bRow >1 && row<20){
				if(!(bo[row+1][col+b1].getText().equals("0")) && !(bo[row+1][col+b1+1].getText().equals("0")))
				right = false;
			}
			if (bRow >0 && row<21){
				if(!(bo[row][col+a1].getText().equals("0")) && !(bo[row][col+a1+1].getText().equals("0")))
				right = false;
			}
		}
	}
	void lCompare(){
		if(col+bCol == 0); // 왼쪽 블럭과 비교 구문
		else{
			if(bRow >3 && col+d2>0){
				if(!(bo[row+3][col+d2].getText().equals("0")) && !(bo[row+3][col+d2-1].getText().equals("0")))
				left = false;
			}
			if(bRow >2 && col+d2>0){
				if(!(bo[row+2][col+c2].getText().equals("0")) && !(bo[row+2][col+c2-1].getText().equals("0")))
				left = false;
			}
			if (bRow >1 && col+d2>0){
				if(!(bo[row+1][col+b2].getText().equals("0")) && !(bo[row+1][col+b2-1].getText().equals("0")))
				left = false;
			}
			if (bRow >0 && col+d2>0){
				if(!(bo[row][col+a2].getText().equals("0")) && !(bo[row][col+a2-1].getText().equals("0")))
				left = false;
			}
		}
	}
	void setUI() { // UI실행 및 기본세팅 메소드
		setTitle("Tetris");
        setSize(685,720);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void ran(){
		r = new Random();
		ran = r.nextInt(7);
	}
	void gameOver(){
		int answer = JOptionPane.showConfirmDialog(null, "점수 : "+score+"\n 다시 하시겠습니까?", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
    	if(answer == JOptionPane.YES_OPTION) {
			boardReset();
			compare();
			previewReset();
			ran();
			reset();
			p3.repaint();
    	}else {
			music = false;
			thread = false;
			setVisible(false);
    		new GameUI().setUI();
	    }
	}
	void reset(){
		speedStr="보통";
		turn=0; count=0; speed=250; bufSpeed=0; score=0;
		flag=false; flag2=false; start=false; music=false;
	}
}


