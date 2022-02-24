import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swting.*;

class C extends JFrame{
    JTable t;
    String columnNames[] = {"번호", "이름", "날짜"};
    String rowData[][] = {
        {"10", "홍길동", "21/01/05"},
        {"20", "이순신", "21/01/05"},
        {"30", "강감찬", "21/01/05"},
        {"40", "홍길동", "21/01/05"},
        {"50", "이순신", "21/01/05"},
        {"60", "강감찬", "21/01/05"},
        {"70", "홍길동", "21/01/05"},
        {"80", "이순신", "21/01/05"},
        {"90", "강감찬", "21/01/05"}
    };

    void init(){
        Contrainer cp = getContentPane();
        t = new JTable(rowData, columnNames);
        JScrollPane sp = new JScrollPane(t);
        cp.add(sp);

        setUI();
        test();
    }
    void test(){
        t.setValueAt("신병철", 0, 1);
        Object data = t.getValueAt(2, 1);
        pln("data:"+data);

        int rc = t.getRowCount();
        int cc = t.getColumnCount();
        pln("rc:"+rc+",cc"+cc);

        String cn = t.getColumnName(1);
        pln("cn:"+cn);
    }
    void setUI(){
        setTitle("JTable Test1");
        setSize(500, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String[] args){
        new C().init();
    }
}