import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Card Layout
class D extends JFrame{
    Container cp;
    String labels[] = {"도","레","미","파","솔","라","시"};
    JButton bs[];
    D(){
        bs = new JButton[labels.length];

    }

    void init() {
        cp = getContentPane();
        cp.setLayout(new CardLayout());

        ActionListener listener = (e) -> {
            Object obj = e.getSource();
            /*
            if(obj == bs[0]){
                cp.remove(bs[0]);
            }else if(obj == bs[1]){
                cp.remove(bs[1]);
            }else if(obj == bs[2]){
                cp.remove(bs[2]);
            }else if(obj == bs[3]){
                cp.remove(bs[3]);
            }else if(obj == bs[4]){
                cp.remove(bs[4]);
            }else if(obj == bs[5]){
                cp.remove(bs[5]);
            }else if(obj == bs[6]){
                cp.remove(bs[6]);
            }else{
                cp.remove(bs[7]);
            }*/
            cp.remove((JButton)obj); //jbutton이 괄호 안에 있는 이유?
            revalidate();
            repaint();
		};

        for(int i=0; i<bs.length; i++){
            bs[i] = new JButton(labels[i]);
            cp.add(bs[i]);
            bs[i].addActionListener(listener);
        }
        
        setUI();
    }
    void setUI(){
        setTitle("CardLayout Test");
        setSize(400, 300);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public static void main(String[] args) {
    D d = new D();
    d.init();
    }

}