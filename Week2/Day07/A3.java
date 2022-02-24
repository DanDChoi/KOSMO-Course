import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//패턴3: 제3클래스
class A3 extends JFrame {
    JButton b;

    void init() {
        b = new JButton("버튼");
        b.addActionListener(new MyHandler(this));
        add(b);

        setUI();
    }

    void setUI() {
        setTitle("Event Handling 3");
        setSize(300, 200);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        A3 a = new A3();
        a.init();
    }
}
class MyHandler implements ActionListener {
    A3 a3;
    MyHandler(A3 a3){
        this.a3 = a3;
    }
    public void actionPerformed(ActionEvent e) {
        //Object obj = e.getSource();
        //JButton b = (JButton)obj;  // 괄호안에 들어간이유?
        a3.b.setText("클릭됨 by 제3클래스");
        a3.setTitle("타이틀 변경가능");
        a3.setSize(400, 300);
    }
}
