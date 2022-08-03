import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class CM_Client extends JFrame implements ActionListener
{
   JPanel contentPane, panel_Main, panel_Chat, panel_Exam, panel_Mine, panel_Option;
   JButton btn_Ready, btn_Exit, btn_Color1, btn_Color2, btn_Color3, btn_Color4, btn_Color5, btn_Erase, btn_EraseAll, btn_GG;
   JLabel label_Canvas, label_Exam, label_Exam_Sub, label_Timer, label_Client1, label_Client2, label_Client3, label_Client4 ,label_MineBack;
   Label label_Client1_Sub, label_Client2_Sub, label_Client3_Sub, label_Client4_Sub;
   JTextField textField;
   JTextArea textArea;
   JScrollPane scrollPane;
   Canvas canvas;
   Color color;
   Graphics g;
   Graphics2D g2d;
   
   int port = 7777;
   String playerName, playerScore, playerIdx; // Ŭ���̾�Ʈ �̸�, ����, �ε��� ����
   boolean gameStart, auth; // ���� ���� ���� üũ & ������ ���� ����
   
   public CM_Client(){
      // �⺻ GUI ����
      setFont(new Font("�����ٸ����", Font.PLAIN, 13)); 
      setVisible(true);
      setResizable(false);
      setTitle("JAVA CatchMind Client"); //�����̸�
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1280, 720);
      setLocationRelativeTo(null);  // �̰� �����Ű�� ��������� ����
      
      // ���̽� �г�
      contentPane = new JPanel();
      contentPane.setBorder(null);
      setContentPane(contentPane);
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));  // axis�� ���Ĺ�� ��>>��� ��ġ
      
      panel_Main = new JPanel();
      panel_Main.setFont(new Font("�����ٸ����", Font.PLAIN, 13));
      panel_Main.setBackground(new Color(255, 255, 255));
      contentPane.add(panel_Main);
      panel_Main.setLayout(null);
      
      // ������ ��� ����
      JPanel panel_ClientList = new JPanel();
      JLabel label_ClientList = new JLabel(new ImageIcon("image\\user.png"));
      panel_ClientList.setOpaque(false);
      label_ClientList.setOpaque(false);
      panel_ClientList.setBorder(new LineBorder(new Color(255, 164, 38), 4, true)); //setborder ��������,�÷�����
      panel_ClientList.setBounds(10, 105, 156, 500);
      label_ClientList.setBounds(10, 105, 156, 500);
      panel_Main.add(panel_ClientList);
      panel_Main.add(label_ClientList);
      panel_ClientList.setLayout(null);
      
      label_Client1 = new JLabel(new ImageIcon("image\\p0.png"));
      label_Client1.setBackground(Color.GRAY);
      label_Client1.setBounds(18, 15, 120, 80);
      panel_ClientList.add(label_Client1);
      
      label_Client1_Sub = new Label("[ �г��� & ���� ]");
      label_Client1_Sub.setFont(new Font("�����ٸ����", Font.BOLD, 13));
      label_Client1_Sub.setAlignment(Label.CENTER);
      label_Client1_Sub.setBackground(Color.WHITE);
      label_Client1_Sub.setBounds(18, 95, 120, 30);
      panel_ClientList.add(label_Client1_Sub);
      
      label_Client2 = new JLabel(new ImageIcon("image\\p0.png"));
      label_Client2.setBackground(Color.GRAY);
      label_Client2.setBounds(18, 135, 120, 80);
      panel_ClientList.add(label_Client2);
      
      label_Client2_Sub = new Label("[ �г��� & ���� ]");
      label_Client2_Sub.setFont(new Font("�����ٸ����", Font.BOLD, 13));
      label_Client2_Sub.setAlignment(Label.CENTER);
      label_Client2_Sub.setBackground(Color.WHITE);
      label_Client2_Sub.setBounds(18, 215, 120, 30);
      panel_ClientList.add(label_Client2_Sub);
      
      label_Client3 = new JLabel(new ImageIcon("image\\p0.png"));
      label_Client3.setBackground(Color.GRAY);
      label_Client3.setBounds(18, 255, 120, 80);
      panel_ClientList.add(label_Client3);
      
      label_Client3_Sub = new Label("[ �г��� & ���� ]");
      label_Client3_Sub.setFont(new Font("�����ٸ����", Font.BOLD, 13));
      label_Client3_Sub.setAlignment(Label.CENTER);
      label_Client3_Sub.setBackground(Color.WHITE);
      label_Client3_Sub.setBounds(18, 335, 120, 30);
      panel_ClientList.add(label_Client3_Sub);
      
      label_Client4 = new JLabel(new ImageIcon("image\\p0.png"));
      label_Client4.setBackground(Color.GRAY);
      label_Client4.setBounds(18, 375, 120, 80);
      panel_ClientList.add(label_Client4);
      
      label_Client4_Sub = new Label("[ �г��� & ���� ]");
      label_Client4_Sub.setFont(new Font("�����ٸ����", Font.BOLD, 13));
      label_Client4_Sub.setAlignment(Label.CENTER);
      label_Client4_Sub.setBackground(Color.WHITE);
      label_Client4_Sub.setBounds(18, 455, 120, 30);
      panel_ClientList.add(label_Client4_Sub);
      
      // ���� ���� ����
      panel_Exam = new JPanel();
      panel_Exam.setBounds(10, 10, 1245, 85);
      panel_Main.add(panel_Exam);
      panel_Exam.setLayout(null);
      
      JLabel label_Exam_Back = new JLabel(new ImageIcon("image\\topBg.png")); // ���� �ϴû�
      label_Exam_Back.setOpaque(true);// ���� ����
      label_Exam_Back.setBounds(0, 0, 1245, 85);
      panel_Exam.add(label_Exam_Back);
      panel_Exam.setLayout(null);
      
      label_Exam = new JLabel(new ImageIcon("image\\exam.png")); // //������� ���� �׸�
      label_Exam.setOpaque(false);
      label_Exam.setBounds(166, 10, 803, 65);
      label_Exam_Back.add(label_Exam);
      
      label_Exam_Sub = new JLabel();
      label_Exam_Sub.setOpaque(false); //�����ϰ�
      label_Exam_Sub.setBounds(45, 0, 803, 65);
      label_Exam_Sub.setFont(new Font("�����ٸ����", Font.PLAIN, 24));
      label_Exam_Sub.setForeground(Color.BLACK);
      label_Exam_Sub.setHorizontalAlignment(SwingConstants.CENTER);
      label_Exam.add(label_Exam_Sub);
      
      // ���� ��ư ����
      btn_Ready = new JButton(new ImageIcon("image\\ready.png"));
      btn_Ready.setPressedIcon(new ImageIcon("image\\readyClicked.png"));
      btn_Ready.setFocusPainted(false);
      btn_Ready.setBorderPainted(false);
      btn_Ready.setContentAreaFilled(false);
      btn_Ready.setBounds(991, 11, 115, 65);
      label_Exam_Back.add(btn_Ready);
      
      btn_Exit = new JButton(new ImageIcon("image\\close.png"));
      btn_Exit.setPressedIcon(new ImageIcon("image\\closeClicked.png"));
      btn_Exit.setFocusPainted(false);
      btn_Exit.setBorderPainted(false);
      btn_Exit.setContentAreaFilled(false);
      btn_Exit.setBounds(1118, 11, 115, 65);
      label_Exam_Back.add(btn_Exit);
      btn_Exit.addActionListener(this); // aaddActionListener(this) �־���� ��ư ������ �����
      
      // �ΰ� ����
      JLabel label_Logo = new JLabel(new ImageIcon("image\\topLogo.png"));
      label_Logo.setOpaque(false);
      label_Logo.setBorder(null);
      label_Logo.setBounds(12, 10, 142, 65);
      label_Exam_Back.add(label_Logo);
      
      // ä�� ����
      panel_Chat = new JPanel();
      panel_Chat.setBounds(992, 105, 263, 567);
      panel_Main.add(panel_Chat);
      panel_Chat.setLayout(null);
      
      scrollPane = new JScrollPane(textArea);
      scrollPane.setFont(new Font("�����ٸ����", Font.PLAIN, 13));
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(0, 0, 263, 535);
      panel_Chat.add(scrollPane);
      
      textArea = new JTextArea();
      textArea.setBorder(new LineBorder(new Color(255, 164, 38), 4, true));
      textArea.setFont(new Font("�����ٸ����", Font.PLAIN, 13));
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      scrollPane.setViewportView(textArea);
      textArea.setBackground(Color.WHITE);
      
      textField = new JTextField();
      textField.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
      textField.setBackground(Color.WHITE);
      textField.setBounds(0, 537, 263, 30);
      panel_Chat.add(textField);
      textField.setColumns(10);

   

	  /*panel_Mine = new JPanel();
	  panel_Mine.setOpaque(false);
	  panel_Option.setBackground(Color.black);
	  panel_Mine.setBounds(177, 105, 600, 600);
	  panel_Main.add(panel_Mine);
	  panel_Mine.setLayout(new BorderLayout(0,0));
	 */
	 /*
  		JPanel panel_MineBack = new JPanel();
  		label_MineBack = new JLabel(new ImageIcon("image\\2.jpg"));
		label_MineBack.setBackground(Color.white);
		label_MineBack.setBounds(177, 105, 600, 600);
		panel_MineBack.add(label_MineBack);
	*/
	
      // ĵ���� ���� >> ���ڿ���
      /*
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
      CanvasHandler ch = new CanvasHandler(); // ĵ���� �ڵ鷯
      canvas.addMouseMotionListener(ch);
      */
      panel_Option = new JPanel();
      panel_Option.setOpaque(true);
      panel_Option.setBackground(Color.WHITE);
      panel_Option.setBounds(10, 615, 967, 57);
      panel_Main.add(panel_Option);
      panel_Option.setLayout(null);
      /*
      btn_Color1 = new JButton(new ImageIcon("image\\red.png"));
      btn_Color1.setPressedIcon(new ImageIcon("image\\red_clicked.png"));
      btn_Color1.setFocusPainted(false);
      btn_Color1.setContentAreaFilled(false);
      btn_Color1.setBorder(null);
      btn_Color1.setBounds(179, 10, 75, 37);
      panel_Option.add(btn_Color1);
      btn_Color1.addActionListener(ch);
      
      btn_Color2 = new JButton(new ImageIcon("image\\green.png"));
      btn_Color2.setPressedIcon(new ImageIcon("image\\green_clicked.png"));
      btn_Color2.setFocusPainted(false);
      btn_Color2.setContentAreaFilled(false);
      btn_Color2.setBorder(null);
      btn_Color2.setBounds(266, 10, 75, 37);
      panel_Option.add(btn_Color2);
      btn_Color2.addActionListener(ch);
      
      btn_Color3 = new JButton(new ImageIcon("image\\blue.png"));
      btn_Color3.setPressedIcon(new ImageIcon("image\\blue_clicked.png"));
      btn_Color3.setFocusPainted(false);
      btn_Color3.setContentAreaFilled(false);
      btn_Color3.setBorder(null);
      btn_Color3.setBounds(353, 10, 75, 37);
      panel_Option.add(btn_Color3);
      btn_Color3.addActionListener(ch);
      
      btn_Color4 = new JButton(new ImageIcon("image\\yellow.png"));
      btn_Color4.setPressedIcon(new ImageIcon("image\\yellow_clicked.png"));
      btn_Color4.setFocusPainted(false);
      btn_Color4.setContentAreaFilled(false);
      btn_Color4.setBorder(null);
      btn_Color4.setBounds(440, 10, 75, 37);
      panel_Option.add(btn_Color4);
      btn_Color4.addActionListener(ch);
      
      btn_Color5 = new JButton(new ImageIcon("image\\black.png"));
      btn_Color5.setPressedIcon(new ImageIcon("image\\black_clicked.png"));
      btn_Color5.setFocusPainted(false);
      btn_Color5.setContentAreaFilled(false);
      btn_Color5.setBorder(null);
      btn_Color5.setBounds(527, 10, 75, 37);
      panel_Option.add(btn_Color5);
      btn_Color5.addActionListener(ch);
      
      btn_Erase = new JButton(new ImageIcon("image\\erase.png"));
      btn_Erase.setPressedIcon(new ImageIcon("image\\erase_clicked.png"));
      btn_Erase.setFocusPainted(false);
      btn_Erase.setContentAreaFilled(false);
      btn_Erase.setBorder(null);
      btn_Erase.setBounds(641, 10, 60, 37);
      panel_Option.add(btn_Erase);
      btn_Erase.addActionListener(ch);
      
      btn_EraseAll = new JButton(new ImageIcon("image\\eraseall.png"));
      btn_EraseAll.setPressedIcon(new ImageIcon("image\\eraseall_clicked.png"));
      btn_EraseAll.setFocusPainted(false);
      btn_EraseAll.setContentAreaFilled(false);
      btn_EraseAll.setBorder(null);
      btn_EraseAll.setBounds(713, 10, 90, 37);
      panel_Option.add(btn_EraseAll);
      btn_EraseAll.addActionListener(ch);
      
      btn_GG = new JButton(new ImageIcon("image\\gg.png"));
      btn_GG.setPressedIcon(new ImageIcon("image\\gg_clicked.png"));
      btn_GG.setFocusPainted(false);
      btn_GG.setContentAreaFilled(false);
      btn_GG.setBorder(null);
      btn_GG.setBounds(855, 10, 100, 37);
      panel_Option.add(btn_GG);
      */
      
	  // Ÿ�̸� ���� �� �ȸ������?

		JLabel label_Timer_Back = new JLabel(new ImageIcon("image\\timerBg.png"));
		label_Timer_Back.setOpaque(true);
		label_Timer = new JLabel("00 : 00");
		label_Timer.setHorizontalTextPosition(SwingConstants.CENTER);
		label_Timer.setHorizontalAlignment(SwingConstants.CENTER);
		label_Timer.setFont(new Font("�����ٸ����", Font.PLAIN, 24));
		label_Timer.setForeground(Color.black);
		label_Timer_Back.setBounds(0, 0, 158, 57);
		label_Timer.setBounds(0, 10, 158, 57);
		panel_Option.add(label_Timer_Back);
		label_Timer_Back.add(label_Timer);
		

   }
	

   
   

   /*
   public void startChat(){
		String nickName = CM_Login.nickName;
		String ip = CM_Login.ip;

		try{
			Socket s = new Socket(ip, port);
			Sender sender = new Sender(s, nickName);
			Listener listener = new Listener(s);
			new Thread(sender).start();
			new Thread(listener).start();
		}catch(UnknownHostException uh){
			JOptionPane.showMessageDialog(null, "ȣ��Ʈ�� ã�� �� �����ϴ�!", "ERROR", JOptionPane.WARNING_MESSAGE);
		}catch(IOException io){
			JOptionPane.showMessageDialog(null, "���� ���� ����!\n������ ���� �ִ� �� �����ϴ�.", "ERROR", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
	/*

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
	
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btn_Ready){ // '�غ�' ��ư
				try{
					dos.writeUTF("//Chat " + "[ " + nickName + " �� �غ� �Ϸ� ! ]");
					dos.flush();
					dos.writeUTF("//Ready");
					dos.flush();
					btn_Ready.setEnabled(false);
				}catch(IOException io){}
			}
		}
	

		public void keyReleased(KeyEvent e){ // ä�� �Է�
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
	// ���� Ŭ���� - ����

	class Listener extends Thread // ����
	{
		Socket s;
		DataInputStream dis;

		Listener(Socket s){
			this.s = s;
			try{
				dis = new DataInputStream(this.s.getInputStream());
			}catch(IOException io){}
		}
		public void run(){
			while(dis !=null ){
				try{
					String msg = dis.readUTF();
				}catch(IOException io){}
			}
		}
	}
			

*/
   public static void main(String[]args){
      CM_Client c = new CM_Client();
   }
   public void actionPerformed(ActionEvent e){
   }
}


      