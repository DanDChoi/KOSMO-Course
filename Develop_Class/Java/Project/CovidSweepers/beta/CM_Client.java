import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CM_Client extends JFrame implements ActionListener
{
   JPanel CONTENT, panel_Main, panel_Chat, panel_Top, panel_Option;
   JButton btn_Ready, btn_Exit, btn_GG, btn_BGM;//bgm까지 사용
   JLabel  label_logo_CENTER, label_Timer, laClient1, laClient2, laClient3, laClient4 ,  // 메인로고 타이머 케릭터사진
      label_Flag1 , label_Flag2, label_Flag3, label_Flag4,label_leftover;  //주사기, 잔여
   Label laClient1sub, laClient2sub, laClient3sub, laClient4sub , // 케릭터 밑에 닉네임
      label_Flag1_syringe1 ,label_Flag1_syringe2 ,label_Flag1_syringe3 ,label_Flag1_syringe4 ,label_Announce; //주사기맞춘갯수. ~차레입니다
   JTextField textField;
   JTextArea textArea, announceArea;
   JScrollPane scrollPane, announceScroll;

   //문제 탑로고
   
   int port = 7777;
   String playerName, playerScore, playerIdx; // 클라이언트 이름, 점수, 인덱스 관리
   boolean gameStart, auth; // 게임 시작 상태 체크 & 출제자 권한 변수
   
   public CM_Client(){
      // 기본 GUI 설정
      setFont(new Font("나눔바른고딕", Font.PLAIN, 13)); 
      setVisible(true);
      setResizable(false);
      setTitle("JAVA CatchMind Client"); //파일이름
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1280, 720);
      setLocationRelativeTo(null);  // 이거 실행시키면 정가운데에서 켜짐
      
      // 베이스 패널
      CONTENT = new JPanel();
      CONTENT.setBorder(null);
      setContentPane(CONTENT);
      CONTENT.setLayout(new BoxLayout(CONTENT, BoxLayout.X_AXIS));  // axis는 정렬방법 좌>>우로 배치
      
      panel_Main = new JPanel();
      panel_Main.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
      panel_Main.setBackground(new Color(255, 255, 255));
      CONTENT.add(panel_Main);
      panel_Main.setLayout(null);
      
      // 참여자 목록 영역
      JPanel panelCList = new JPanel();
      JLabel label_ClientList = new JLabel(new ImageIcon("image\\user.png"));
     JLabel label_ClientList1 = new JLabel(new ImageIcon("image\\user.png"));

      panelCList.setOpaque(false);
      label_ClientList.setOpaque(false);
     label_ClientList1.setOpaque(false);
      panelCList.setBorder(new LineBorder(new Color(255, 164, 38 ), 2, true)); //setborder 직선보더,컬러굵기
      panelCList.setBounds(10, 105, 300, 500);
      label_ClientList.setBounds(-65, 105, 312, 500);
     label_ClientList1.setBounds(75, 105, 312, 500);
      panel_Main.add(panelCList);
      panel_Main.add(label_ClientList);
     panel_Main.add(label_ClientList1);
      panelCList.setLayout(null);
   
     // 주사기그림 영역  
     label_Flag1 = new JLabel(new ImageIcon("image\\RS.jpg"));
      label_Flag1.setBackground(Color.GRAY);
      label_Flag1.setBounds(160, 15, 120, 80);
      panelCList.add(label_Flag1);

     label_Flag2 = new JLabel(new ImageIcon("image\\PS.jpg"));
      label_Flag2.setBackground(Color.GRAY);
      label_Flag2.setBounds(160, 135, 120, 80);
      panelCList.add(label_Flag2);

     label_Flag3 = new JLabel(new ImageIcon("image\\BS.jpg"));
      label_Flag3.setBackground(Color.GRAY);
      label_Flag3.setBounds(160, 250, 120, 80);
      panelCList.add(label_Flag3);

      label_Flag4 = new JLabel(new ImageIcon("image\\YS.jpg"));
      label_Flag4.setBackground(Color.GRAY);
      label_Flag4.setBounds(160, 375, 120, 80);
      panelCList.add(label_Flag4);
     

     //맞춘갯수 영역 (주사기 그림 아래 위치)
     label_Flag1_syringe1 = new Label("[ 맞춘갯수 ]");
      label_Flag1_syringe1.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      label_Flag1_syringe1.setAlignment(Label.CENTER);
      label_Flag1_syringe1.setBackground(Color.WHITE);
      label_Flag1_syringe1.setBounds(160, 95, 120, 30);
      panelCList.add(label_Flag1_syringe1);
     
     label_Flag1_syringe2 = new Label("[ 맞춘갯수 ]");
      label_Flag1_syringe2.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      label_Flag1_syringe2.setAlignment(Label.CENTER);
      label_Flag1_syringe2.setBackground(Color.WHITE);
      label_Flag1_syringe2.setBounds(160, 215, 120, 30);
      panelCList.add(label_Flag1_syringe2);
      
     label_Flag1_syringe3 = new Label("[ 맞춘갯수 ]");
      label_Flag1_syringe3.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      label_Flag1_syringe3.setAlignment(Label.CENTER);
      label_Flag1_syringe3.setBackground(Color.WHITE);
      label_Flag1_syringe3.setBounds(160, 335, 120, 30);
      panelCList.add(label_Flag1_syringe3);
      
     label_Flag1_syringe4 = new Label("[ 맞춘갯수 ]");
      label_Flag1_syringe4.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      label_Flag1_syringe4.setAlignment(Label.CENTER);
      label_Flag1_syringe4.setBackground(Color.WHITE);
      label_Flag1_syringe4.setBounds(160, 455, 120, 30);
      panelCList.add(label_Flag1_syringe4);



      // 참여자 영역
      laClient1 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient1.setBackground(Color.GRAY);
      laClient1.setBounds(21, 15, 120, 80);
      panelCList.add(laClient1);
      
      laClient1sub = new Label("[ 닉네임 ]");
      laClient1sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      laClient1sub.setAlignment(Label.CENTER);
      laClient1sub.setBackground(Color.WHITE);
      laClient1sub.setBounds(18, 95, 120, 30);
      panelCList.add(laClient1sub);
      
      laClient2 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient2.setBackground(Color.GRAY);
      laClient2.setBounds(21, 135, 120, 80);
      panelCList.add(laClient2);
      
      laClient2sub = new Label("[ 닉네임 ]");
      laClient2sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      laClient2sub.setAlignment(Label.CENTER);
      laClient2sub.setBackground(Color.WHITE);
      laClient2sub.setBounds(18, 215, 120, 30);
      panelCList.add(laClient2sub);
      
      laClient3 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient3.setBackground(Color.GRAY);
      laClient3.setBounds(21, 255, 120, 80);
      panelCList.add(laClient3);
      
      laClient3sub = new Label("[ 닉네임 ]");
      laClient3sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      laClient3sub.setAlignment(Label.CENTER);
      laClient3sub.setBackground(Color.WHITE);
      laClient3sub.setBounds(18, 335, 120, 30);
      panelCList.add(laClient3sub);
      
      laClient4 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient4.setBackground(Color.GRAY);
      laClient4.setBounds(21, 375, 120, 80);
      panelCList.add(laClient4);
      
      laClient4sub = new Label("[ 닉네임 ]");
      laClient4sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
      laClient4sub.setAlignment(Label.CENTER);
      laClient4sub.setBackground(Color.WHITE);
      laClient4sub.setBounds(18, 455, 120, 30);
      panelCList.add(laClient4sub);
      
      // covid sweeper
      panel_Top = new JPanel();
      panel_Top.setBounds(10, 10, 1245, 85);
      panel_Main.add(panel_Top);
      panel_Top.setLayout(null);
      
      JLabel Top_Background = new JLabel(new ImageIcon("image\\topbg.png")); // top Background
      Top_Background.setOpaque(true);// 배경색 설정
      Top_Background.setBounds(0, 0, 1245, 85);
      panel_Top.add(Top_Background);
      panel_Top.setLayout(null);
      
      label_logo_CENTER = new JLabel(new ImageIcon("image\\toplogo.png")); //  logo covid sweepers
      label_logo_CENTER.setOpaque(false);
      label_logo_CENTER.setBounds(315, 10, 700, 85);
      Top_Background.add(label_logo_CENTER);

      /*
      label_Exam_Sub = new JLabel();
      label_Exam_Sub.setOpaque(false); //투명하게
      label_Exam_Sub.setBounds(450, 0, 403, 65);
      label_Exam_Sub.setFont(new Font("나눔바른고딕", Font.PLAIN, 24));
      label_Exam_Sub.setForeground(Color.BLACK);
      label_Exam_Sub.setHorizontalAlignment(SwingConstants.CENTER);
      label_Exam.add(label_Exam_Sub);
      */
      
      // 우상단 버튼 영역
      
      btn_Ready = new JButton(new ImageIcon("image\\ready1.png"));
     btn_Ready.setPressedIcon(new ImageIcon("image\\readyd.png"));
      btn_Ready.setFocusPainted(false);
      btn_Ready.setBorderPainted(false);
      btn_Ready.setContentAreaFilled(false);
      btn_Ready.setBounds(991, 11, 115, 65);
      Top_Background.add(btn_Ready);
      
      btn_Exit = new JButton(new ImageIcon("image\\close1.png"));
      btn_Exit.setPressedIcon(new ImageIcon("image\\closed.png"));
      btn_Exit.setFocusPainted(false);
      btn_Exit.setBorderPainted(false);
      btn_Exit.setContentAreaFilled(false);
      btn_Exit.setBounds(1118, 11, 115, 65);
      Top_Background.add(btn_Exit);
      btn_Exit.addActionListener(this); // aaddActionListener(this) 있어야지 버튼 누르면 실행됨
      
      // 로고 영역
      JLabel label_logo_left = new JLabel(new ImageIcon("image\\leftover.png"));
      label_logo_left.setOpaque(false);
      label_logo_left.setBorder(null);
      label_logo_left.setBounds(70, 10, 142, 65);
      label_leftover = new JLabel("N");
      label_leftover.setHorizontalTextPosition(SwingConstants.CENTER);
      label_leftover.setHorizontalAlignment(SwingConstants.CENTER);
      label_leftover.setFont(new Font("나눔바른고딕", Font.PLAIN, 30));
      label_leftover.setForeground(Color.BLACK);
      label_leftover.setBounds(70, 10, 142, 65);
      Top_Background.add(label_leftover);
      Top_Background.add(label_logo_left);


      
      // 채팅 영역
      panel_Chat = new JPanel();
      panel_Chat.setBounds(992, 105, 263, 567);
      panel_Main.add(panel_Chat);
      panel_Chat.setLayout(null);
      
      scrollPane = new JScrollPane(textArea);
      scrollPane.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(0, 0, 263, 535);
      panel_Chat.add(scrollPane);
      
      textArea = new JTextArea();
      textArea.setBorder(new LineBorder(new Color(255, 164, 38), 2, true));
      textArea.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      scrollPane.setViewportView(textArea);
      textArea.setBackground(Color.WHITE);
      
      textField = new JTextField();
      textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
      textField.setBackground(Color.WHITE);
      textField.setBounds(0, 537, 263, 30);
      panel_Chat.add(textField);
      textField.setColumns(10);


     /*panel_Mine = new JPanel();
     panel_Mine.setOpaque(false);
     panel_Option.setBackground(Color.black);
     Mine.setBounds(177, 105, 600, 600);
     panel_Main.add(panel_Mine);
     panel_Mine.setLayout(new BorderLayout(0,0));

        JPanel panel_MineBack = new JPanel();
        label_MineBack = new JLabel(new ImageIcon("image\\2.jpg"));
      label_MineBack.setBackground(Color.white);
      label_MineBack.setBounds(177, 105, 600, 600);
      panel_MineBack.add(label_MineBack);

   
      // 캔버스 영역 >> 지뢰영역

      JLabel labell_Canvas_Top = new JLabel(new ImageIcon("image\\canvas.png"));
      labell_Canvas_Top.setBounds(176, 105, 802, 34);
      labell_Canvas_Top.setOpaque(true);
      panel_Main.add(labell_Canvas_Top);
      
      panel_Canvas = new JPanel();
      panel_Canvas.setOpaque(false);
      panel_Canvas.setBounds(177, 105, 800, 500);
      panel_Main.add(panel_Canvas);
      panel_Canvas.setLayout(new BorderLayout(0, 0));

      canvas = new Brush();
      canvas.setBackground(Color.WHITE);
      panel_Canvas.add(canvas, BorderLayout.CENTER);
      CanvasHandler ch = new CanvasHandler(); // 캔버스 핸들러
      canvas.addMouseMotionListener(ch);
      */



      //하단영역
      panel_Option = new JPanel();
      panel_Option.setOpaque(true);
      panel_Option.setBackground(Color.BLACK);
      panel_Option.setBounds(7, 615, 305  , 57);
      panel_Main.add(panel_Option);
      panel_Option.setLayout(null);

      JLabel label_Timer_Back = new JLabel(new ImageIcon("image\\time.png"));
      label_Timer_Back.setOpaque(true);
      label_Timer = new JLabel("00 : 30");
      label_Timer.setHorizontalTextPosition(SwingConstants.CENTER);
      label_Timer.setHorizontalAlignment(SwingConstants.CENTER);
      label_Timer.setFont(new Font("나눔바른고딕", Font.PLAIN, 24));
      label_Timer.setForeground(Color.black);
      label_Timer_Back.setBounds(0, 0, 158, 57);
      label_Timer.setBounds(0, 10, 158, 57);
      panel_Option.add(label_Timer_Back);
      label_Timer_Back.add(label_Timer);

      btn_BGM = new JButton(new ImageIcon("image\\bgmOff.png"));
      btn_BGM.setPressedIcon(new ImageIcon("image\\bgmOn.png"));
      btn_BGM.setFocusPainted(false);
      btn_BGM.setBorderPainted(false);
      btn_BGM.setContentAreaFilled(false);
      btn_BGM.setBounds(155, 0, 152, 57);
      panel_Option.add(btn_BGM);
      
/*
      announceScroll = new JScrollPane(announceArea);
      announceScroll.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
      announceScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      announceScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      announceScroll.setBounds(325, 0, 638, 57);
      announceScroll.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
      panel_Option.add(announceScroll);

      announceArea = new JTextArea("SystemMsg 출력창");
      announceArea.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
      announceArea.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
      announceArea.setForeground(Color.BLACK);
      announceArea.setEditable(false);
      announceArea.setLineWrap(true);
      announceArea.setBackground(new Color(255, 215, 161));
      announceScroll.setViewportView(announceArea);
    */

/*
      textArea1 = new JTextArea();
      textArea1.setBorder(new LineBorder(new Color(255, 164, 38), 2, true));
      textArea1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
     textArea1.setBounds(325,0,638,57);
      textArea1.setEditable(false);
      textArea1.setLineWrap(true);
      textArea1.setBackground(Color.WHITE);
     panel_Option.add(textArea1);
      /*
      label_Announce = new Label("[  [닉네임] 님 차례입니다. ]");
      label_Announce.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
      label_Announce.setAlignment(Label.CENTER);
      label_Announce.setBackground(Color.WHITE);
      label_Announce.setBounds(220, 0, 900, 57);
      panel_Option.add(label_Announce);
      */

      startChat();
   }
   
    
   
   
   
   public void startChat(){
      String nickName = CM_Login.nickName;
      String ip = CM_Login.ip;

      try{
         Socket s = new Socket(ip, port);
         Sender sender = new Sender(s, nickName);
         Listener listener = new Listener(s);
         new Thread(sender).start();
         new Thread(listener).start();
         
         //이벤트 추가 
         textField.addKeyListener(new Sender(s, nickName));
         btn_Ready.addActionListener(new Sender(s, nickName));

      }catch(UnknownHostException uh){
         JOptionPane.showMessageDialog(null, "호스트를 찾을 수 없습니다!", "ERROR", JOptionPane.WARNING_MESSAGE);
      }catch(IOException io){
         JOptionPane.showMessageDialog(null, "서버 접속 실패!\n서버가 닫혀 있는 것 같습니다.", "ERROR", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }
   }

   // 종료 버튼 액션 이벤트 처리
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btn_Exit){
         int select = JOptionPane.showConfirmDialog(null, "정말 게임을 종료하시겠습니까?", "Exit", JOptionPane.OK_CANCEL_OPTION);
         if(select == JOptionPane.YES_OPTION) System.exit(0);
      }
   }


   // 내부 클래스 송신
   class Sender extends Thread implements KeyListener, ActionListener
   {
      DataOutputStream dos;
      Socket s;
      String nickName;

      Sender(Socket s, String nickName){
         this.s = s;
         try{
            dos = new DataOutputStream(this.s.getOutputStream());
            this.nickName = nickName;
         }catch(IOException io){}
      }

      public void run(){
         try{
            dos.writeUTF(nickName);
         }catch(IOException io){}
      }
      //종료 
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn_Ready){ // '준비' 버튼
            try{
               dos.writeUTF("//Chat " + "[ " + nickName + " 님 준비 완료 ! ]");
               dos.flush();
               dos.writeUTF("//Ready");
               dos.flush();
               btn_Ready.setEnabled(false);
            }catch(IOException io){}
         }
      }

      public void keyReleased(KeyEvent e){ // 채팅 입력
         if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String chat = textField.getText();
            textField.setText("");
            try{
               dos.writeUTF("//Chat " + nickName + " : " + chat);
               dos.flush();
            }catch(IOException io){}
         }
      }
      public void keyTyped(KeyEvent e){}
      public void keyPressed(KeyEvent e){}
   }
   // 내부 클래스 - 수신

   class Listener extends Thread // 
   {
      Socket s;
      DataInputStream dis, disS;

      Listener(Socket s){
         this.s = s;
         try{
            dis = new DataInputStream(this.s.getInputStream());
            //disS = new DataInputStream(this.s.getInputStream());
         }catch(IOException io){}
      }
      public void run(){
         while(dis !=null ){
            try{
               String msg = dis.readUTF();
              //String msgS = disS.readUTF();

               if(msg.startsWith("//CList")){ // 명령어 : 클라이언트 목록 갱신
                  playerName = msg.substring(7, msg.indexOf(" "));
                  playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                  playerIdx = msg.substring(msg.indexOf("#") + 1);
                  updateClientList(); // 클라이언트 목록 갱신
               }else if(msg.startsWith("//Start")){ // 명령어 : 게임 시작 ( + 타이머)
                  gameStart = true;
                  //bgm("//Play"); // BGM 재생
                  }else if(msg.equals("//GmGG ")){ // 명령어 : 출제자 게임 포기
                  gameStart = false;
                  auth = false;
                  textField.setEnabled(true);
                  btn_Ready.setEnabled(true);
                  //bgm("//Stop"); // BGM 정지
               }else if(msg.equals("//GmEnd")){ // 명령어 : 게임 종료
                  gameStart = false;
                  auth = false;
                  textField.setEnabled(true);
                  btn_Ready.setEnabled(true);
                  label_Timer.setText("00 : 00");
         //         bgm("//Stop"); // BGM 정지
               }else if(msg.startsWith("//Auth ")){ // 명령어 : 출제자 권한 부여
                  if(CM_Login.nickName.equals(msg.substring(7))){
                     auth = true;
                     announceArea.append("\n[ 당신이 문제 출제자입니다 !! ]" + "\n\n");
                     textField.setEnabled(false);
                  }
               }else if(msg.startsWith("//Mouse")){ // 명령어 : 캔버스 공유 (마우스 좌표 수신)
                  if(auth == false){
                     int tempX = Integer.parseInt(msg.substring(7, msg.indexOf("."))); 
                     int tempY = Integer.parseInt(msg.substring(msg.indexOf(".") + 1));
         /*            g = canvas.getGraphics();
                     g2d = (Graphics2D)g;
                     g2d.setColor(color);
                        g2d.setStroke(new BasicStroke(6));
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                          g.drawLine(tempX, tempY, tempX, tempY);
         */         }
               }else if(msg.startsWith("//Timer")){ // 명령어 : 타이머 시간 표시
                  label_Timer.setText(msg.substring(7));
               }else{ // 일반 채팅 출력
                  textArea.append(msg + "\n");
                  scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
               }
            }catch(IOException io){}
         }
      }
   }
   
   public void updateClientList(){ // 클라이언트 목록 추가
         ImageIcon ii;
         if(Integer.parseInt(playerIdx) == 0){
            ii = new ImageIcon("image\\RC.png");
            ii.getImage().flush();
            laClient1.setIcon(ii);
            laClient1sub.setText("[" + playerName + " / " + "점수: " + playerScore + "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 1){
            ii = new ImageIcon("image\\PC.png");
            ii.getImage().flush();
            laClient2.setIcon(ii);
            laClient2sub.setText("[" + playerName + " / " + "점수: " + playerScore + "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 2){
            ii = new ImageIcon("image\\BC.png");
            ii.getImage().flush();
            laClient3.setIcon(ii);
            laClient3sub.setText("[" + playerName + " / " + "점수: " + playerScore + "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 3){
            ii = new ImageIcon("image\\YC.png");
            ii.getImage().flush();
            laClient4.setIcon(ii);
            laClient4sub.setText("[" + playerName + " / " + "점수: " + playerScore + "]");
            deleteClientList();
         }
      }
      
      public void deleteClientList(){ // 클라이언트 목록 제거
         ImageIcon ii2;
         ii2 = new ImageIcon("image\\p0.png");
         if(Integer.parseInt(playerIdx) == 0){
            laClient2.setIcon(ii2);
            laClient2sub.setText("[ 닉네임 / 점수 ]");
            laClient3.setIcon(ii2);
            laClient3sub.setText("[ 닉네임 / 점수 ]");
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ 닉네임 / 점수 ]");
         }else if(Integer.parseInt(playerIdx) == 1){
            laClient3.setIcon(ii2);
            laClient3sub.setText("[ 닉네임 / 점수 ]");
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ 닉네임 / 점수 ]");
         }else if(Integer.parseInt(playerIdx) == 2){
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ 닉네임 / 점수 ]");
         }
      }
      
   public static void main(String[]args){
      CM_Client c = new CM_Client();
   }
   
}