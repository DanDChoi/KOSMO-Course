class B3
{
	int i;
	B3(int i){//�Ķ����
		System.out.println("i1: "+ i);
		this.i = i;
	}
	void m(){
		System.out.println("i2; "+ i);
		int j = 1000; //����
		System.out.println("j: " +j);
	}
	public static void main(String[] args) 
	{
		B3 b3 = new B3(2);
		b3.m();
	}
}
