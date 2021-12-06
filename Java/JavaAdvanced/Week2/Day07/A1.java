import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//패턴1: 유명내부클래스
class A1 extends JFrame {
    JButton b;

    class MyHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            b.setText("클릭됨 by 유명내부클래스");
        }
    }

    void init() {
        b = new JButton("버튼");
        b.addActionListener(new MyHandler());
        add(b);

        setUI();
    }

    void setUI() {
        setTitle("Event Handling 1");
        setSize(300, 200);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        A1 a = new A1();
        a.init();
    }
}
