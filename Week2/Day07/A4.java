import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//패턴4 : 셀프 이벤트 처리모델
class A4 extends JFrame implements ActionListener {
    JButton b;

    void init() {
        b = new JButton("버튼");
        b.addActionListener(this);
        add(b);

        setUI();
    }

    void setUI() {
        setTitle("Event Handling 4");
        setSize(300, 200);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        b.setText("클릭됨 by 자신의 객체");
    }

    public static void main(String[] args) {
        A4 a = new A4();
        a.init();
    }
}
