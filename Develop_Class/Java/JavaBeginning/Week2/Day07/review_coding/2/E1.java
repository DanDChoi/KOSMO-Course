class  E1
{
	void m1(){ // ��� 
		int i = 1;
		int j = 2;
		int k = i%j;
        pln("k: " + k);
	}
	void m2(){ // ���� 
		int i = 0;
		int j = i++;
		pln("i: " + i + ", j: " + j);

		int k = (j++ + 1);
		pln("j: " + j + ", k: " + k);
	}
	void m3(){ // ������� 
		int i = 1;
		i %= 2;
		pln("i: " + i);
	}
	void m4(){ // ��Ʈ
		int i = 8;
        i = i>>2;
		System.out.println("i: " + i);

		int j = 4;  
		int k = 12; 
		int m = j&k;
        System.out.println("m: " + m);
	}
	void m5(){ // �� 
		int i = 0;
		boolean flag = i>(i-1);
		System.out.println("flag: " + flag);
	}
	void m6(){ // �� 
		int i = 0;
		int j = 2;
		boolean flag = (++i==1) | (i==j--); 
		System.out.println("j: " + j);
	}
	void m7(){ // ������
		boolean b = false;
		b |= true;	
		System.out.println("b : " + b); 
	}
	void m8(){ // ���� 
		int i = 1;
		int j = 2;
		String k = i>j? "����": "����";
		String k = "";
		System.out.println("k: " +k);
	}
	void m9(){ // instanceof 
        String str = "��ġ";
		boolean flag1 = str instanceof Object;
		System.out.println("flag1: " + flag1);

		Object obj = new Object();
		boolean flag2 = obj instanceof String;
		System.out.println("flag2: " + flag2);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		E1 e1 = new E1();
		e1.m1();
		e1.m2();
		e1.m3();
		e1.m4();
		e1.m5();
		e1.m6();
		e1.m7();
		e1.m8();
		e1.m9();
	}
}
