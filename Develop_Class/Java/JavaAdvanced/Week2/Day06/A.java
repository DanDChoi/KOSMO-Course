/*
GUI
-배치
Component(쟁반, 과일, 밥그릇, 수저..) : JButton
Container(식탁): JFrame

-배치관리자(LayoutManager)
-BorderLayout
-...

*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A extends JFrame {
	JButton b;
	void init(){
		b = new JButton("자바의 버튼");
		/*ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("이벤트발생!! 클릭하셨네요^^");
			}
		};*/
		ActionListener listener = (e) -> {
			b.setText("람다식으로 이벤트 처리됨");
		};
		b.addActionListener(listener);
		add(b);

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		A a = new A();
		a.init();
	}
}
