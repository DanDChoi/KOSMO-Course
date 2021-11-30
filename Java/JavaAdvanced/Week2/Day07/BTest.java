import java.awt.*;
import javax.swing.*;
import java.net.*;

class BTest extends JFrame {
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
        //ii1 = new ImageIcon(getClass().getResource("imgs/meme.jpeg"));
        //ii2 = new ImageIcon(getClass().getResource("imgs/meme1.jpeg"));
        //ii3 = new ImageIcon(getClass().getResource("imgs/meme2.jpeg"));
        //la1 = new JLabel(ii1);
        //la2 = new JLabel(ii2);
        //la3 = new JLabel(ii3);

        ImageIcon ii1 = new ImageIcon("imgs/meme.jpeg");
        Image img = ii1.getImage();
        Image changeImage = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel la1 = new JLabel(changeIcon);

        ImageIcon ii2 = new ImageIcon("imgs/meme1.jpeg");
        Image img2 = ii2.getImage();
        Image changeImage2 = img2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImage2);
        JLabel la2 = new JLabel(changeIcon2);

        ImageIcon ii3 = new ImageIcon("imgs/meme2.jpeg");
        Image img3 = ii3.getImage();
        Image changeImage3 = img3.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImage3);
        JLabel la3 = new JLabel(changeIcon3);

        p.add(la1);  p.add(la2); p.add(la3); 
        
        ii = new ImageIcon(getClass().getResource("imgs/meme3.jpeg"));
        b = new JButton(ii);
        cp.add(b, BorderLayout.NORTH);
        cp.add(p);
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
        BTest b = new BTest();
        b.init();
    }
}