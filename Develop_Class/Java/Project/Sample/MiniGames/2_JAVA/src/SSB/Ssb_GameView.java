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
   private Font font0 = new Font("impact", Font.PLAIN, 20);//��Ʈ �̸�, ��Ʈ ��Ÿ��, ��Ʈ ũ��
   private Font font1 = new Font("���� ���", Font.BOLD, 16);//��Ʈ �̸�, ��Ʈ ��Ÿ��, ��Ʈ ũ��
   private Font font2 = new Font("���� ���", Font.BOLD, 20);//��Ʈ �̸�, ��Ʈ ��Ÿ��, ��Ʈ ũ��
   private MyJPanel panel_Screen;
   private JPanel game_Screen, tpanel;
   private JLabel label[] = new JLabel[1000];
   private String NickName;
   private int tlevel;
   public static JLabel[] lifeMark = new JLabel[5]; /*
    * �Ǵٸ� JLabel �迭, life��
    * 3���̹Ƿ� 3�� ����
    */
   public static ImageIcon lifeIcon = new ImageIcon("imgs/ssb/heart.png");
   
   private int life = 5,  //������
         slevel,
         scorenum = 0,  //����
         spd = 3500,   //���ӽ��ǵ�
         chongsido = 0,   //�ѽõ�Ƚ��
         chongaserdd = 0, //�� ����� 
         sido = 0,        //������ �õ�Ƚ��
         answerscore = 0 ,  //������ ����Ƚ��
         i = 0;           //

   private JLabel score, level, Label_nickname;
   private JLabel lbTime, lbLv, lbScore, lbID, lbHP;
   TotalPlayTime total_play_time = new TotalPlayTime(); // �ð� Ÿ�̸� ������ Ŭ���� ����\
   Sonagi_Thead st;
   Sonagi_Move sm;
   Boolean music =true;


   public Ssb_GameView(String Nick, int lev) {
      super();
      NickName = Nick.trim();// �г��� ���� ����
      tlevel = lev; // ������ ���� ���� 
      slevel = lev;
      chongsido = 0;   //�ѽõ�Ƚ��
      chongaserdd = 0; //�� ����� 

      panel_Screen = new MyJPanel();// ����ȭ��
      add(panel_Screen, BorderLayout.CENTER);
      panel_Screen.setLayout(null);

      tpanel = new JPanel();// ����ȭ�� ���� ������ �����ִ� �г�
      tpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
      tpanel.setOpaque(false);
      tpanel.setLayout(null);
      panel_Screen.add(tpanel);
      tpanel.setVisible(false);   

      // ���� �󺧵�
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
      //���� �󺧵�
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

      //�� ��

      Label_nickname = new JLabel(Nick); //�г���
      //Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
      Label_nickname.setFont(font1);
      Label_nickname.setBounds(20+30, 20, 100, 30);
      Label_nickname.setForeground(new Color (255, 255, 255));
      tpanel.add(Label_nickname);      

      // �÷���Ÿ��
      total_play_time.playTime.setBounds(590+60, 20, 100, 35); //�ð������带 �����ؼ� �ð��� �ѷ���
      total_play_time.playTime.setForeground(new Color (255, 255, 255));
      total_play_time.playTime.setFont(font0);
      tpanel.add(total_play_time.playTime);
      total_play_time.playTime.setVisible(false); // Ÿ�̸��߰��ϰ�, �Ⱥ��̰� �Ѵ�

      level = new JLabel();// ����
      //score.setHorizontalAlignment(SwingConstants.CENTER); 
      level.setFont(font0); 
      level.setForeground(new Color (255, 255, 255));
      level.setBounds(590+60, 20+20+10, 100, 35);
      tpanel.add(level);

      score = new JLabel("0��");// ������
      //score.setHorizontalAlignment(SwingConstants.CENTER); 
      score.setFont(font0); 
      score.setBounds(590+60, 20+20+20+10+10, 200, 35);
      score.setForeground(new Color (255, 255, 255));
      tpanel.add(score);

      game_Screen = new JPanel();// ����ȭ�� �г�(�ܾ �������� �Է�â�� �ִ� �г�)
      game_Screen.setBounds(0, 30, this.getWidth(), this.getHeight()-30-10);
      game_Screen.setOpaque(false);
      game_Screen.setLayout(null);
      panel_Screen.add(game_Screen);
      game_Screen.setVisible(false);

      textField_1 = new JTextField();  //�Է�â 
      textField_1.setBounds(((game_Screen.getWidth()-200)/2), (game_Screen.getHeight()-35-50-2), 200, 35);
      textField_1.setBorder(new LineBorder(new Color(22, 103, 152),0, false)); // text field�� border
      game_Screen.add(textField_1);

      // ��ư,����Ʈ,Ű �̺�Ʈ������ �ؽ�Ʈ�ʵ���Ŀ�� ����
      textField_1.addKeyListener(this); // Ű �̺�Ʈ
      //list.addListSelectionListener(this); // ����Ʈ �̺�Ʈ
      textField_1.requestFocus(); // �ؽ�Ʈ ��Ŀ��

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
      life = 5;  //������
      scorenum = 0;  //����
      spd = 3500;   //���ӽ��ǵ�
      chongsido = 0;   //�ѽõ�Ƚ��
      chongaserdd = 0; //�� ����� 
      sido = 0;        //������ �õ�Ƚ��
      answerscore = 0;  //������ ����Ƚ��
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
      // �ܾ ������� �ִ��� Ȯ��
      if (label[0] != null) {
         for (int i = 0; i < label.length; i++) {
            // �����尡 ���ư��� ������ ����
//            if (!st.isAlive() || !sm.isAlive()) {
//               st.stop = true;// �ܾ� ������ ����
//               sm.stop = true;// �������� ������ ����
//               st.interrupt();
//               sm.interrupt();
//               System.out.println("3");
//            }
            // �ܾ ������� �ִٸ� �Ⱥ��̰�
            if (label[i] != null) {
               label[i].setVisible(false);
            }

         }
      }
      for (int i = 0; i < lifeMark.length; i++) {
         lifeMark[i].setIcon(lifeIcon);
         lifeMark[i].setOpaque(false);//�����ϰ�
         //lifeMark[i].setBounds(200 + (i * 80), 0, 100, 30);
         lifeMark[i].setBounds(((i * 30)+50), 20+15+20, 200, 30);
         tpanel.add(lifeMark[i]);
         lifeMark[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
         lifeMark[i].setVisible(true); // ������ �����ִ� JLabel�� ���� �߰��Ѵ�
      }
      // ���ӽ��۽� �ؽ�Ʈ�ʵ� ��Ŀ�� �ֱ�
      textField_1.requestFocus();
      // �ܾ �ѷ��ִ� ������ ����
      if(!(st.isAlive())) {
         st.start();
      }
      total_play_time.playTime.setVisible(true); // �ð�Ÿ�̸Ӹ� ���̰� ��
      try{
         if(!(total_play_time.isAlive()))
            total_play_time.start(); // �ð� Ÿ�̸� ������ ����
      }catch(Exception e){}
   }

   // �ܾ �Է��Ͽ� ���ϴܾ� �ִ��� Ȯ���ϴ� Ű�̺�Ʈ
   @Override
   public void keyPressed(KeyEvent e) {

      // ����Ű �̺�Ʈ
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
         // �ؽ�Ʈ �ʵ忡 ���� �ִ��� ������ Ȯ��
         if (!textField_1.getText().equals("")) {
            // String ������ �ؽ�Ʈ �� �ֱ�
            String work_answer = textField_1.getText().toString();
            sido++;
            chongsido++;   //�ѽõ�Ƚ��

            /*
             * �ؽ�Ʈ �Է°��� ������ �ܾ� �ִ��� �˻� ���� �ܾ� ������ �Ⱥ��̰� �ϰ� ���� 5�� �ֱ� ,�ؽ�Ʈ��
             * ����(�ܾ Ʋ������ )
             * 
             */
            String tmp="";
            for (int i = 0; i <= label.length; i++) { // ���� �ܾ� �˻� for
               try {
                  if (work_answer.equals(label[i].getText())) {// ���ϴܾ� �˻�

                     if (label[i].isVisible()) { // ���ϴܾ ȭ�鿡 ������ �ִ��� �˻�
                        scorenum = scorenum += 10; // ���� +10
                        if(!tmp.equals(work_answer)) {   //���ÿ� ������� ������� �ϳ��� �ö�
                           answerscore++;
                           chongaserdd++; //�� ����� 
                        }
                        score.setText(scorenum + ""); // ������ ���� ����
                        tmp = label[i].getText();
                        label[i].setVisible(false);// �ܾ� ȭ�鿡�� �Ⱥ��̰�
                        textField_1.setText("");// �ؽ�Ʈ �� ���ֱ�
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
               game_Screen.setVisible(false);// ����ȭ�� ����
               tpanel.setVisible(false);
               //total_play_time.suspend();

//               for (int i = 0; i < label.length; i++) {
//                  // �����尡 ���ư��� ������ ����
//                  if (!st.isAlive() || !sm.isAlive()) {
//                     st.stop = true;// �ܾ� ������ ����
//                     sm.stop = true;// �������� ������ ����
//                  }
//                  // �ܾ ������� �ִٸ� �Ⱥ��̰�
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

   // �ܾ �ϳ��� �ѷ��ִ� ������
   class Sonagi_Thead extends Thread {
      private boolean stop; // stop �÷���

      Sonagi_Thead(){
         this.stop = false;
      }

      public void run() {
         if(!stop) {
            game_Screen.setVisible(true);// ����ȭ�� ����
            tpanel.setVisible(true);
            // �ܾ �����̴� ������ ����
            if(!(sm.isAlive()))
               sm.start();
            setLevel();
            for (i = 0; i <= 1000; i++) {
               try {
                  Random random = new Random();// ���� ��ü ����
                  label[i] = new JLabel(work[random.nextInt(work.length)]);// �ܾ�
                  // ��������
                  label[i].setForeground(new Color (0,255,0)); // ��Ʈ �÷�
                  //label[i].setFont(font2);      // �������
                  label[i].setFont(font1);
                  label[i].setBounds(0, 0, 200, 20);// �ܾ� �ʱ� ��ġ ����,�� ����
                  game_Screen.add(label[i]);// �ܾ� �߰�
                  label[i].setLocation(random.nextInt(640), 3);// x�� �������� �����ֱ�
                  Thread.sleep(2000);// ���ӷ����� ���� �ܾ�ӵ�
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

   // �ܾ� ��������,���ӿ��� Ȯ���ϴ� ������
   class Sonagi_Move extends Thread {
      private boolean stop; // stop �÷���

      Sonagi_Move(){
         this.stop = false;
      }
      public void run() {
         while(!stop) {
            // �ܾ� ���� ���� ��ŭ for ���� �� �ܾ�� y�� ����
            for (int a = 0; a <= i; a++) {
               try{
                  if (label[a].isVisible()) {
                     int sp = label[a].getY();
                     int xp = label[a].getX();
                     label[a].setLocation(xp, sp + 15);//15�� �Ʒ���
                     
                     // �ܾ �������ִ� ���·� ���� �Ѿ����� Ȯ��
                     if (label[a].isVisible() && label[a].getY() > 350) {
                        label[a].setVisible(false);// �ܾ ���� ������ �ܾ� �����
                        remove(label[a]);
                        life--;   // ������ 1 = ���� 1������
                        Ssb_GameView.lifeMark[life].setIcon(null);
                        if(life==0&&stop==false) {
                           Thread.sleep(500);   // 0.5�� �� Dialog ��
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
    	  
         game_Screen.setVisible(false);// ����ȭ�� �����
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
         spd = 3500;// ���Ӽӵ�
         level.setText(""+(tlevel+1)); // ���� �󺧿� �����ֱ�
         break;
      case 1:
         spd = 2900;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 2:
         spd = 2600;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 3:
         spd = 2300;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 4:
         spd = 1900;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 5:
         spd = 1600;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 6:
         spd = 1300;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 7:
         spd = 1000;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 8:
         spd = 800;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      case 9:
         spd = 400;// ���Ӽӵ�
         level.setText(""+(tlevel+1));// ���� �󺧿� �����ֱ�
         break;
      default:
         break;
      }
   }
}