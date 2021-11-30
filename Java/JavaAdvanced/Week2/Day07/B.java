import java.awt.*;
import javax.swing.*;
import java.net.*;

class B extends JFrame {
    Container cp;
    JLabel la1, la2, la3;
    JPanel p;
    JButton b;
    ImageIcon ii, ii1, ii2, ii3;

    void init() {
        cp = getContentPane();

        /*
        Class c = this.getClass();
        URL url = c.getResource("imgs/");
        ImageIcon ii = new ImageIcon(url);
        la = new JLabel(ii);
        cp.add(la);
        */
        
        p = new JPanel(new GridLayout(1, 3));
        ii1 = new ImageIcon(getClass().getResource("imgs/meme.jpeg"));
        ii2 = new ImageIcon(getClass().getResource("imgs/meme1.jpeg"));
        ii3 = new ImageIcon(getClass().getResource("imgs/meme2.jpeg"));
        la1 = new JLabel(ii1);
        la2 = new JLabel(ii2);
        la3 = new JLabel(ii3);
        p.add(la1);  p.add(la2); p.add(la3); 
        
        ii = new ImageIcon(getClass().getResource("imgs/meme3.jpeg"));
        b = new JButton(ii);
        cp.add(p, BorderLayout.NORTH);
        cp.add(b);
        setUI();
    }
    void setUI() {
        setTitle("Image Test");
        //setSize(600, 500);
        pack();
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args){
        B b = new B();
        b.init();
    }
}