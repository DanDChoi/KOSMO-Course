import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.stream.*;

/*import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;*/

public class CM_Server extends JFrame implements ActionListener
{
   JPanel contentPane, panel_Main, panel_TextArea, panel_Btn;
   JScrollPane scrollPane;
   JTextArea textArea;
   JLabel label_ServerStatus;
   JButton btn_ServerStart, btn_ServerClose;
   String clientName;
   ServerSocket ss;
   Socket s;
   int port = 7777;
   public static final int MAX_CLIENT = 4;
   int readyPlayer; // 게임 준비된 클라이언트 카운트
   int score;
   int i;
   Vector<String> vtScore = new Vector<String>();
   ArrayList<Integer> clientScore = new ArrayList<Integer>();
   boolean gameStart; // 게임 시작 상태
   String line = "";
   LinkedHashMap<String, DataOutputStream> clientList = new LinkedHashMap<String, DataOutputStream>(); // 클라이언트 이름, 스트림 관리
   LinkedHashMap<String, Integer> clientInfo = new LinkedHashMap<String, Integer>(); // 클라이언트 이름, 점수 관리
   //HashMap<String, Integer> clientScore = new HashMap<String, Integer>();
  
   int iScore;
   Iterator<Map.Entry<String, Integer>> itScore1;
   
