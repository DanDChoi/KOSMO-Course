class  E1
{
	void m1(){ // 산술 
		int i = 1;
		int j = 2;
		int k = i%j;
        pln("k: " + k);
	}
	void m2(){ // 증감 
		int i = 0;
		int j = i++;
		pln("i: " + i + ", j: " + j);

		int k = (j++ + 1);
		pln("j: " + j + ", k: " + k);
	}
	void m3(){ // 산술대입 
		int i = 1;
		i %= 2;
		pln("i: " + i);
	}
	void m4(){ // 비트
		int i = 8;
        i = i>>2;
		System.out.println("i: " + i);

		int j = 4;  
		int k = 12; 
		int m = j&k;
        System.out.println("m: " + m);
	}
	void m5(){ // 비교 
		int i = 0;
		boolean flag = i>(i-1);
		System.out.println("flag: " + flag);
	}
	void m6(){ // 논리 
		int i = 0;
		int j = 2;
		boolean flag = (++i==1) | (i==j--); 
		System.out.println("j: " + j);
	}
	void m7(){ // 논리대입
		boolean b = false;
		b |= true;	
		System.out.println("b : " + b); 
	}
	void m8(){ // 조건 
		int i = 1;
		int j = 2;
		String k = i>j? "여성": "남성";
		String k = "";
		System.out.println("k: " +k);
	}
	void m9(){ // instanceof 
        String str = "김치";
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
