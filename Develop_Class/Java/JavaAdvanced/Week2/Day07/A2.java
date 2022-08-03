import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//패턴2: 무명, 익명 클래스
class A2 extends JFrame {
    JButton b;

   

    void init() {
        b = new JButton("버튼");
        /* 방법1
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                b.setText("클릭됨 by 무(익)명 내부클래스");
            }
        });
        */
        /* 방법2
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                b.setText("클릭됨 by 무(익)명 내부클래스");
            }
        };*/
        /* 방법3
        ActionListener listener = (e) -> {
            b.setText("클릭됨 by 무(익)명 내부클래스");
        };
        b.addActionListener(listener);
        */
        //방법4
        b.addActionListener((e) -> {
            b.setText("클릭됨 by 무(익)명 내부클래스");
        });

        add(b);

        setUI();
    }

    void setUI() {
        setTitle("Event Handling 2");
        setSize(300, 200);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        A2 a = new A2();
        a.init();
    }
}