   public void init(){
      setTitle("JAVA");
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 450);
      setLocationRelativeTo(null);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new GridLayout(0, 1, 10, 0));
      
      panel_Main = new JPanel();
      contentPane.add(panel_Main);
      panel_Main.setLayout(new BoxLayout(panel_Main, BoxLayout.Y_AXIS));
      
      //label_ServerStatus = new JLabel(" COVID SWEEPER ");
      label_ServerStatus = new JLabel(new ImageIcon("image\\Logo3.png"));
      label_ServerStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
      label_ServerStatus.setPreferredSize(new Dimension(96, 50));
      panel_Main.add(label_ServerStatus);
      label_ServerStatus.setHorizontalTextPosition(SwingConstants.CENTER);
      label_ServerStatus.setHorizontalAlignment(SwingConstants.CENTER);
      label_ServerStatus.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
      label_ServerStatus.setBackground(Color.GRAY);
      
      panel_TextArea = new JPanel();
      panel_Main.add(panel_TextArea);
      panel_TextArea.setLayout(new BorderLayout(0, 0));
      panel_TextArea.setBounds(100, 100, 100, 100);
      
      
      scrollPane = new JScrollPane();
      scrollPane.setBorder(new LineBorder(Color.ORANGE));
      panel_TextArea.add(scrollPane);
      
      
      
      textArea = new JTextArea();
      textArea.setLineWrap(true);
      textArea.setEditable(false);
      scrollPane.setViewportView(textArea);
      
      panel_Btn = new JPanel();
      panel_Btn.setPreferredSize(new Dimension(10, 43));
      panel_Btn.setAutoscrolls(true);
      panel_Main.add(panel_Btn);
      panel_Btn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      btn_ServerStart = new JButton(" 서버 시작 ");
      btn_ServerStart.setHorizontalTextPosition(SwingConstants.CENTER);
      btn_ServerStart.setPreferredSize(new Dimension(120, 40));
      btn_ServerStart.setFocusPainted(false);
      btn_ServerStart.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
      btn_ServerStart.setAlignmentX(Component.CENTER_ALIGNMENT);
      btn_ServerStart.setForeground(Color.WHITE);
      btn_ServerStart.setBackground(Color.ORANGE);
      btn_ServerStart.setBorder(null);
      panel_Btn.add(btn_ServerStart);
      btn_ServerStart.addActionListener(this);
      
      btn_ServerClose = new JButton(" 서버 종료 ");
      btn_ServerClose.setHorizontalTextPosition(SwingConstants.CENTER);
      btn_ServerClose.setPreferredSize(new Dimension(120, 40));
      btn_ServerClose.setFocusPainted(false);
      btn_ServerClose.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
      btn_ServerClose.setAlignmentX(Component.CENTER_ALIGNMENT);
      btn_ServerClose.setForeground(Color.WHITE);
      btn_ServerClose.setBackground(Color.ORANGE);
      btn_ServerClose.setBorder(null);
      panel_Btn.add(btn_ServerClose);
      btn_ServerClose.addActionListener(this);
      btn_ServerClose.setEnabled(false);
   }

   public void actionPerformed(ActionEvent e){ // '서버 시작 & 종료' 버튼 이벤트
      if(e.getSource() == btn_ServerStart){
         new Thread(){
            public void run() {
               try{
                  Collections.synchronizedMap(clientList);
                  ss = new ServerSocket(port);
                  textArea.append("[ 서버가 시작되었습니다 ]" + "\n");
                  btn_ServerStart.setEnabled(false);
                  btn_ServerClose.setEnabled(true);
                  while(true){
                     s = ss.accept();
                     if((clientList.size() + 1) > MAX_CLIENT || gameStart == true){ // 정원이 초과되었거나, 게임중이라면 소켓 연결 거부
                        s.close();
                     }else{
                        Thread gm = new GameManager(s);
                        gm.start();
                     }
                  }
               }catch(IOException io){}
            }
         }.start();
      }else if(e.getSource() == btn_ServerClose){
         int select = JOptionPane.showConfirmDialog(null, "서버를 정말 종료하시겠습니까?", "JAVA ", JOptionPane.OK_CANCEL_OPTION);
         try{
            if(select == JOptionPane.YES_OPTION){
               ss.close();
               textArea.append("[ 서버가 종료되었습니다 ]" + "\n");
               btn_ServerStart.setEnabled(true);
               btn_ServerClose.setEnabled(false);
            }
         }catch(IOException io){}
      }
   }
   
   public void showSystemMsg(String msg){ // 시스템 메시지 및 명령어 송신
      Iterator<String> it = clientList.keySet().iterator();
      while(it.hasNext()){
         try{
            DataOutputStream dos = clientList.get(it.next());
            dos.writeUTF(msg);
            dos.flush();
         }catch(IOException io){}
      }
   }

   
   // 내부 클래스 (게임 관리 및 통제)
   public class GameManager extends Thread
   {
      Socket s;
      DataInputStream dis;
      DataOutputStream dos;
                     
      public GameManager(Socket s){
         this.s = s;
         try{
            dis = new DataInputStream(this.s.getInputStream());
            dos = new DataOutputStream(this.s.getOutputStream());
         }catch(IOException io){}
      }
      
      public void run(){
          String clientName = "";
	//	 String score = "";
         try{
            clientName = dis.readUTF();
     //       score = dis.readUTF();
	//		serverscore = Integer.parseInt(score); // 스코어로 들어왔다.
            if(!clientList.containsKey(clientName)){ // 중복 닉네임 방지
               clientList.put(clientName, dos);
               clientInfo.put(clientName, score);
           //    clientScore.put(clientName, iScore); 
            }else if(clientList.containsKey(clientName)){
               s.close(); // 닉네임 중복시, 소켓 연결 거부
           // }else if(msg.startsWith("//score")){
		//		System.out.println("score"+serverscore);
			}
            showSystemMsg("[ " + clientName + "님이 입장하셨습니다. ]\n(현재 접속자 수 : " + clientList.size() + "명 / 4명)");
            textArea.append("[ 현재 접속자 명단 (총 " + clientList.size() + "명 접속중) ]\n");
            Iterator<String> it1 = clientList.keySet().iterator();
            while(it1.hasNext()) textArea.append(it1.next() + "\n");
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            setClientInfo(); // 클라이언트 목록 갱신
            while(dis != null){
               String msg = dis.readUTF();
			   
               filter(msg); // 명령어 필터링
			   
            }
         }catch(IOException io){
            clientList.remove(clientName); clientInfo.remove(clientName);  // 클라이언트 퇴장시 제거
            closeAll();
            if(clientList.isEmpty() == true){ // 서버에 남은 클라이언트가 하나도 없다면, 서버 닫기
               try{
                  ss.close(); System.exit(0);
               }catch(IOException e){}
            }
            showSystemMsg("[ " + clientName + "님이 퇴장하셨습니다. ]\n(현재 접속자수 : " + clientList.size() + "명 / 4명)");
            textArea.append("[ 현재 접속자 명단 (총 " + clientList.size() + "명 접속중) ]\n");
			
            Iterator<String> it1 = clientList.keySet().iterator();
            while(it1.hasNext()) textArea.append(it1.next() + "\n");
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            setClientInfo(); // 클라이언트 목록 갱신
            readyPlayer = 0; // 새로운 클라이언트가 접속해도 게임 시작에 문제가 없도록 변수 초기화
            gameStart = false;
            showSystemMsg("//GmEnd"); // 클라이언트 퇴장시, 즉시 라운드 종료

         }
      }
      
      public void closeAll(){
         try{
            if(dos != null) dos.close();
            if(dis != null) dis.close();
            if(s != null) s.close();
         }catch(IOException ie){}
      }
      
      public void setClientInfo(){
         String[] keys = new String[clientInfo.size()];
         int[] values = new int[clientInfo.size()];
         int index = 0;
         for(Map.Entry<String, Integer> mapEntry : clientInfo.entrySet()){
             keys[index] = mapEntry.getKey();
             values[index] = mapEntry.getValue();
             index++;
         }
         for(int i=0; i<clientList.size(); i++){
            showSystemMsg("//CList" + keys[i] + " " + values[i] + "#" + i); // 명령어 : 클라이언트 목록 갱신
         }
      }
      
      
      public void filter(String msg) { // 명령어 필터링
         String temp = msg.substring(0, 7);
		 
         if(temp.equals("//Chat ")){ // 명령어 : 일반 채팅
            showSystemMsg(msg.substring(7));
         }else if(temp.equals("//Ready")){ // 명령어 : 클라이언트 준비 상태 체크
             readyPlayer++;
             if(readyPlayer >= 1 && readyPlayer == clientList.size()){ // 2명 이상 && 모든 클라이언트가 준비되었을 경우
                for(int i=3; i>0; i--){
                   try{
                      showSystemMsg("[ 모든 참여자들이 준비되었습니다. ]\n[ " + i + "초 후 게임을 시작합니다 .. ]");
                     Thread.sleep(1000);
                   }catch(InterruptedException ie){}
                }
                //showSystemMsg("//ReadyAll");
                showSystemMsg("//Start"); // 명령어 : 게임 시작
				clientScore.clear(); vtScore.clear();
                //broadcast();
               /*
                * File Clap = new File("text.wav"); PlaySound(Clap);
                */
               // ArrayList<String> authList = new ArrayList<String>(); // 문제 출제자 랜덤 선택
               // Iterator<String> it = clientList.keySet().iterator();
               // while(it.hasNext()) authList.add(it.next());
                // 명령어 : 문제 출제자 랜덤 선택
               // Exam ex = new Exam(); ex.start(); // 문제 출제
                StopWatch tm = new StopWatch(); tm.start(); // 타이머 시작
                gameStart = true;
                
             }
         }else if(temp.equals("//Mouse")){ // 명령어 : 마우스 좌표 수신
            showSystemMsg(msg);
         }else if(temp.equals("//Color")){ // 명령어 : 컬러 설정
            showSystemMsg(msg);
         }else if(temp.equals("//Erase")){ // 명령어 : 지우기
            showSystemMsg(msg);
         }else if(temp.equals("//ErAll")){ // 명령어 : 모두 지우기
            showSystemMsg(msg);
		 }else if(temp.equals("//score")){
			//String score = msg.substring(0, 7);
			String scoreC = msg.substring(7,msg.indexOf(" "));
			String scoreM = msg.substring(9,msg.length());
			iScore = Integer.parseInt(scoreC);
			clientScore.add(iScore);
			
			String score2 = msg.substring(7,msg.length()); // 27 아이디
			String score3 = score2.substring(0, score2.indexOf(" ")); 
			vtScore.add(score2); // 27 아이디
			Collections.sort(clientScore , Collections.reverseOrder());
			showSystemMsg("< "+scoreM+ " > 님의 점수는 ( "+ iScore +" ) 입니다. ");
			//System.out.println(clientName+": "+iScore);
			//System.out.println("iScore: "+ iScore + scoreM);
			//clientScore.clear(); vtScore.clear();
			/*
			for(int i =0; i<clientInfo.size(); i++){
				vtScore.add(Integer.parseInt(score2));
				System.out.println("Score["+i+"]: "+Score[i]);
			}
			*/			// 00 29 29 01 29 27 10 27 27 11 27 29 
			/*
			for(Integer ss : clientScore){
			if(iScore==Integer.parseInt(score3)){
			showSystemMsg(ss + " " + scoreM);
			}else{}
			}
			// indexOf("0")~indexOf("90")
			String k = "";
			for(int i=0; i<=90 ; i++){
				k = (""+i);
				for(int j=0 ; j<i;j++){
					score2.substring(0, score2.indexOf(" "));
			}
			}
			*/
			//showSystemMsg(iScore + scoreM);

			

			//setClientScore();
		//	scoreCBoradcast(s);

         }else if(temp.equals("//GmGG ")){ // 명령어 : 게임 종료 (출제자가 게임을 포기했을 경우)
            showSystemMsg("[ 출제자가 게임을 포기했습니다 !! ]");
            showSystemMsg(msg);
            readyPlayer = 0;
            gameStart = false;
         }else if(temp.equals("//GmEnd")){ // 명령어 : 게임 종료 (시간 초과나 이탈자 발생으로 게임이 종료되는 경우)
            System.out.println("게임 종료됨-서버");
            showSystemMsg("[ 게임이 종료되었습니다 !! ]");
            showSystemMsg(msg);
            readyPlayer = 0;
			//broadcast();
			//setClientScore();
			//scoreCBoradcast(s);
            gameStart = false;
			
		//	for (int i =0; i<vtScore.size() ;i++){
		//	System.out.println("vtScore: "+vtScore.get(i));
			
			}
			
	//		for(int i=0;i<clientScore.size();i++){
	//			clientScore.put(clientName, iScore);
	//			System.out.println(":"+ clientName +" "+ iScore);
			

			

      /*   }else if(temp.equals("//score")){ // 스코어일때
            serverscore = Integer.parseInt(msg); // 스코어로 들어왔다.
            showSystemMsg(""+serverscore);
         }*/

      }
      } /*
	    String client1 [] = new String[4];
		for(int i=0;i<4;i++){
		client1.add(clientName);
		}
		int ss[] = new int[4];
		for(int i=0;i<4;i++){
		ss.add(iScore);
		}
		for (int i = 0 ;i<clientScore.length();i++ )
		{  clientScore.put(client1[i],ss[i]);
		} */
		/*
	  public void scoreCBoradcast(Socket s){
		  this.s = s;
		  DataOutputStream dos;
		  try{
		  dos = new DataOutputStream(this.s.getOutputStream());

		  Iterator<Map.Entry<String, Integer>> itScore1 = clientScore.entrySet().iterator();
			   while(itScore1.hasNext()){
				  Map.Entry<String, Integer> entry = itScore1.next();
				  System.out.println(entry.getKey() + ":" + entry.getValue());

			   }
		  }catch(IOException ie){}
	  }
	  */
