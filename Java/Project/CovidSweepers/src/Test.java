import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Test extends JFrame implements ActionListener {
    JPanel contentPane, panel_Main, panel_Chat, panel_Exam, panel_Canvas, panel_Option;
	JButton btn_Ready, btn_Exit, btn_Color1, btn_Color2, btn_Color3, btn_Color4, btn_Color5, btn_Erase, btn_EraseAll, btn_GG;
	JLabel label_Canvas, label_Exam, label_Exam_Sub, label_Timer, label_Client1, label_Client2, label_Client3, label_Client4;
	Label label_Client1_Sub, label_Client2_Sub, label_Client3_Sub, label_Client4_Sub;
	JTextField textField;
	JTextArea textArea;
	JScrollPane scrollPane;
	Canvas canvas;
	Color color;
	Graphics g;
	Graphics2D g2d;

    int port = 7777;
    String PlayerName, PlayerScore, PlayerIdx;
    boolean gameStart, auth;

    public void init(){
		// 기본 GUI 설정
		setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		setVisible(true);
		setResizable(false);
		setTitle("Covid Sweepers Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		
		// 베이스 패널
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel_Main = new JPanel();
		panel_Main.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		panel_Main.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_Main);
		panel_Main.setLayout(null);

		JPanel panel_ClientList = new JPanel();
		JLabel label_ClientList = new JLabel(new ImageIcon("image/user.png"));
		panel_ClientList.setOpaque(false);
		label_ClientList.setOpaque(false);
		panel_ClientList.setBorder(new LineBorder(new Color(255, 164, 38), 4, true));
		panel_ClientList.setBounds(10, 105, 156, 500);
		label_ClientList.setBounds(10, 105, 156, 500);
		panel_Main.add(panel_ClientList);
		panel_Main.add(label_ClientList);
		panel_ClientList.setLayout(null);

		label_Client1 = new JLabel(new ImageIcon("image/p0.png"));
		label_Client1.setBackground(Color.BLACK);
		label_Client1.setBounds(18, 16, 120, 80);
		panel_ClientList.add(label_Client1);
		
		label_Client1_Sub = new Label("[ 닉네임 & 점수 ]");
		label_Client1_Sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		label_Client1_Sub.setAlignment(Label.CENTER);
		label_Client1_Sub.setBackground(Color.WHITE);
		label_Client1_Sub.setBounds(18, 95, 120, 30);
		panel_ClientList.add(label_Client1_Sub);
		
		label_Client2 = new JLabel(new ImageIcon("image/p0.png"));
		label_Client2.setBackground(Color.BLACK);
		label_Client2.setBounds(18, 136, 120, 80);
		panel_ClientList.add(label_Client2);
		
		label_Client2_Sub = new Label("[ 닉네임 & 점수 ]");
		label_Client2_Sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		label_Client2_Sub.setAlignment(Label.CENTER);
		label_Client2_Sub.setBackground(Color.WHITE);
		label_Client2_Sub.setBounds(18, 215, 120, 30);
		panel_ClientList.add(label_Client2_Sub);
		
		label_Client3 = new JLabel(new ImageIcon("image/p0.png"));
		label_Client3.setBackground(Color.BLACK);
		label_Client3.setBounds(18, 256, 120, 80);
		panel_ClientList.add(label_Client3);
		
		
		label_Client3_Sub = new Label("[ 닉네임 & 점수 ]");
		label_Client3_Sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		label_Client3_Sub.setAlignment(Label.CENTER);
		label_Client3_Sub.setBackground(Color.WHITE);
		label_Client3_Sub.setBounds(18, 335, 120, 30);
		panel_ClientList.add(label_Client3_Sub);
		
		label_Client4 = new JLabel(new ImageIcon("image/p0.png"));
		label_Client4.setBackground(Color.BLACK);
		label_Client4.setBounds(18, 376, 120, 80);
		panel_ClientList.add(label_Client4);

		label_Client4_Sub = new Label("[ 닉네임 & 점수 ]");
		label_Client4_Sub.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		label_Client4_Sub.setAlignment(Label.CENTER);
		label_Client4_Sub.setBackground(Color.WHITE);
		label_Client4_Sub.setBounds(18, 455, 120, 30);
		panel_ClientList.add(label_Client4_Sub);
		
		// 문제 출제 영역
		panel_Exam = new JPanel();
		panel_Exam.setBounds(10, 10, 1246, 85);
		//panel_Exam.setBackground(Color.BLACK);
		panel_Main.add(panel_Exam);
		panel_Exam.setLayout(null);
		
		JLabel label_Exam_Back = new JLabel(new ImageIcon("image/bg.png"));
		label_Exam_Back.setOpaque(true);
		label_Exam_Back.setBounds(0, 0, 1244, 84);
		panel_Exam.add(label_Exam_Back);
		panel_Exam.setLayout(null);
		/*
		label_Exam = new JLabel(new ImageIcon("image/exam.png"));
		label_Exam.setOpaque(false);
		label_Exam.setBounds(166, 10, 804, 65);
		label_Exam_Back.add(label_Exam);
		*/
		label_Exam_Sub = new JLabel();
		label_Exam_Sub.setOpaque(false);
		label_Exam_Sub.setBounds(45, 0, 803, 65);
		label_Exam_Sub.setFont(new Font("나눔바른고딕", Font.PLAIN, 24));
		label_Exam_Sub.setForeground(Color.BLACK);
		label_Exam_Sub.setHorizontalAlignment(SwingConstants.CENTER);
		label_Exam.add(label_Exam_Sub);
		btn_Ready = new JButton(new ImageIcon("image/ready1.png"));
		btn_Ready.setFocusPainted(false);
		btn_Ready.setBorderPainted(false);
		btn_Ready.setContentAreaFilled(false);
		btn_Ready.setBounds(991, 11, 115, 65);
		label_Exam_Back.add(btn_Ready);
		
		//우상단 버튼영역
		btn_Exit = new JButton(new ImageIcon("image\\close.png"));
		btn_Exit.setPressedIcon(new ImageIcon("image\\close_clicked.png"));
		btn_Exit.setFocusPainted(false);
		btn_Exit.setBorderPainted(false);
		btn_Exit.setContentAreaFilled(false);
		btn_Exit.setBounds(1118, 11, 115, 65);
		label_Exam_Back.add(btn_Exit);
		btn_Exit.addActionListener(this);
		
		// 로고 영역
		JLabel label_Logo = new JLabel(new ImageIcon("image/MainLogoForClient.png"));
		label_Logo.setOpaque(false);
		label_Logo.setBorder(null);
		label_Logo.setBounds(12, 10, 142, 65);
		label_Exam_Back.add(label_Logo);
			
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
		textArea.setBorder(new LineBorder(new Color(255, 164, 38), 4, true));
		textArea.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField.setBackground(Color.WHITE);
		textField.setBounds(0, 537, 263, 30);
		panel_Chat.add(textField);
		textField.setColumns(10);
    }


	public static void main(String[] args){
		Test t = new Test();
		t.init();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource() == btn_Exit){
		//	int select = JOptionPane.showConfirmDialog(null, "정말 게임을 종료하시겠습니까?", "Exit", JOptionPane.OK_CANCEL_OPTION);
		//	if(select == JOptionPane.YES_OPTION) System.exit(0);
		}
	}
