import java.io.*;
import java.util.*;

class Lotto
{
	String fName;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	FileReader fr;
	Vector<String> v = new Vector<String>();
	Random r = new Random();
	
	void inputFName(){
		p("#���� ���� �̸�(�⺻:�츮��): ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			if(fName.length() == 0) fName = "�츮��";
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
			}catch(FileNotFoundException fe){
			System.out.println(fName+"������ ã�� �� ����");
			inputFName();
		}catch(IOException ie){
		}
	}

	void in(){
		try{
			String line = null;
			while((line =brFile.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0) v.add(line);
			}
		}catch(IOException ie){
		}
	}
	void out(){
		for(String name : v) System.out.println(name);
	}
	void select(){
		int i = r.nextInt(v.size()); //0~ (size-1)
		String selector = v.get(i);
		System.out.println("��÷��: " + selector);
	}
	
    void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Lotto lo = new Lotto();
		lo.inputFName(); //(1)����Ʈ�� �����̸��� �Է� �޴´�
		lo.in(); //(2)�����(v)�� �̸����� �ִ´�
		//lo.out(); //(3)������� �̸����� ����غ���
		lo.select(); //(4)������ 1���� �̾Ƽ� ����Ѵ�
	}
}