/*	  
	void broadcast(){
         Iterator<String> it7 = clientScore.keySet().iterator();
		 while(it7.hasNext()) textArea.append(it7.next() + "\n");
		 scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
       //  setClientInfo(); // 클라이언트 목록 갱신
        try{
         dos = new DataOutputStream(this.s.iScore);
          while(it7.hasNext()){
            String msg = "";
            showSystemMsg(msg.substring(7));
                dos.writeUTF(msg);
                dos.flush();   
         }
        }catch(IOException ie){
        }
   }
   */

  /* 
   public void broadcast(){
	   Iterator<String> it7 = clientScore.keySet().iterator();   
        try{
         dos = new DataOutputStream(this.s.getOutputStream());
          while(it7.hasNext()){
            String msg1 = clientScore.getValue();
            showSystemMsg(msg1);
            dos.writeUTF(msg1);
		  }
		}catch(IOException ie){}

   }
*/
/*
    public void setClientScore(){
         String[] keys = new String[clientScore.size()];
         int[] values = new int[clientScore.size()];
         int index = 0;
         for(Map.Entry<String, Integer> mapEntry : clientScore.entrySet()){
             keys[index] = mapEntry.getKey(); // 클라이언트 이름
             values[index] = mapEntry.getValue(); // 클라이언트 점수 
             index++;
         }
		 for(int i=0; i<clientList.size(); i++){
            showSystemMsg("//CList" + keys[i] + " " + values[i] + "#" + i); // 명령어 : 클라이언트 목록 갱신
         }
	}
	*/
