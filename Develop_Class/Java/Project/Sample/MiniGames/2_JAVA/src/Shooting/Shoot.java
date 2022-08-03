package Shooting;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;

import Main.GameUI;

public class Shoot extends JFrame implements Runnable, KeyListener {
	BufferedImage bi;
	ArrayList msList;
	ArrayList enList;
	ArrayList enList2;
	ArrayList itemList;
	ArrayList itemList2;
	ArrayList<Particle> particles;
	Graphics gs;
	Enemy en;
	Enemy en2;
	int enspeed1;
	int enspeed2;
	int entcnt;
	int encnt;
	int encnt2;
	int itemCnt;
	int itemCnt2;
	int rx = (int) (Math.random() * -4);
	int rx2 = (int) (Math.random() * 3);
	Clip clip;
	Font ft = new Font("맑은고딕", Font.BOLD, 14);
	Font ftd = new Font("맑은고딕",Font.PLAIN, 12);

	BufferStrategy bufferstrat = null;
	Polygon pol;

	boolean left, right, up, down, fire, dfire, mfire;
	public boolean start;
	boolean end;
	int w = 350, h = 700, x = 160, y = 530, xw = 40, xh = 40;
	int score;
	int life;
	ImageIcon p1 = new ImageIcon("imgs/shooting/P_1.png");
	Image img = p1.getImage();
	ImageIcon e1 = new ImageIcon("imgs/shooting/E_l.png");
	Image emg = e1.getImage();
	ImageIcon e2 = new ImageIcon("imgs/shooting/E_g.png");
	Image emg2 = e2.getImage();
	ImageIcon bg = new ImageIcon("imgs/shooting/space.png");
	Image bmg = bg.getImage();
	ImageIcon ms = new ImageIcon("imgs/shooting/ms.png");
	Image mmg = ms.getImage();
	ImageIcon ms2 = new ImageIcon("imgs/shooting/ms2.png");
	Image mmg2 = ms2.getImage();
	ImageIcon it = new ImageIcon("imgs/shooting/item.png");
	Image itmg = it.getImage();
	ImageIcon it2 = new ImageIcon("imgs/shooting/item2.png");
	Image itmg2 = it2.getImage();

	public Shoot() {

		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		msList = new ArrayList();
		enList = new ArrayList();
		enList2 = new ArrayList();
		itemList = new ArrayList();
		itemList2 = new ArrayList();
		particles = new ArrayList<Particle>(500);
		score = 0;
		life = 3;
		enspeed1 = 5;
		enspeed2 = 7;
		encnt = 9;
		encnt2 = 5;

		this.addKeyListener(this);
		this.setSize(w, h);
		this.setTitle("슈팅게임");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.createBufferStrategy(2);
		bufferstrat = this.getBufferStrategy();
		mplay("imgs/shooting/bgm.wav");
		new Thread(this).start();
	}

