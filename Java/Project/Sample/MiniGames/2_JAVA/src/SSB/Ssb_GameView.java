package SSB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Main.GameUI;

//import Main.GameUI;

@SuppressWarnings("serial")
class Ssb_GameView extends Ssb_Gui implements KeyListener {
   private JTextField textField_1;
   private JButton btn_gamestart;
   private String [] work = new Ssb_word("wordlist\\words_K.txt").setWord();
   private Font font0 = new Font("impact", Font.PLAIN, 20);//폰트 이름, 폰트 스타일, 폰트 크기
   private Font font1 = new Font("맑은 고딕", Font.BOLD, 16);//폰트 이름, 폰트 스타일, 폰트 크기
   private Font font2 = new Font("맑은 고딕", Font.BOLD, 20);//폰트 이름, 폰트 스타일, 폰트 크기
   private MyJPanel panel_Screen;
   private JPanel game_Screen, tpanel;
   private JLabel label[] = new JLabel[1000];
   private String NickName;
   private int tlevel;
   public static JLabel[] lifeMark = new JLabel[5]; /*
    * 또다른 JLabel 배열, life가
    * 3개이므로 3개 생성
    */
   public static ImageIcon lifeIcon = new ImageIcon("imgs/ssb/heart.png");
   
   private int life = 5,  //생명갯수
         slevel,
         scorenum = 0,  //점수
         spd = 3500,   //게임스피드
         chongsido = 0,   //총시도횟수
         chongaserdd = 0, //총 정답수 
         sido = 0,        //레벨별 시도횟수
         answerscore = 0 ,  //레벨별 정답횟수
         i = 0;           //

   private JLabel score, level, Label_nickname;
   private JLabel lbTime, lbLv, lbScore, lbID, lbHP;
   TotalPlayTime total_play_time = new TotalPlayTime(); // 시간 타이머 쓰레드 클래스 생성\
   Sonagi_Thead st;
   Sonagi_Move sm;
   Boolean music =true;


