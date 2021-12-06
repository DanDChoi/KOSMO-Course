import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
class BMission extends JFrame{
	Container cp;
	JButton bE, bW, bS, bN, bC;
	JPanel pC , p;
	JButton bCpC;
	ImageIcon ii1, ii2, ii3, ii4;
	JButton la1, la2, la3, la4;

	void init(){

		MouseListener listenerE = new MouseListener(){ ///동쪽
			public void mouseClicked(MouseEvent e){
				JOptionPane.showConfirmDialog(
				null /*이게뭘까*/, "메세지내용"/*중간에내용*/, "제목" /* 질문창의 타이틀*/, 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, ii1/*이미지*/);
				
			}
			public void mouseEntered(MouseEvent e){
				//JOptionPane.showMessageDialog(null, "마우스 커서가 들어왔어요!!"); // 커서가 들어오는 반응을 하면 . 
			}
			public void mouseExited(MouseEvent e){ //커서나가면 반응함. 아이콘단위로
				//JOptionPane.showMessageDialog(null, "마우스 커서가 나갔어요!!");
			}
			public void mousePressed(MouseEvent e){ // 클릭보다쌤 얘를 설정해주면 클릭의 설정이 안먹힘. 순서는 상관이 없음.
				//JOptionPane.showMessageDialog(null, "마우스 꾹눌러버려");
			}
			public void mouseReleased(MouseEvent e){ // 마우스를 땠을때 // 매개변수  MouseEvent e
				//JOptionPane.showMessageDialog(null, "마우스 릴리즈");
			}
		};

		MouseListener listenerW = new MouseListener(){ //서쪽
			public void mouseClicked(MouseEvent e){
				int answer = JOptionPane.showConfirmDialog(
				null /*이게뭘까*/, "종료할까요?"/*중간에내용*/, "선택" /* 질문창의 타이틀*/, 
				JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, ii2/*이미지*/);
				if(answer == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
			public void mouseEntered(MouseEvent e){
				//JOptionPane.showMessageDialog(null, "마우스 커서가 들어왔어요!!"); // 커서가 들어오는 반응을 하면 . 
			}
			public void mouseExited(MouseEvent e){ //커서나가면 반응함. 아이콘단위로
				//JOptionPane.showMessageDialog(null, "마우스 커서가 나갔어요!!");
			}
			public void mousePressed(MouseEvent e){ // 클릭보다쌤 얘를 설정해주면 클릭의 설정이 안먹힘. 순서는 상관이 없음.
				//JOptionPane.showMessageDialog(null, "마우스 꾹눌러버려");
			}
			public void mouseReleased(MouseEvent e){ // 마우스를 땠을때 // 매개변수  MouseEvent e
				//JOptionPane.showMessageDialog(null, "마우스 릴리즈");
			}
		};

		MouseListener listenerN = new MouseListener(){ //북쪽
			public void mouseClicked(MouseEvent e){
				JOptionPane.showConfirmDialog(
				null /*이게뭘까*/, ""/*중간에내용*/, "" /* 질문창의 타이틀*/, 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, ii1/*이미지*/);
			} // 마우스클릭
			public void mouseEntered(MouseEvent e){
				//JOptionPane.showMessageDialog(null, "마우스 커서가 들어왔어요!!"); // 커서가 들어오는 반응을 하면 . 
			}
			public void mouseExited(MouseEvent e){ //커서나가면 반응함. 아이콘단위로
				//JOptionPane.showMessageDialog(null, "마우스 커서가 나갔어요!!");
			}
			public void mousePressed(MouseEvent e){ // 클릭보다쌤 얘를 설정해주면 클릭의 설정이 안먹힘. 순서는 상관이 없음.
				//JOptionPane.showMessageDialog(null, "마우스 꾹눌러버려");
			}
			public void mouseReleased(MouseEvent e){ // 마우스를 땠을때 // 매개변수  MouseEvent e
				//JOptionPane.showMessageDialog(null, "마우스 릴리즈");
			}
		};

		MouseListener listenerS = new MouseListener(){ //남쪽
			public void mouseClicked(MouseEvent e){
				String feel[] = {"좋아","그냥그래","안좋아"};
				Object selected = JOptionPane.showInputDialog(null, "기분이 어때?", "기분",
				  JOptionPane.QUESTION_MESSAGE, ii1, feel, feel[0]);
				if(selected == null){
					JOptionPane.showMessageDialog(null, "지금 기분좀 대답해주라~~");
				}else if(selected.equals("좋아")){
					JOptionPane.showMessageDialog(null, "기분이좋구나");
				}else if(selected.equals("그냥그래")){
					JOptionPane.showMessageDialog(null, "기분이 그냥그렇구나");
				}else{
					JOptionPane.showMessageDialog(null, "기분이 안좋구나");
				}
			} // 마우스클릭
			public void mouseEntered(MouseEvent e){
				//JOptionPane.showMessageDialog(null, "마우스 커서가 들어왔어요!!"); // 커서가 들어오는 반응을 하면 . 
			}
			public void mouseExited(MouseEvent e){ //커서나가면 반응함. 아이콘단위로
				//JOptionPane.showMessageDialog(null, "마우스 커서가 나갔어요!!");
			}
			public void mousePressed(MouseEvent e){ // 클릭보다쌤 얘를 설정해주면 클릭의 설정이 안먹힘. 순서는 상관이 없음.
				//JOptionPane.showMessageDialog(null, "마우스 꾹눌러버려");
			}
			public void mouseReleased(MouseEvent e){ // 마우스를 땠을때 // 매개변수  MouseEvent e
				//JOptionPane.showMessageDialog(null, "마우스 릴리즈");
			}
		};

		bE = new JButton("동쪽");
		bE.addMouseListener(listenerE);
		bW = new JButton("서쪽");
		bW.addMouseListener(listenerW);
		bS = new JButton("남쪽");
		bS.addMouseListener(listenerS);
		bN = new JButton("북쪽");
		bN.addMouseListener(listenerN);
		bC = new JButton("모니터창");
		pC = new JPanel();

		cp = getContentPane();
		cp.add(bE, BorderLayout.EAST);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bN, BorderLayout.NORTH);
		cp.add(pC, BorderLayout.CENTER);

		ii1 = new ImageIcon(getClass().getResource("imgs/p_girl.PNG")); //이미지를 클래스에서 자원형태로 가져옴.  이미지 아이콘을.
		ii2 = new ImageIcon(getClass().getResource("imgs/p_play.png")); //이미지를 클래스에서 자원형태로 가져옴.  이미지 아이콘을.
		ii3 = new ImageIcon(getClass().getResource("imgs/p_study.png"));
		ii4 = new ImageIcon(getClass().getResource("imgs/puppy.gif")); //이미지를 클래스에서 자원형태로 가져옴.  이미지 아이콘을.

		la1 = new JButton(ii1); // 화면에 출력. 이미지를 단지, 화면에 올려주는 역할을하는데 String형태나 이미지 gif도 됩니다. ii4 // 이미지경로를 바로 넣으면 스트링으로 인식해서 말만나옴
		la2 = new JButton(ii2);
		la3 = new JButton(ii3);
		la4 = new JButton(ii4);
		pC.setLayout(new GridLayout(2,2));
		pC.add(la1); pC.add(la2); pC.add(la3); pC.add(la4); // 패널 위에 라벨을 생성

		setUI();
	}
	void setUI(){
		setTitle("BorderLayout Test");
		//setSize(400, 300);
		pack();
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

	public static void main(String[] args) {
		BMission b = new BMission();
		b.init();
	}
}
