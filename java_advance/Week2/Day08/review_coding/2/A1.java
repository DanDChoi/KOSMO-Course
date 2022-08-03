import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame{
    Container cp;
    ImageIcon ii;
    JLabel laImg, laMsgT, laMsgB;
    JPanel p;

    void init(){
        cp = getContentPane();
        ii = new ImageIcon(getClass().getResource("imgs/move.gif"));
        laImg = new JLabel(ii);
        cp.add(laImg);

        p = new JPanel();
        p.setBackground(Color.YELLOW);
        p.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        p.setLayout(new GridLayout(2, 1));
        laMsgT = new JLabel();
        laMsgT.setForeground(Color.blue);
        laMsgT.setText("열심히 달리는 것은 중요하다");
        laMsgB = new JLabel();
        laMsgB.setForeground(Color.red);
        laMsgB.setText("하지만 방향은 더 중요하다");

        Font f = new Font("굴림", Font.BOLD, 23);
        laMsgT.setFont(f);
        laMsgB.setFont(f);
        p.add(laMsgT);
        p.add(laMsgB);

        cp.add(p, BorderLayout.SOUTH);

        setUI();
    }

    void setUI(){
        setTitle("움직이는git testing");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new A1().init();
    }
}