import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class C extends JFrame 
{
	JTable t;
	String columnNames[] = {"��ȣ", "�̸�", "��¥"};
	String rowData[][] = {
		{"10", "ȫ�浿", "21/01/05"},   
		{"20", "�̼���", "21/01/05"},
		{"30", "������", "21/01/05"}, 
		{"40", "ȫ�浿", "21/01/05"}, 
		{"50", "�̼���", "21/01/05"},
		{"60", "������", "21/01/05"}, 
		{"70", "ȫ�浿", "21/01/05"}, 
		{"80", "�̼���", "21/01/05"},
		{"90", "������", "21/01/05"}
	};
	
	void init(){
        Container cp = getContentPane();
		t = new JTable(rowData, columnNames);
		JScrollPane sp = new JScrollPane(t); 
        cp.add(sp);

		setUI();
		test();
	}
	void test(){
		//(1) ������ ������ ( set / get )
		t.setValueAt("�ź�ö", 0, 1);
		Object data = t.getValueAt(2, 1);
        pln("data: " + data);

        //(2) ���� 
		int rc = t.getRowCount();
		int cc = t.getColumnCount();
		pln("rc: " + rc + ", cc: "+ cc);

		//(3) �÷� �̸� 
		String cn = t.getColumnName(1);
		pln("cn: " + cn);
	}
	void setUI(){
		setTitle("JTable Test1");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null); //�ػ� ������� ȭ���� ��� ����� 
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
