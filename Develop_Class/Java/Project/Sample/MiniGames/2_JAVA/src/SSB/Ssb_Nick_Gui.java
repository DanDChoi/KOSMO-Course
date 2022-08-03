package SSB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
 


public class Ssb_Nick_Gui extends Ssb_Gui implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	MyJPanel  panel;
	JButton bStart, bLv1, bLv3, bLv5;
	JLabel lbBg, lbNick, lbLv, lbTitle;
	JTextField tfNick;
	TitledBorder tbBorder;
	ImageIcon lv1,lv5,lv3,btn_start, lv1_on, lv3_on, lv5_on, title;
	String Nick_Name;
	int level = 0;
	
	public Ssb_Nick_Gui(){
		// 화면구성 
		super();
		loadImg();
		
		//센터
		panel = new MyJPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// 타이틀넣기
		lbTitle = new JLabel(title);
		lbTitle.setBounds(((this.getWidth()-269)/2), 80, 269, 192);
		//lbTitle.setSize(242,192);
		panel.add(lbTitle);

		// 닉네임 입력란
		tfNick = new JTextField(" Name");
		tfNick.setBounds(((this.getWidth()-200)/2), 350, 200, 35);
		tfNick.setBackground(new Color(255,255,255,50));
//		tfNick.setBorder(new LineBorder(new Color(22, 103, 152),0, false)); // text field의 border
		tfNick.setToolTipText("닉네임을 입력하세요");
		tfNick.setForeground(new Color (255, 0, 142));//폰트컬러
		tfNick.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 20)); 
		tfNick.setBorder( new MatteBorder(0, 0, 2, 0, Color.WHITE));
		panel.add(tfNick);
		tfNick.addKeyListener(this);
		
		// select LV
		lbLv = new JLabel("SPEED");
		lbLv.setForeground(new Color (255, 255, 255));//폰트컬러
		lbLv.setFont(new Font("Impact", Font.PLAIN, 24)); 
		lbLv.setBounds(((this.getWidth()-200)/2), 300, 200, 35);
		lbLv.setToolTipText("난이도 선택");
		panel.add(lbLv);

		bLv1 = new JButton(lv1);
		bLv3 = new JButton(lv3);
		bLv5 = new JButton(lv5);
		bLv1.setBounds(75,0,35,35);
		bLv3.setBounds(75+35+10,0,35,35);
		bLv5.setBounds(75+35+10+35+10,0,35,35);
		bLv1.setContentAreaFilled(false); //배경 영역 채우기 안함
		//bLv1.setOpaque(false); // 투명하게
		//bLv1.setFocusPainted(false); // 선택, 포커스 되었을 때 테두리 사용 안함
		bLv1.setBorderPainted(false); // 보더 삭제
		bLv3.setBorderPainted(false); // 보더 삭제
		bLv5.setBorderPainted(false); // 보더 삭제
		bLv1.setToolTipText("가랑비");
		bLv3.setToolTipText("소나기");
		bLv5.setToolTipText("집중호우");
		lbLv.add(bLv1);
		lbLv.add(bLv3);
		lbLv.add(bLv5);
		bLv1.addActionListener(this);
		bLv3.addActionListener(this);
		bLv5.addActionListener(this);
		
		// start 버튼
		bStart = new JButton(btn_start);
		bStart.setContentAreaFilled(false);
		//bStart.setBounds(((this.getWidth()-200)/2),350, 200, 50);
		bStart.setBounds(((this.getWidth()-200)/2),400, 221, 77);
		bStart.setBorderPainted(false); // 보더 삭제
		bStart.setToolTipText("게임시작");
		panel.add(bStart);
		bStart.addActionListener(this);

		super.setVisible(true);
		
		
	}
	
	
	void loadImg(){
		try{
			lv1 = new ImageIcon(ImageIO.read(new File("imgs/ssb/low.png")));
			lv3 = new ImageIcon(ImageIO.read(new File("imgs/ssb/mid.png")));
			lv5 = new ImageIcon(ImageIO.read(new File("imgs/ssb/high.png")));
			lv1_on = new ImageIcon(ImageIO.read(new File("imgs/ssb/lowclick.png")));
			lv3_on = new ImageIcon(ImageIO.read(new File("imgs/ssb/midclick.png")));
			lv5_on = new ImageIcon(ImageIO.read(new File("imgs/ssb/highclick.png")));
			btn_start = new ImageIcon(ImageIO.read(new File("imgs/ssb/btn_start.png")));
			title = new ImageIcon(ImageIO.read(new File("imgs/ssb/title.png")));
		}catch(IOException ie){}
	}
	
	
	// 버튼  이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bStart) {
			tStart();
		} else if(e.getSource() == bLv1) {
			bLv1.setIcon(lv1_on);
			bLv3.setIcon(lv3);
			bLv5.setIcon(lv5);
			level = 0;
		} else if(e.getSource() == bLv3) {
			bLv1.setIcon(lv1);
			bLv3.setIcon(lv3_on);
			bLv5.setIcon(lv5);
			level = 3;
		} else if(e.getSource() == bLv5) {
			bLv1.setIcon(lv1);
			bLv3.setIcon(lv3);
			bLv5.setIcon(lv5_on);
			level = 6;
		}
		 
	}

	
//엔터키 이벤트 
	@Override
	public void keyPressed(KeyEvent e) {
		//엔터키 이벤트 
		if (e.getKeyCode() == KeyEvent.VK_ENTER){ // 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후  게임화면 띄우기 
			tStart();
		}
		 
	}

	//입력필드에서 엔터 또는 시작버튼을 클릭했을때 하나로 통일 하기 위한 메소드 
	public void tStart() {
		if(!tfNick.getText().equals("")){
			  Nick_Name = tfNick.getText().toString(); 
			  main.showGameView(this, Nick_Name, level);
		  }else { // 텍스트 입력창에 값이 없다면 창을 띄운다
			  JOptionPane.showMessageDialog(panel, "올바르지 않은 닉네임 입니다.");
		  }
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
