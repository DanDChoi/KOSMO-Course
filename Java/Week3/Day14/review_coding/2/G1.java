class Gth1 extends Thread { 
	@Override
	public void run(){
		while(true){
			System.out.println("서빙을 한다");	
			try{ 
				Thread.sleep(2000); 
			}catch(InterruptedException e){}
		}
	}
}
class Gth2 implements Runnable { 
	@Override
	public void run() {
		try{
			while(true){
				System.out.println("요리를 한다");
				Thread.sleep(2000); 
			}
		}catch(InterruptedException e){}
	}
}
class G1 {
	void mainW(){
		Thread th11 = new Gth1();
		th11.start();
		Thread th12 = new Gth1();
		th12.start();

		Runnable r = new Gth2();
		Thread th2 = new Thread(r);
		th2.start();

		while(true){
			System.out.println("사장님이 계산을 한다");
			try{ 
				Thread.sleep(3000); 
			}catch(InterruptedException e){}
		}
	}
	public static void main(String[] args) 
	{
		new G1().mainW();
	}
}