class E 
{
	/*
	1) 산술 ex) +, -, *, /, %
	2) 증감 ex) ++, -- 
	3) 대입 ex) = 
	4) 산술대입 ex) +=, -=, *=, /=, %=
	5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
	6) 비교 ex) ==, !=, <, <=, >, >=
	7) 논리 ex) &, &&, |, ||
	8) 논리대입 ex) &=, |=
	9) 조건 ex) A? B:C
	10) instanceof  ex) 객체 instanceof 클래스 */

	void m1(){ //1) 산술 ex) +, -, *, /, %
		int i = 1;
		int j = 2;
		int k = i%j;
        pln("k: " + k);
	}
	void m2(){ //2) 증감 ex) ++, --
		int i = 0;
		int j = i++;//연산자우선순위 
		pln("i: " + i + ", j: " + j);

		int k = (j++ + 1);
		pln("j: " + j + ", k: " + k);
	}
	void m3(){ //4) 산술대입 ex) +=, -=, *=, /=, %=
		int i = 1;
		i %= 2;
		pln("i: " + i);
	}
	void m4(){ //5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
		int i = 8;
        i = i>>2;
		System.out.println("i: " + i);

		int j = 4;  //0100
		int k = 12; //1100
		int m = j&k;
        System.out.println("m: " + m);
	}
	void m5(){ //6) 비교 ex) ==, !=, <, <=, >, >=
		int i = 0;
		//boolean flag = i!=0;
		boolean flag = i>(i-1);
		System.out.println("flag: " + flag);
	}
	void m6(){ //7) 논리 ex) &, &&, |, ||
		int i = 0;
		int j = 2;
		boolean flag = (++i==1) | (i==j--); 
		System.out.println("j: " + j);
	}
	void m7(){ //8) 논리대입 ex) &=, |=
		boolean b = false;
		b |= true;	
		System.out.println("b : " + b); 
	}
	void m8(){ //9) 조건 ex) A? B:C
		int i = 1;
		int j = 2;
		String k = i>j? "여성": "남성";
		/*String k = "";
		if(i>j) {
			k = "여성";
		}else {
			k = "남성";
		}*/
		System.out.println("k: " +k);
	}
	void m9(){ //10) instanceof  ex) 객체 instanceof 클래스
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
		E e = new E();
		//e.m1();
		//e.m2();
		//e.m3();
		//e.m4();
		//e.m5();
		//e.m6();
		//e.m7();
		//e.m8();
		e.m9();
	}
}
