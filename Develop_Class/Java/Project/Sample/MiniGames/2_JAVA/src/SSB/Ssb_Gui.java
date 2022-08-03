package SSB;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ssb_Gui extends JFrame{
	Ssb_Main main;
	
	Ssb_Gui(){
		setSize(725,525);
		//setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("=/-=//-=/ //S/S/B// =/-=//-=/");
		setLocationRelativeTo(null); // ��ġ������ ���� ���� , ������ġ ���, JFrame�� ������� �߾ӿ� ���� �Ѵ�
		
	}
	//Main ��� 
	public void setSonagi_main(Ssb_Main main) {
		this.main =main;
	}
	
	
	public class MyJPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("imgs/ssb/bg.jpg");
		
		public void paintComponent(Graphics g) {
			g.drawImage(icon.getImage(), 0, 0, null); // 0,0��ǥ���� �̹����� �Ѹ�
			setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
			super.paintComponent(g);
		}
	}
	
	
}
