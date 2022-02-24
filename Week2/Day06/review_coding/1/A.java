import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A extends JFrame {
    JButton b;

    void init() {
        b = new JButton("자바의버튼");
        /*
         * ActionListener listener = new ActionListener(){
         * public void actionPerformed(ActionEvent e){
         * b.setText("이벤트발생");
         * }
         */
        ActionListener listener = (e) -> {
            b.setText("람다식 이벤트 처리");
        };
        b.addActionListener(listener);
        add(b);
        setUI();
    }

    void setUI() {
        setTitle("GUI Test");
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