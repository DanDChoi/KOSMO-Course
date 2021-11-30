import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

class B extends JFrame implements ActionListener {
	Container cp;
	JLabel la1, la2, la3;
	JPanel p;
	JButton b;
	ImageIcon ii1, ii2, ii3;
	ImageIcon ii;

	void init(){
		cp = getContentPane();
		
		/*
		Class c = getClass();
		URL url = c.getResource("imgs/p_girl.PNG");
		ImageIcon ii = new ImageIcon(url);
		laImg = new JLabel(ii);
		*/
		p = new JPanel(new GridLayout(1, 3));
		//Color color = new Color(255, 255, 255);
		//p.setBackground(color);
		p.setBackground(Color.WHITE);
		
		ii1 = new ImageIcon(getClass().getResource("imgs/p_girl.PNG"));
		ii2 = new ImageIcon(getClass().getResource("imgs/p_play.png"));
		ii3 = new ImageIcon(getClass().getResource("imgs/p_study.png"));
		/*MouseListener listener = new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){
				JOptionPane.showMessageDialog(null, "마우스 커서가 들어왔어요!!");
			}
			public void mouseExited(MouseEvent e){
				JOptionPane.showMessageDialog(null, "마우스 커서가 나갔어요!!");
			}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		};*/
		MouseListener listener = new MouseAdapter(){
			int i = 0; 
			public void mouseEntered(MouseEvent e){
				Object obj = e.getSource();
				if(obj == la1){
					i = 1;
				}else if(obj == la2){
					i = 2; 
				}else{
					i = 3;
				}

				JOptionPane.showMessageDialog(null, "마우스 커서("+i+"번째 레이블)");
			}
		};
		
		la1 = new JLabel(ii1);
		la1.addMouseListener(listener);
		la2 = new JLabel(ii2);
		la2.addMouseListener(listener);
		la3 = new JLabel(ii3);
		la3.addMouseListener(listener);
		p.add(la1); p.add(la2); p.add(la3); 

		ii = new ImageIcon(getClass().getResource("imgs/puppy.gif"));
		b = new JButton(ii);
		b.addActionListener(this); 
		cp.add(p, BorderLayout.NORTH);
		cp.add(b);
		
		setUI();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		int answer = JOptionPane.showConfirmDialog(
				null, "재밌나요?", "질문", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, ii2);
        //System.out.println("answer: " + answer);

		if(answer == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "ㅋ 재밌군요!!");
		}else if(answer == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "ㅠ 노잼!!");
		}else{ //CANCEL_OPTION
			JOptionPane.showMessageDialog(null, "아.. 대답도 싫군요!!");
		}
	}
	void setUI(){
		setTitle("Event Handling 1");
		//setSize(300, 200);
		pack();
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		B b = new B();
		b.init();
	}
}