   public Ssb_GameView(String Nick, int lev) {
      super();
      NickName = Nick.trim();// 닉네임 변수 저장
      tlevel = lev; // 변수에 레벨 저장 
      slevel = lev;
      chongsido = 0;   //총시도횟수
      chongaserdd = 0; //총 정답수 

      panel_Screen = new MyJPanel();// 게임화면
      add(panel_Screen, BorderLayout.CENTER);
      panel_Screen.setLayout(null);

      tpanel = new JPanel();// 게임화면 위에 정보를 보여주는 패널
      tpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
      tpanel.setOpaque(false);
      tpanel.setLayout(null);
      panel_Screen.add(tpanel);
      tpanel.setVisible(false);   

      // 우측 라벨들
      lbTime = new JLabel("TIME ");
      lbLv = new JLabel("Lv. ");
      lbScore = new JLabel("Score ");
      lbTime.setBounds(590, 20, 50, 35);
      lbLv.setBounds(590, 20+20+10, 50, 35);
      lbScore.setBounds(590, 20+20+20+10+10, 100, 35);
      lbTime.setForeground(new Color (255, 255, 255));
      lbLv.setForeground(new Color (255, 255, 255));
      lbScore.setForeground(new Color (255, 255, 255));
      lbTime.setFont(font0); 
      lbLv.setFont(font0); 
      lbScore.setFont(font0); 
      tpanel.add(lbTime);
      tpanel.add(lbLv);
      tpanel.add(lbScore);
      //좌측 라벨들
      lbID = new JLabel("ID. ");
      lbHP = new JLabel("HP. ");
      lbID.setBounds(20, 20, 30, 30);
      lbHP.setBounds(20, 20+15+20, 30, 30);
      lbID.setForeground(new Color (255, 255, 255));
      lbHP.setForeground(new Color (255, 255, 255));
      lbID.setFont(font0); 
      lbHP.setFont(font0);  
      tpanel.add(lbID);
      tpanel.add(lbHP);

      //라벨 값

      Label_nickname = new JLabel(Nick); //닉네임
      //Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
      Label_nickname.setFont(font1);
      Label_nickname.setBounds(20+30, 20, 100, 30);
      Label_nickname.setForeground(new Color (255, 255, 255));
      tpanel.add(Label_nickname);      

      // 플레이타임
      total_play_time.playTime.setBounds(590+60, 20, 100, 35); //시간스레드를 설정해서 시간을 뿌려줌
      total_play_time.playTime.setForeground(new Color (255, 255, 255));
      total_play_time.playTime.setFont(font0);
      tpanel.add(total_play_time.playTime);
      total_play_time.playTime.setVisible(false); // 타이머추가하고, 안보이게 한다

      level = new JLabel();// 레벨
      //score.setHorizontalAlignment(SwingConstants.CENTER); 
      level.setFont(font0); 
      level.setForeground(new Color (255, 255, 255));
      level.setBounds(590+60, 20+20+10, 100, 35);
      tpanel.add(level);

      score = new JLabel("0점");// 점수판
      //score.setHorizontalAlignment(SwingConstants.CENTER); 
      score.setFont(font0); 
      score.setBounds(590+60, 20+20+20+10+10, 200, 35);
      score.setForeground(new Color (255, 255, 255));
      tpanel.add(score);

      game_Screen = new JPanel();// 게임화면 패널(단어가 내려오고 입력창이 있는 패널)
      game_Screen.setBounds(0, 30, this.getWidth(), this.getHeight()-30-10);
      game_Screen.setOpaque(false);
      game_Screen.setLayout(null);
      panel_Screen.add(game_Screen);
      game_Screen.setVisible(false);

      textField_1 = new JTextField();  //입력창 
      textField_1.setBounds(((game_Screen.getWidth()-200)/2), (game_Screen.getHeight()-35-50-2), 200, 35);
      textField_1.setBorder(new LineBorder(new Color(22, 103, 152),0, false)); // text field의 border
      game_Screen.add(textField_1);

      // 버튼,리스트,키 이벤트설정및 텍스트필드포커스 설정
      textField_1.addKeyListener(this); // 키 이벤트
      //list.addListSelectionListener(this); // 리스트 이벤트
      textField_1.requestFocus(); // 텍스트 포커스

      scorenum = 0;
      score.setText(scorenum+"");
      for (int i = 0; i < lifeMark.length; i++) {
         lifeMark[i] = new JLabel();
      }
      setting();
      init();
      super.setVisible(true);
   }
   void setting() {
      life = 5;  //생명갯수
      scorenum = 0;  //점수
      spd = 3500;   //게임스피드
      chongsido = 0;   //총시도횟수
      chongaserdd = 0; //총 정답수 
      sido = 0;        //레벨별 시도횟수
      answerscore = 0;  //레벨별 정답횟수
      i = 0;   
      sido = 0;
      Timer time = new Timer();
		TimerTask t = new TimerTask(){
			public void run(){
				music = true;
				mplay("imgs/ssb/SSHG.wav");
			}
		};
		time.schedule(t, 0);
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



   private void init() {
      st = new Sonagi_Thead();
      sm = new Sonagi_Move();
      // 단어가 만들어져 있는지 확인
      if (label[0] != null) {
         for (int i = 0; i < label.length; i++) {
            // 쓰레드가 돌아가고 있으면 중지
//            if (!st.isAlive() || !sm.isAlive()) {
//               st.stop = true;// 단어 쓰레드 중지
//               sm.stop = true;// 내려가는 쓰레드 중지
//               st.interrupt();
//               sm.interrupt();
//               System.out.println("3");
//            }
            // 단어가 만들어져 있다면 안보이게
            if (label[i] != null) {
               label[i].setVisible(false);
            }

         }
      }
      for (int i = 0; i < lifeMark.length; i++) {
         lifeMark[i].setIcon(lifeIcon);
         lifeMark[i].setOpaque(false);//투명하게
         //lifeMark[i].setBounds(200 + (i * 80), 0, 100, 30);
         lifeMark[i].setBounds(((i * 30)+50), 20+15+20, 200, 30);
         tpanel.add(lifeMark[i]);
         lifeMark[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
         lifeMark[i].setVisible(true); // 생명을 보여주는 JLabel을 만들어서 추가한다
      }
      // 게임시작시 텍스트필드 포커스 주기
      textField_1.requestFocus();
      // 단어를 뿌려주는 쓰레드 실행
      if(!(st.isAlive())) {
         st.start();
      }
      total_play_time.playTime.setVisible(true); // 시간타이머를 보이게 함
      try{
         if(!(total_play_time.isAlive()))
            total_play_time.start(); // 시간 타이머 쓰레드 시작
      }catch(Exception e){}
   }

   // 단어를 입력하여 동일단어 있는지 확인하는 키이벤트
   @Override
   public void keyPressed(KeyEvent e) {

      // 엔터키 이벤트
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
         // 텍스트 필드에 값이 있는지 없는지 확인
         if (!textField_1.getText().equals("")) {
            // String 변수에 텍스트 값 주기
            String work_answer = textField_1.getText().toString();
            sido++;
            chongsido++;   //총시도횟수

            /*
             * 텍스트 입력값과 동일한 단어 있는지 검사 동일 단어 있을시 안보이게 하고 점수 5점 주기 ,텍스트값
             * 삭제(단어가 틀리더라도 )
             * 
             */
            String tmp="";
            for (int i = 0; i <= label.length; i++) { // 동일 단어 검사 for
               try {
                  if (work_answer.equals(label[i].getText())) {// 동일단어 검사

                     if (label[i].isVisible()) { // 동일단어가 화면에 보여져 있는지 검사
                        scorenum = scorenum += 10; // 점수 +10
                        if(!tmp.equals(work_answer)) {   //동시에 사라져도 정답수는 하나만 올라감
                           answerscore++;
                           chongaserdd++; //총 정답수 
                        }
                        score.setText(scorenum + ""); // 점수판 점수 변경
                        tmp = label[i].getText();
                        label[i].setVisible(false);// 단어 화면에서 안보이게
                        textField_1.setText("");// 텍스트 값 없애기
                     }
                  } else {
                     textField_1.setText("");
                  }
               } catch (Exception e2) {
                  //System.out.println("....");
               }

            }
            if(answerscore == 10) {
               tlevel++;
               game_Screen.setVisible(false);// 게임화면 등장
               tpanel.setVisible(false);
               //total_play_time.suspend();

//               for (int i = 0; i < label.length; i++) {
//                  // 쓰레드가 돌아가고 있으면 중지
//                  if (!st.isAlive() || !sm.isAlive()) {
//                     st.stop = true;// 단어 쓰레드 중지
//                     sm.stop = true;// 내려가는 쓰레드 중지
//                  }
//                  // 단어가 만들어져 있다면 안보이게
//                  if (label[i] != null) {
//                     label[i].setVisible(false);
//                  }
//               }
               //panel_over.setVisible(true);
               sm.stop = true;
               st.stop = true;
               double tt = (double) answerscore / (double) sido * 100.0;
               //               JOptionPane.showMessageDialog(panel_Screen, 
               //                  "Level Up !! \nGo to the next Stage.\n"+ NickName+"'s Accuracy is "+(int)tt+"%", 
               //                  "Level Up !",
               //                  JOptionPane.INFORMATION_MESSAGE);

               ImageIcon levelup = new ImageIcon("imgs/ssb/levelup.png");
               JOptionPane.showMessageDialog(panel_Screen, 
                     "Level Up !! \nGo to the next Stage.\n"+ NickName+"'s Accuracy is "+(int)tt+"%", 
                     "Level Up !",
                     JOptionPane.INFORMATION_MESSAGE,levelup);
               answerscore = 0;
               sido = 0;

               init();
            }
         }
      }
   }
   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}

