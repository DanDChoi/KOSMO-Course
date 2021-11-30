import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

class Gui extends JFrame implements ActionListener {
    Container cp;
    JButton bE, bW, bS, bN, bC, b;
    JPanel pC;
    JLabel la1, la2, la3, la4;
    ImageIcon ii1, ii2, ii3, ii4;

    void init() {

        bE = new JButton("동쪽");
        bW = new JButton("서쪽");
        bS = new JButton("남쪽");
        bN = new JButton("북쪽");
        pC = new JPanel(new GridLayout(2, 2));

        //pC.setBackground(Color.WHITE);

        cp = getContentPane();
        cp.add(bE, BorderLayout.EAST);
        cp.add(bW, BorderLayout.WEST);
        cp.add(bS, BorderLayout.SOUTH);
        cp.add(bN, BorderLayout.NORTH);
        cp.add(pC, BorderLayout.CENTER);

        /*
         * ii1 = new ImageIcon(getClass().getResource("imgs/smile.png"));
         * ii2 = new ImageIcon(getClass().getResource("imgs/crying.png"));
         * ii3 = new ImageIcon(getClass().getResource("imgs/mad.png"));
         * ii4 = new ImageIcon(getClass().getResource("imgs/think.png"));
         * la1 = new JLabel(ii1);
         * la2 = new JLabel(ii2);
         * la3 = new JLabel(ii3);
         * la4 = new JLabel(ii4);
         */
        ImageIcon ii1 = new ImageIcon("imgs/smile.png");
        Image img1 = ii1.getImage();
        Image changeImage = img1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel la1 = new JLabel(changeIcon);

        ImageIcon ii2 = new ImageIcon("imgs/crying.png");
        Image img2 = ii2.getImage();
        Image changeImage2 = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImage2);
        JLabel la2 = new JLabel(changeIcon2);

        ImageIcon ii3 = new ImageIcon("imgs/think.png");
        Image img3 = ii3.getImage();
        Image changeImage3 = img3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImage3);
        JLabel la3 = new JLabel(changeIcon3);

        ImageIcon ii4 = new ImageIcon("imgs/mad.png");
        Image img = ii4.getImage();
        Image changeImage4 = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon changeIcon4 = new ImageIcon(changeImage4);
        JLabel la4 = new JLabel(changeIcon4);

        pC.add(la1);
        pC.add(la2);
        pC.add(la3);
        pC.add(la4);

        bE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(
                        null, "재밌나요?", "질문",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                // System.out.println("answer: " + answer);

                if (answer == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "ㅋ 재밌군요!!");
                } else if (answer == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "ㅠ 노잼!!");
                } else { // CANCEL_OPTION
                    JOptionPane.showMessageDialog(null, "아.. 대답도 싫군요!!");
                }
            }
        });

        setUI();
    }
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
        
    

    void setUI() {
        setTitle("GUI TEST");
        setSize(500, 400);
        setLocation(200, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Gui g = new Gui();
        g.init();
    }

  
}