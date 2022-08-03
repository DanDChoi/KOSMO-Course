import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class D extends JFrame 
{
	JTable t;
	/*String columnNames[] = {"번호", "이름", "날짜"};
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
	};*/
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
        Container cp = getContentPane();
		//t = new JTable(rowData, columnNames); //고정배열
		t = new JTable(rowData, columnNames); //가변배열

		JScrollPane sp = new JScrollPane(t); 
        cp.add(sp);

		setUI();
		test();
	}
	void test(){
		//(1) 임의의 데이터 ( set / get )
		t.setValueAt("신병철", 0, 1);
		Object data = t.getValueAt(2, 1);
        pln("data: " + data);

        //(2) 갯수 
		int rc = t.getRowCount();
		int cc = t.getColumnCount();
		pln("rc: " + rc + ", cc: "+ cc);

		//(3) 컬럼 이름 
		String cn = t.getColumnName(1);
		pln("cn: " + cn);
	}
	void setUI(){
		setTitle("JTable Test1");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null); //해상도 관계없이 화면의 가운데 띄워줌 
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
