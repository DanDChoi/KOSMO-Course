import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B extends JFrame implements ActionListener {
	Container cp;
	JFileChooser fc = new JFileChooser(".");
	JButton b;

	void init() {
		cp = getContentPane();
		b = new JButton("클릭");
		b.addActionListener(this);
		cp.add(b);

		setUI();
	}

	void setUI() {
		setTitle("JFileChooser Testing");
		setSize(400, 300);
		setVisible(true);
		// setLocation(200, 100);
		setLocationRelativeTo(null); // 해상도와 관계없이 화면의 가운데에 띄움

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b) {
			int i = fc.showOpenDialog(this); // (1)
			// int i = fc,showSaveDialog(this); //(2)
			switch (i) {
			case JFileChooser.CANCEL_OPTION:
				break;
			case JFileChooser.APPROVE_OPTION:
				// (1)지정된 파일을 읽어서 JTextPane에 뿌린다
				// (2)JTextPane에 있는 문자들을 지정된 파일에 쓴다
				break;
			case JFileChooser.ERROR_OPTION:
				break;
			}
		}
	}

	public static void main(String[] args) {
		new B().init();
	}
}

//JFileChooser
//JTextPane 
//JScrollPane
//JButton 