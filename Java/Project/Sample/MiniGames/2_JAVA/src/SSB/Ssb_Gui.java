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
		setLocationRelativeTo(null); // 배치관리자 설정 안함 , 절대위치 사용, JFrame을 모니터의 중앙에 띄우게 한다
		
	}
	//Main 등록 
	public void setSonagi_main(Ssb_Main main) {
		this.main =main;
	}
	
	
	public class MyJPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("imgs/ssb/bg.jpg");
		
		public void paintComponent(Graphics g) {
			g.drawImage(icon.getImage(), 0, 0, null); // 0,0좌표부터 이미지를 뿌림
			setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
			super.paintComponent(g);
		}
	}
	
	
}
