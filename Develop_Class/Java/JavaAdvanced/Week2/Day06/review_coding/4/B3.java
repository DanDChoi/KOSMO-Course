import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B3 extends JFrame {
    Container cp;
    JButton bE, bW, bS, bN, bC, bWpN, bEpN, bCpC;
    JPanel pN, pC;

    void init(){
        pN = new JPanel();
        pN.setLayout(new BorderLayout());
        bWpN = new JButton("서쪽at북패널");
        bEpN = new JButton("동쪽at북패널");
        pN.add(bWpN, BorderLayout.WEST);
        pN.add(bEpN, BorderLayout.EAST);

        pC = new JPanel();
        pC.setLayout(new BorderLayout());
        bCpC = new JButton("입력창");
        pc.add(bCpC, BorderLayout.SOUTH);

        bE = new JButton("동쪽");
        bW = new JButton("서쪽");
        bS = new JButton("남쪽");
        bN = new JButton("북쪽");
        pN.add(bN);
        bC = new JButton("모니터창");
        pC.add(bC);

        cp = getContentPane();
        cp.add(bE, BorderLayout.EAST);
        cp.add(bW, BorderLayout.WEST);
        cp.add(bS, BorderLayout.SOUTH);
        cp.add(pN, BorderLayout.NORTH);
        cp.add(pC, BorderLayout.CENTER);

        setUI();
    }
    void setUI(){
        setTitle("BorderLayout");
        setSize(400, 300);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);\
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args){
        B3 b = new B3();
        b.init();
    }
}