   // 단어를 하나씩 뿌려주는 쓰레드
   class Sonagi_Thead extends Thread {
      private boolean stop; // stop 플래그

      Sonagi_Thead(){
         this.stop = false;
      }

      public void run() {
         if(!stop) {
            game_Screen.setVisible(true);// 게임화면 등장
            tpanel.setVisible(true);
            // 단어를 움직이는 쓰레드 실행
            if(!(sm.isAlive()))
               sm.start();
            setLevel();
            for (i = 0; i <= 1000; i++) {
               try {
                  Random random = new Random();// 랜덤 객체 생성
                  label[i] = new JLabel(work[random.nextInt(work.length)]);// 단어
                  // 랜덤으로
                  label[i].setForeground(new Color (0,255,0)); // 폰트 컬러
                  //label[i].setFont(font2);      // 가지고옴
                  label[i].setFont(font1);
                  label[i].setBounds(0, 0, 200, 20);// 단어 초기 위치 높이,폭 설정
                  game_Screen.add(label[i]);// 단어 추가
                  label[i].setLocation(random.nextInt(640), 3);// x값 랜덤으로 보여주기
                  Thread.sleep(2000);// 게임레벨에 따른 단어속도
               } catch (InterruptedException e) {
                  e.getStackTrace();
               }  catch (Exception e2) {
                  e2.getStackTrace();
               }
            }
         }
      }
      public void threadStop(boolean stop){
         this.stop = stop;
      }
   }

