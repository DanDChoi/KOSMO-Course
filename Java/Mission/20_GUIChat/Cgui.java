
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Cgui extends JFrame implements ActionListener {
	// 새로운 클라이언트가 만들어지면, 여기 클라이언트 GUI콘솔에서 nickname을 서버 백그라운드에 넘기면
	// 내부 Receiver클래스 생성자에서 받는다
	private static final long serialVersionUID = 1L;
	private JTextField jtf;
	private JTextArea jta;
	private static String nickName;

	private Ct ct = new Ct();

	public Cgui() {
		setTitle("Client");
		setBounds(300, 100, 200, 200);
		jta = new JTextArea(40, 25);
		jtf = new JTextField(25);
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		jtf.addActionListener(this);
		ct.setCgui(this);
		// 클라이언트 백그라운드와 통신을 위한 여기 객체 주소 넘기고,
		ct.setNickName(nickName);
		// 여기 클라이언트 GUIman()메서드에 입력한 nickname을 클라이언트 백그라운드에 넘기고
		ct.connect();
		// 클라이언트 백그라운드 구동시키고
	}

	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Set to here your nickname!: ");
		nickName = scanner.nextLine();
		scanner.close();
		new Cgui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = nickName + ":" + jtf.getText() + "/n";
		ct.sendMessage(msg); // 여기서 입력한 메시지를 클라이언트 백그라운드에 보냄
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}
}