/*
		Set< String> keys = clientScore.keySet();
		TreeSet< String>  ts = new TreeSet< String> (keys);
		for(String key: ts){
			Integer value = clientScore.get(key);
			}
			*/
	
/*
	 // 내부 클래스 score2 다시 보내기
	class Score2 //extends Thread
   {    Socket s;
        DataOutputStream dos; //클라이언트에 데이터를 뿌리기 위해 사용
	    Iterator<String> it7 = clientScore.keySet().iterator();
	    while(it7.hasNext()) textArea.append(it7.next() + "\n");
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	    Score2(Socket s){ 
			this.s = s;
			  try{
				dos = new DataOutputStream(this.s.iScore); //다른 클라이언트가 출력한 값 출력하기
			//	String score = Integer.toString(vScore);
			//	String score1 = ("//score"+ score);
				dos.writeUTF(iScore);
			  }catch(IOException io){}
		}
   }
*/




      
   // 수정필요부!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

   
   // 내부 클래스 - 타이머
   class StopWatch extends Thread
   {
      long preTime = System.currentTimeMillis();
      
      public void run() {
         try{
            while(gameStart == true){
               sleep(10);
               long time = System.currentTimeMillis() - preTime;
               showSystemMsg("//Timer" + (toTime(time)));
               if(toTime(time).equals("00 : 00")){
                  showSystemMsg("//GmEnd"); // 시간 초과시, 게임 종료
                  readyPlayer = 0;
                  gameStart = false;
                  break;
               }else if(readyPlayer == 0){
                  break;
               }
            }
         }catch (Exception e){}
      }
      
      String toTime(long time){ // 서버 시간설정
         int m = (int)(0-(time / 1000.0 / 60.0)); 
         int s = (int)(10-(time % (1000.0 * 60) / 1000.0));
         return String.format("%02d : %02d", m, s);
      }
   }
   
   public static void main(String[] args){
      EventQueue.invokeLater(new Runnable(){
         public void run(){
            try{
               CM_Server cms = new CM_Server();
               cms.init();
               cms.setVisible(true);
            }catch(Exception e){
               e.printStackTrace();
            }
         }
      });
   }
}