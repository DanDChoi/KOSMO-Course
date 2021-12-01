import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B4 extends JFrame implements ActionListener{

    Container cp;
    JFileChooser fc = new JFileChooser(".");
    JButton b;
    
    void init(){
        cp = getContentPane();
        b = new JButton("click");
        b.addActionListener(this);
        cp.add(b);

        setUI();
    }
    void setUI(){
        setTitle("JFileChooser testing");
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj == b){
            int i = fc.showOpenDialog(this); //1
            //int i = fc.showSaveDialog(this); //2
            switch(i){
                case JFileChooser.CANCEL_OPTION: break;
                case JFileChooser.APPROVE_OPTION: break;
                //1
                //2
                case JFileChooser.ERROR_OPTION: break;
            }
        }
    }
    public static void main(String[] args){
        new B4().init();
    }
}