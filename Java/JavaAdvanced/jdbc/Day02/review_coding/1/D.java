import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class D extends JFrame{
    JTable t;
    Vector<String> columnNames;
    Vector<Vector> rowData;

    D(){
        columnNames = new Vector<String>();
        columnNames.add("번호");
        columnNames.add("이름");
        columnNames.add("날짜");

        rowData = new Vector<Vector>();
        Vector<String> v1 = new Vector<String>();
        v1.add("10"); v1.add("홍길동"); v1.add("21/01/05");
        Vector<String> v2 = new Vector<String>();
        v2.add("20"); v2.add("이순신"); v2.add("21/01/05");
        Vector<String> v3 = new Vector<String>();
        v3.add("30"); v3.add("강감찬"); v3.add("21/01/05");
        Vector<String> v4 = new Vector<String>();
        v4.add("40"); v4.add("을지문덕"); v4.add("21/01/05");

        rowData.add(v1);rowData.add(v2);rowData.add(v3);rowData.add(v4);
    }

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
        new D().init();
    }
}