   // 단어 내려가고,게임오버 확인하는 쓰레드
   class Sonagi_Move extends Thread {
      private boolean stop; // stop 플래그

      Sonagi_Move(){
         this.stop = false;
      }
      public void run() {
         while(!stop) {
            // 단어 생성 갯수 만큼 for 돌려 각 단어마다 y값 변경
            for (int a = 0; a <= i; a++) {
               try{
                  if (label[a].isVisible()) {
                     int sp = label[a].getY();
                     int xp = label[a].getX();
                     label[a].setLocation(xp, sp + 15);//15씩 아래로
                     
                     // 단어가 보여져있는 상태롤 선을 넘었는지 확인
                     if (label[a].isVisible() && label[a].getY() > 350) {
                        label[a].setVisible(false);// 단어가 선을 넘으면 단어 사라짐
                        remove(label[a]);
                        life--;   // 라이프 1 = 생명 1없어짐
                        Ssb_GameView.lifeMark[life].setIcon(null);
                        if(life==0&&stop==false) {
                           Thread.sleep(500);   // 0.5초 뒤 Dialog 출
                           gameOver();
                        }
                     }
                  }
               }catch(Exception e){
                  e.getStackTrace();
               }
            }
            try {
               Thread.sleep(spd);
            }catch(Exception e) {}
         }
      }

      public void threadStop(boolean stop){
         this.stop = stop;
      }
      void gameOver() {
    	  
         game_Screen.setVisible(false);// 게임화면 사라짐
         tpanel.setVisible(false);
         String test = total_play_time.playTime.getText();

         double tt = (double) chongaserdd / (double) chongsido * 100.0;

         ImageIcon gameover = new ImageIcon("img/gameover.png");
         /*int reply = JOptionPane.showConfirmDialog(panel_Screen,"Game Over\n"+
                   NickName+"'s Level : "+(tlevel+1)+"\nPlay time : "+
                   test.split(":")[0]+":"+test.split(":")[1]+"\n"
                   +"Accuracy : "+(int)tt+"%"
                  +"\nReplay?", "Oh, Game Over", JOptionPane.YES_NO_OPTION,-1);*/
         int reply = JOptionPane.showConfirmDialog(panel_Screen,
               "Game Over\n"+NickName+"'s Level : "+(tlevel+1)+"\nPlay time : "+
                     test.split(":")[0]+":"+test.split(":")[1]+"\n"
                     +"Accuracy : "+(int)tt+"%"   +"\nReplay?",
                     "Oh, Game Over", JOptionPane.YES_NO_OPTION);// , JOptionPane.INFORMATION_MESSAGE, gameover//JOptionPane.QUESTION_MESSAGE, gameover
         st.stop=true;
         sm.stop=true;
         if (reply == JOptionPane.YES_OPTION) { 
        	music = false; 
            removeAll();
            dispose();
            new Ssb_GameView(NickName, slevel);
         }
         else {
        	music = false;
            removeAll();
            setVisible(false);
            new GameUI().setUI();
         }
      }
   }


   public void setLevel() {
      switch(tlevel) {
      case 0:
         spd = 3500;// 게임속도
         level.setText(""+(tlevel+1)); // 레벨 라벨에 보여주기
         break;
      case 1:
         spd = 2900;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 2:
         spd = 2600;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 3:
         spd = 2300;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 4:
         spd = 1900;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 5:
         spd = 1600;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 6:
         spd = 1300;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 7:
         spd = 1000;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 8:
         spd = 800;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      case 9:
         spd = 400;// 게임속도
         level.setText(""+(tlevel+1));// 레벨 라벨에 보여주기
         break;
      default:
         break;
      }
   }
}