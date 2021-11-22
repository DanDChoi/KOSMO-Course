class H1 extends Thread {
	public void run(){
		for(int i=0; i<10000; i++){
			System.out.println("H1 i: " + i);
		}
	}
}
class H2 extends Thread{
	public void run(){
		for(int i=0; i<10000; i++){
			System.out.println("H2 i: " + i);
		}
	}
}

class H {
	H(){
		H1 th1 = new H1();
		th1.setPriority(Thread.MIN_PRIORITY);
		th1.start();

		H2 th2 = new H2();
		th2.setPriority(Thread.MAX_PRIORITY);
		th2.start();
	}
	/*
	void m1(){
		System.out.println("MAX_PRIORITY: " + Thread.MAX_PRIORITY);
		System.out.println("MIN_PRIORITY: " + Thread.MIN_PRIORITY);
		System.out.println("NORM_PRIORITY: " + Thread.NORM_PRIORITY);
	}
	void m2(){
		int i1 = this.getPriority(); //조회 
		System.out.println("i1: " + i1);

		this.setPriority(Thread.MAX_PRIORITY); //셋팅 
		int i2 = this.getPriority();
		System.out.println("i2: " + i2);
	}
	public void run(){
		m2();
	}
	*/
	public static void main(String[] args) 
	{
		H h = new H();
		//h.m1();
	}
}
