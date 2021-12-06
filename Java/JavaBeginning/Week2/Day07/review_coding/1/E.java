class E 
{

	void m1(){
		int i=1;
		int j=2;
		int k=i%j;
		pln("k: "+k);
	}

	void m2(){
		int i=0;
		int j=i++;
		pln("i: "+i+", j: "+j);

		int k=(j++ + 1);
		pln("j: "+j+", k: "+k);
	}

	void m3(){
		int i=1;
		i%=2;
		pln("i: "+i);
	}

	void m4(){
		int i=8;
		i =i>>2;
		pln("i: "+i);

		int j=4;
		int k=12;
		int m=j&k;
		pln("m: "+m);
	}

	void m5(){
		int i=0;
		boolean flag =i>(i-1);
		pln("flag: "+flag);
	}

	void m6(){
		int i=0;
		int j=2;
		boolean flag = (++i==1)|(i==j--)l;
		pln("j: "+j);
	}

	void m7(){
		boolean b = false;
		b|=true;
		pln("b: "+b);
	}

	void m8(){
		int i=1;
		int j=2;
		String k=i>j? "여성":"남성";
		pln("k: "+k);
	}

	void m9(){
		String str = "김치";
		boolean flag1 = str instanceof Object;
		pln("flag1: "+flag1);

		Object obj = new Object();
		boolean flag2 = ojb instanceof String;
		pln("flag2: "+flag2);
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		E e = new E();
		e.m1();
		e.m2();
		e.m3();
		e.m4();
		e.m5();
		e.m6();
		e.m7();
		e.m8();
		e.m9();
	}
}
