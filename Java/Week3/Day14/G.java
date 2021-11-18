class Gth1 extends Thread { //방법1
	@Override
	public void run(){
		System.out.println("child1 쓰레드 일");	
	}
}
class Gth2 implements Runnable { //방법2
	@Override
	public void run(){
		System.out.println("child2 쓰레드 일");	
	}
}
class G 
{
	void mainW(){
		Thread th1 = new Gth1();
		th1.start();

		Runnable r = new Gth2();
		Thread th2 = new Thread(r);
		th2.start();

		System.out.println("main쓰레드 일");
	}
	public static void main(String[] args) 
	{
		new G().mainW();
	}
}