	public void run() {
		try {
			int msCnt = 0;
			entcnt = 0;
			itemCnt = 0;
			itemCnt2 = 0;
			while (true) {
				Thread.sleep(10);
				if (start) {
					if (itemCnt == 5000) {// 5초에 아이템1 생성
						itemCreate();
					}
					if (itemCnt == 12000) {// 12초에 아이템1 생성
						itemCreate();
					}
					if (itemCnt2 == 20000) {// 20초에 아이템2 생성
						itemCreate2();
					}
					if (entcnt > 2000) {// 2초마다 적군 생성
						enCreate();
						enCreate2();
						entcnt = 0;
					}
					if (msCnt > 100) {// 100밀리초마다 미사일 발사
						fireMs();
						if (dfire == true) {// 아이템을 먹었을시 미사일 추가발사
							fireMs2();
						}
						msCnt = 0;
					}
					msCnt += 10;
					entcnt += 10;
					itemCnt += 10;
					itemCnt2 += 10;
					keyControl();
					try {
						crashChk();
					} catch (Exception ne) {
					}
				}

				update();
				draw();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mplay(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			clip = AudioSystem.getClip();
			try {
				clip.stop();
				}catch(NullPointerException ne) {}
			clip.open(ais);
			try {
				clip.start();
				}catch(NullPointerException ne) {}
			clip.loop(100);
		} catch (Exception ex) {
		}
	}

	public void fireMs() {// 미사일 발사
		if (fire) {
			if (msList.size() < 100) {
				Ms m = new Ms(this.x + 18, this.y - 30, 5, 18);
				msList.add(m);
			}
			if (mfire == true) {
				Ms m = new Ms(this.x + 16, this.y - 30, 10, 18);
				msList.add(m);
			}
		}
	}

	public void fireMs2() {// 아이템 습득시 미사일 두갈래 추가
		if (fire) {
			if (msList.size() < 100) {
				Ms m = new Ms(this.x, this.y - 22, 5, 18);
				Ms m2 = new Ms(this.x + 35, this.y - 22, 5, 18);
				msList.add(m);
				msList.add(m2);
			}
			if (mfire == true) {
				Ms m = new Ms(this.x, this.y - 22, 7, 18);
				Ms m2 = new Ms(this.x + 35, this.y - 22, 7, 18);
				msList.add(m);
				msList.add(m2);
			}
		}
	}

	public void itemCreate() { // 아이템 생성(노랑별)
		for (int i = 0; i < 1; i++) {
			double rx = Math.random() * (w - xw);
			double ry = Math.random() * 60;
			ItemC it = new ItemC((int) rx, (int) ry, 6);
			itemList.add(it);
		}
	}

	public void itemCreate2() { // 아이템 생성(파랑별)
		for (int i = 0; i < 1; i++) {
			double rx = Math.random() * (w - xw);
			double ry = Math.random() * 60;
			ItemC it = new ItemC((int) rx, (int) ry, 10);
			itemList2.add(it);
		}
	}

	public void enCreate() { // 적군 생성(파랑이)
		for (int i = 0; i < encnt; i++) {
			double rx = Math.random() * (w - xw);
			double ry = Math.random() * 60;
			en = new Enemy((int) rx, (int) ry, enspeed1);
			enList.add(en);
		}
		if (score > 300 && score < 400) {
			enspeed1 += 1;
			encnt += 1;
		} else if (score > 1000 && score < 1200) {
			enspeed1 += 2;
			encnt += 2;
		} else if (score > 2000 && score < 2300) {
			enspeed1 += 2;
			encnt += 2;
		}
	}

	public void enCreate2() { // 적군 생성2(더 빠른 초록이)
		for (int i = 0; i < encnt2; i++) {
			double rx = Math.random() * (w - xw);
			double ry = Math.random() * 50;
			en2 = new Enemy((int) rx, (int) ry, enspeed2);
			enList2.add(en2);
		}
		if (score > 200 && score < 300) {
			enspeed2 += 2;
			encnt2 += 1;
		} else if (score > 1000 && score < 1200) {
			enspeed2 += 3;
			encnt2 += 2;
		} else if (score > 2000 && score < 2200) {
			enspeed2 += 3;
			encnt2 += 2;
		}
	}

	public void crashChk() { // 충돌 판정 메소드
		Graphics gs = bi.getGraphics();
		// Polygon p = null;
		for (int i = 0; i < msList.size(); i++) {
			Ms m = (Ms) msList.get(i);
			for (int j = 0; j < enList.size(); j++) {
				Enemy e = (Enemy) enList.get(j);
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x };
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) };
				pol = new Polygon(xpoints, ypoints, 4);
				if (pol.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {// 적군과 미사일이 충돌했을때

					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					try {
						msList.remove(i);
					} catch (IndexOutOfBoundsException ie) {
					}
					score += 10;
					enList.remove(j);
				}
			}
		}
		for (int i = 0; i < msList.size(); i++) {
			Ms m = (Ms) msList.get(i);
			for (int j = 0; j < enList2.size(); j++) {
				Enemy e = (Enemy) enList2.get(j);
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x };
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) };
				pol = new Polygon(xpoints, ypoints, 4);
				if (pol.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {// 적군2의경우
					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					addParticle(e.x, e.y, true);
					addParticle(e.x, e.y, false);
					try {
						msList.remove(i);
					} catch (IndexOutOfBoundsException ie) {
					}
					enList2.remove(j);
					score += 20;
				}
			}
		}
		for (int i = 0; i < enList.size(); i++) {
			Enemy e = (Enemy) enList.get(i);
			int[] xpoints = { x, (x + xw), (x + xw), x };
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			pol = new Polygon(xpoints, ypoints, 4);
			if (pol.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {// 적군과 캐릭터가 충돌했을때
				life -= 1;
				enList.remove(i);
			} else if (life <= 0) {
				addParticle(x, y, true);
				addParticle(x, y, false);
				addParticle(x, y, true);
				addParticle(x, y, false);
				addParticle(x, y, true);
				addParticle(x, y, false);
				start = false;
				end = true;
			}
		}
		for (int i = 0; i < enList2.size(); i++) {
			Enemy e = (Enemy) enList2.get(i);
			int[] xpoints = { x, (x + xw), (x + xw), x };
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			pol = new Polygon(xpoints, ypoints, 4);
			if (pol.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {// 적군2의경우
				life -= 1;
				enList2.remove(i);
			} else if (life <= 0) {
				addParticle(x, y, true);
				addParticle(x, y, false);
				addParticle(x, y, true);
				addParticle(x, y, false);
				addParticle(x, y, true);
				addParticle(x, y, false);
				start = false;
				end = true;
			}
		}
		for (int i = 0; i < itemList.size(); i++) {
			ItemC it = (ItemC) itemList.get(i);
			int[] xpoints = { x, (x + xw), (x + xw), x };
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			pol = new Polygon(xpoints, ypoints, 4);
			if (pol.intersects((double) it.x, (double) it.y, (double) it.w, (double) it.h)) {// 아이템을 먹었을때
				dfire = true;
				itemList.remove(i);
				score += 15;
			}
		}
		for (int i = 0; i < itemList2.size(); i++) {
			ItemC it = (ItemC) itemList2.get(i);
			int[] xpoints = { x, (x + xw), (x + xw), x };
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			pol = new Polygon(xpoints, ypoints, 4);
			if (pol.intersects((double) it.x, (double) it.y, (double) it.w, (double) it.h)) {// 아이템을 먹었을때2
				mfire = true;
				itemList2.remove(i);
				score += 20;
			}
		}
	}

	public void addParticle(int x, int y, boolean bool) {
		int dx, dy;
		if (bool) {
			dx = (int) (Math.random() * 5);
			dy = (int) (Math.random() * 5);
		} else {
			dx = (int) (Math.random() * -5);
			dy = (int) (Math.random() * -5);
		}
		int size = (int) (Math.random() * 10);
		int life = (int) Math.random() * (100) + 90;
		Random r = new Random();
		int r1 = r.nextInt(255);
		int r2 = r.nextInt(255);
		int r3 = r.nextInt(255);

		particles.add(new Particle(x, y, dx, dy, size, life, new Color(r1, r2, r3)));
		// particles.add(new
		// Particle(x,y,dx,dy,size,life,Color.orange,Color.pink,Color.RED));
	}

	public void update() {
		for (int i = 0; i <= particles.size() - 1; i++) {
			if (particles.get(i).update())
				particles.remove(i);
		}
	}

	public void draw(){
  do{
    do{
    	gs = (Graphics) bufferstrat.getDrawGraphics();
           gs.setColor(Color.white);
           gs.drawImage(bmg,0, 0, w, h,this);//배경화면 그리기
           gs.drawString("게임시작 : Enter", 20, 50);
           gs.drawString("미사일 발사 : A", 20, 65);
           gs.drawImage(itmg,15,70,20,20,this);
           gs.drawString("미사일 세갈래", 37, 84);
           gs.drawImage(itmg2,15,90,20,20,this);
           gs.drawString("미사일 파워업", 37, 104);
           gs.drawString("BGM 끄기 : 숫자2번", 230, 65);
           gs.drawString("BGM 켜기 : 숫자1번", 230, 50);
           gs.setFont(ft);
           gs.drawString("SCORE : " + score, 240, 90);
           gs.drawString("LIFE : " + life, 240, 110);
           gs.setFont(ftd);
          
           gs.drawImage(img, x, y, xw, xh, this);//플레이어 캐릭터 그리기
              if(end) {
            	   gs.drawString("G A M E     O V E R", 130, 250);
            	   gs.drawString("SCORE : "+score, 145, 280);
            	   gs.drawString("재시작 : Enter", 145, 300);
            	   gs.drawString("메인화면 : M", 145, 320);
            	   img=null;
            	  }
            	  for(int i = 0; i < msList.size(); i++) {//미사일 그리기
            	   Ms m = (Ms)msList.get(i);
            	   if(mfire==false)gs.drawImage(mmg,m.x, m.y, m.w, m.h,this);
            	   if(mfire==true)gs.drawImage(mmg2,m.x, m.y, m.w, m.h,this);
            	   if(m.y < 0) msList.remove(i);
            	   m.moveMs();
            	  	}     
            	 
            	  for (int j = 0; j < enList2.size(); j++) {// 적군 그리기2
            		en2 = (Enemy) enList2.get(j);
            		gs.drawImage(emg2, en2.x, en2.y, en2.w, en2.h, this);
            		if (en2.y > h)enList2.remove(j);
            		en2.moveEn();
            			}
            	  
            	  for(int i = 0; i < enList.size(); i++) {//적군 그리기
            	   en = (Enemy)enList.get(i);
            	   gs.drawImage(emg, en.x, en.y, en.w, en.h, this);
            	   if(en.y > h) enList.remove(i);
            	   en.moveEn2();
            	  }
            	  
            	  for(int i = 0; i < itemList.size(); i++) {//아이템 그리기1
            		   ItemC it = (ItemC)itemList.get(i);
            		   gs.drawImage(itmg, it.x, it.y, it.w, it.h, this);
            		   if(it.y > h) itemList.remove(i);
            		   it.moveitem();
            		  }
            	  
            	  for(int i = 0; i < itemList2.size(); i++) {//아이템 그리기2
            		   ItemC it = (ItemC)itemList2.get(i);
            		   gs.drawImage(itmg2, it.x, it.y, it.w, it.h, this);
            		   if(it.y > h) itemList2.remove(i);
            		   it.moveitem();
            		  }
            	  //Graphics ge = this.getGraphics();
            	  //ge.drawImage(bi, 0, 0, w, h, this);
              renderParticles(gs);

           gs.dispose();
           }while(bufferstrat.contentsRestored());
            bufferstrat.show();
     }while(bufferstrat.contentsLost());
  }

	public void renderParticles(Graphics gs) {
		for (int i = 0; i <= particles.size() - 1; i++) {
			particles.get(i).render(gs);
		}
	}

	public void clearAll() { // 재시작시 모든값 초기화
		life = 3;
		score = 0;
		itemCnt = 0;
		itemCnt2 = 0;
		dfire = false;
		mfire = false;
		enspeed1 = 5;
		enspeed2 = 7;
		encnt = 9;
		encnt2 = 5;
		entcnt = 0;
		x = 160;
		y = 530;
	}

	public void keyControl() { // 키 입력시 움직이는값(pixel단위)
		if (0 < x) {
			if (left)
				x -= 4;
		}
		if (w > x + xw) {
			if (right)
				x += 4;
		}
		if (25 < y) {
			if (up)
				y -= 4;
		}
		if (h > y + xh) {
			if (down)
				y += 4;
		}
	}

	public void keyPressed(KeyEvent ke) { // 방향키와 a,엔터키를 입력받게함
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_A:
			fire = true;
			break;
		case KeyEvent.VK_1:
			try {
				clip.stop();
				clip.start();
				}catch(NullPointerException ne) {}
			break;
		case KeyEvent.VK_2:
			try {
				clip.stop();
				}catch(NullPointerException ne) {}
			break;
		case KeyEvent.VK_ENTER:
			if (life == 3) {
				p1 = new ImageIcon("imgs/shooting/P_1.png");
				img = p1.getImage();
			}
			if (life <= 0) {
				p1 = new ImageIcon("imgs/shooting/P_1.png");
				img = p1.getImage();
				clearAll();
			}
			start = true;
			end = false;
			break;
		case KeyEvent.VK_M:
			if (life <= 0) {
				removeAll();
				setVisible(false);
				new GameUI().setUI();
				try {
				clip.stop();
				}catch(NullPointerException ne) {}
			}
		}
	}

	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_A:
			fire = false;
			break;
		}
	}

	public void keyTyped(KeyEvent ke) {
	}
}
