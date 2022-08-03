import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Grid Layout
class C extends JFrame{
    Container cp;
    JButton b1, b2, b3, b4, b5, b6;

    void init() {
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");
        b5 = new JButton("Button5");
        b6 = new JButton("Button6");

        cp = getContentPane();
        cp.setLayout(new GridLayout(2, 3));
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(b4);
        cp.add(b5);
        cp.add(b6);
        setUI();
    }
    void setUI(){
        setTitle("GridLayout Test");
        setSize(400, 300);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public static void main(String[] args) {
    C c = new C();
    c.init();
    }

}