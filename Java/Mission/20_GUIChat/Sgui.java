
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sgui extends JFrame implements ActionListener {
   private JTextField jtf;
   private JTextArea jta;
   private Sv sv = new Sv();

   public Sgui() throws IOException {
      setTitle("Server");
      setBounds(100, 100, 200, 200);
      jtf = new JTextField(25);
      jta = new JTextArea(40, 25);
      add(jta, BorderLayout.CENTER);
      add(jtf, BorderLayout.SOUTH);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);

      jtf.addActionListener(this);
      // TextField에서 글을 쓴것을(jtf),
      // 감지하면(addActionListener()),
      // this 여기 actionPerformed() 메서드에서 처리하라,
      // 다른 클래스로 가지말고..
      sv.setSg(this);
      // 서버GUI와 통신하기 위하여, 여기 객체주소를 서버 백그라운드에 넘김
      sv.setting();
   }

   public static void main(String[] args) {
      try {
         new Sgui();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String msg = "server: " + jtf.getText() + "\n";
      sv.sendMessage(msg);
      // 여기 서버 GUI에서 작성한 메세지를 각각의 클라이언트에 보내기위함, 클라이언트 없으면 안보내고..
      jtf.setText("");
   }

   public void appendMsg(String msg) {
      jta.append(msg);
   }

}
//JTextArea = 채팅창 (비활성해야함)
//JScrollPane = 채팅창 스크롤 
//JTextField = 아이디입력창, 채팅입력창
//JLabel = 아이디 입력창 왼쪽 "MY ID" 부분
//JButton = 입,퇴장 버튼 (없어도 됨, 엔터를 쳐도 입장 가능)