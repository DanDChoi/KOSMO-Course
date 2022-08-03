/* 가능 
class D0{
	class D1{
		class D2{
			class D3{
			}
		}
	}
}
*/
/* 가능 
class D0 {
	interface D1{
	}
}
*/
/* 가능 
interface D0{
	class D1{
	}
}
*/
interface D0 {
	interface D1 {
		void m1();
	}
	static interface D2 {
		void m2();
	}
}
class D1Child implements D0.D1 {
	public void m1(){
		System.out.println("m1()");	
	}
}
class D2Child implements D0.D2 {
	public void m2(){
		System.out.println("m2()");	
	}
}

class D {
	public static void main(String[] args) {
		D0.D1 d1 = new D1Child();
		d1.m1();

		D0.D2 d2 = new D2Child();
		d2.m2();
	}
}
