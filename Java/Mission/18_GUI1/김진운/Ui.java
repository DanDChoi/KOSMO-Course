import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Ui extends JFrame implements ActionListener
{
	Container cp;
	JPanel pC;
	JButton bE, bW, bS, bN, bC;
	JButton b1,b2,b3,b4;
	ImageIcon ii1, ii2, ii3, ii4;

	void init(){
		pC = new JPanel();
		pC.setLayout(new GridLayout(2,2));

		bE = new JButton("동");
		bE.addActionListener(this);
		bW = new JButton("서");
		bW.addActionListener(this);
		bS = new JButton("남");
		bS.addActionListener(this);
		bN = new JButton("북");
		bN.addActionListener(this);
		
		ii1 = new ImageIcon(getClass().getResource("imgs/p_girl.png"));
		ii2 = new ImageIcon(getClass().getResource("imgs/p_hello.png"));
		ii3 = new ImageIcon(getClass().getResource("imgs/p_play.png"));
		ii4 = new ImageIcon(getClass().getResource("imgs/p_study.png"));

		b1 = new JButton("버튼1",ii1);
		b1.addActionListener(this);
		b2 = new JButton("버튼2",ii2);
		b2.addActionListener(this);
		b3 = new JButton("버튼3",ii3);
		b4 = new JButton("버튼4",ii4);
		pC.add(b1);pC.add(b2);pC.add(b3);pC.add(b4);

	

		cp = getContentPane();
		cp.add(bE, BorderLayout.EAST);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bN, BorderLayout.NORTH);
		cp.add(pC, BorderLayout.CENTER);

		setUI();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == bN){
		 JOptionPane.showMessageDialog(
				null, null, "Title", 
				JOptionPane.WARNING_MESSAGE,  ii4);
			
		}
		if(e.getSource() == bE){
			int answer = JOptionPane.showConfirmDialog(
				null, "메세지내용", "제목", 
				JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, ii1);
			
		}
		if(e.getSource() == bS){
			
			String list[] ={"Good","Bad","Sad"};
			String answer = (String)JOptionPane.showInputDialog(
				null, "오늘 기분 어때?", "질문", 
				JOptionPane.WARNING_MESSAGE, ii3, list, list[0]);
			 if (answer.equals("Good"))
			 {
				JOptionPane.showMessageDialog(null,"좋아좋아");
			 }else if(answer.equals("Bad")){
				JOptionPane.showMessageDialog(null,"나빠");
			 }else if(answer.equals("Sad")){
				JOptionPane.showMessageDialog(null,"슬퍼");
			 }
			//JList<String> jlist = new JList<String>(list);
			//JPanel jp;
			//jp = new JPanel();
			//jp.add(jlist);
			//add(jp);
		}
		if(e.getSource() == bW){
				int answer = JOptionPane.showConfirmDialog(
				null, "종료하시겠습니까?", "질문", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, ii2);
        //System.out.println("answer: " + answer);

		if(answer == JOptionPane.YES_OPTION){
			System.exit(0);
		}else if(answer == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "잘했어요 나가지마요");
		}else{ //CANCEL_OPTION
			JOptionPane.showMessageDialog(null, "나가");
		}
			
		}
		
		/*
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
		}*/
	}
	void setUI()
	{
		setTitle("JOptionPane");
		setSize(400, 300);
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) 
	{
		Ui ui = new Ui();
		ui.init();
	}
}
