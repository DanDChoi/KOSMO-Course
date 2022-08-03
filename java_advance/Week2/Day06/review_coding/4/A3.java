import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3 extends JFrame{
    JButton b;
    void init(){
        b= new JButton("자바 버튼");
        /*
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b.setText("이벤트!");
            }
        }
        */
        ActionListener listener = (e) -> {
            b.setText("람다식 이벤트처리");
        };
        b.addActionListener(listener);
        add(b);

        setUI();

    }
    void setUI(){
        setTitle("GUI Test ver 1.00");
        setSize(300, 200);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        A3 a = new A3();
        a.init();
    }
}