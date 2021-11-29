import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B extends JFrame{
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
        pC.add(bCpC, BorderLayout.SOUTH);

        bE = new JButton("동쪽");
        bW = new JButton("서쪽");
        bS = new JButton("남쪽");
        bN = new JButton("북쪽");
        pN.add(bN);
        bW = new JButton("서쪽");
        pC.add(bC);
    }
    void setUI(){

    }
    public static void main(String[] args){
        B b = new B();
        b.init();
    }

}