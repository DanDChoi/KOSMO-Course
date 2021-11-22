interface Inter1 {
	int I = 10;
	void m1();
} 
interface Inter2 {
	void m2();
} 
interface Inter extends Inter1, Inter2 {
	void m3();
}

class Child implements Inter
{
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){
		System.out.println("m2()");
	}
	public void m3(){
		System.out.println("m3()");
	}
}

class G {
	public static void main(String[] args) 
	{
		Child c = new Child();
		Inter it = c;
		Inter1 it1 = it; 
		Inter2 it2 = it;

		System.out.println("it.I: " + it.I);
		it.m1();
		it.m2();
		it.m3();

        System.out.println("Inter1.I: " + Inter1.I);
		it1.m1();

		it2.m2();
	}

}

