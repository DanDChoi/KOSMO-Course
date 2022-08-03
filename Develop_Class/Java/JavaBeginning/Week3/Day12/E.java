class E 
{
	final int i = 10;
	//final E(){}
	final void m(){
		System.out.println("E m()");
	}
}
class EChild extends E
{
	EChild(){
		i = 20; //상수
	}
	void m(){ //Overriding X 
		System.out.println("EChild m()");
	}
}
