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
		// ȭ�鱸�� 
		super();
		loadImg();
		
		//����
		panel = new MyJPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// Ÿ��Ʋ�ֱ�
		lbTitle = new JLabel(title);
		lbTitle.setBounds(((this.getWidth()-269)/2), 80, 269, 192);
		//lbTitle.setSize(242,192);
		panel.add(lbTitle);

		// �г��� �Է¶�
		tfNick = new JTextField(" Name");
		tfNick.setBounds(((this.getWidth()-200)/2), 350, 200, 35);
		tfNick.setBackground(new Color(255,255,255,50));
//		tfNick.setBorder(new LineBorder(new Color(22, 103, 152),0, false)); // text field�� border
		tfNick.setToolTipText("�г����� �Է��ϼ���");
		tfNick.setForeground(new Color (255, 0, 142));//��Ʈ�÷�
		tfNick.setFont(new Font("���� ���", Font.BOLD | Font.ITALIC, 20)); 
		tfNick.setBorder( new MatteBorder(0, 0, 2, 0, Color.WHITE));
		panel.add(tfNick);
		tfNick.addKeyListener(this);
		
		// select LV
		lbLv = new JLabel("SPEED");
		lbLv.setForeground(new Color (255, 255, 255));//��Ʈ�÷�
		lbLv.setFont(new Font("Impact", Font.PLAIN, 24)); 
		lbLv.setBounds(((this.getWidth()-200)/2), 300, 200, 35);
		lbLv.setToolTipText("���̵� ����");
		panel.add(lbLv);

		bLv1 = new JButton(lv1);
		bLv3 = new JButton(lv3);
		bLv5 = new JButton(lv5);
		bLv1.setBounds(75,0,35,35);
		bLv3.setBounds(75+35+10,0,35,35);
		bLv5.setBounds(75+35+10+35+10,0,35,35);
		bLv1.setContentAreaFilled(false); //��� ���� ä��� ����
		//bLv1.setOpaque(false); // �����ϰ�
		//bLv1.setFocusPainted(false); // ����, ��Ŀ�� �Ǿ��� �� �׵θ� ��� ����
		bLv1.setBorderPainted(false); // ���� ����
		bLv3.setBorderPainted(false); // ���� ����
		bLv5.setBorderPainted(false); // ���� ����
		bLv1.setToolTipText("������");
		bLv3.setToolTipText("�ҳ���");
		bLv5.setToolTipText("����ȣ��");
		lbLv.add(bLv1);
		lbLv.add(bLv3);
		lbLv.add(bLv5);
		bLv1.addActionListener(this);
		bLv3.addActionListener(this);
		bLv5.addActionListener(this);
		
		// start ��ư
		bStart = new JButton(btn_start);
		bStart.setContentAreaFilled(false);
		//bStart.setBounds(((this.getWidth()-200)/2),350, 200, 50);
		bStart.setBounds(((this.getWidth()-200)/2),400, 221, 77);
		bStart.setBorderPainted(false); // ���� ����
		bStart.setToolTipText("���ӽ���");
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
	
	
	// ��ư  �̺�Ʈ 
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

	
//����Ű �̺�Ʈ 
	@Override
	public void keyPressed(KeyEvent e) {
		//����Ű �̺�Ʈ 
		if (e.getKeyCode() == KeyEvent.VK_ENTER){ // �ؽ�Ʈ �̷�â�� ���� �ִٸ� �г��� ������ ���� ��  ����ȭ�� ���� 
			tStart();
		}
		 
	}

	//�Է��ʵ忡�� ���� �Ǵ� ���۹�ư�� Ŭ�������� �ϳ��� ���� �ϱ� ���� �޼ҵ� 
	public void tStart() {
		if(!tfNick.getText().equals("")){
			  Nick_Name = tfNick.getText().toString(); 
			  main.showGameView(this, Nick_Name, level);
		  }else { // �ؽ�Ʈ �Է�â�� ���� ���ٸ� â�� ����
			  JOptionPane.showMessageDialog(panel, "�ùٸ��� ���� �г��� �Դϴ�.");
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
