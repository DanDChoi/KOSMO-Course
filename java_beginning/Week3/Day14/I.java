class Ith1 extends Thread {
	public void run(){
		I.m();
	}
}
class Ith2 extends Thread {
	public void run(){
		I.m();
	}
}

class I {
	static int i;
	I(){
		Thread th1 = new Ith1();
		Thread th2 = new Ith2();
		th1.start();
		th2.start();
		
		try{
			th1.join();
			th2.join();
		}catch(InterruptedException ie){}

		System.out.println("i: " + i);
	}
	synchronized static void m(){
		for(int j=0; j<1000000; j++){
			i++;
		}
	}
	
	void m2(){
		System.out.println("�Ϲݷ���");
		synchronized(this){
			System.out.println("����ȭ�� �ʿ��� ����");
		}
	} 
	public static void main(String[] args) {
		new I();
	}
}
