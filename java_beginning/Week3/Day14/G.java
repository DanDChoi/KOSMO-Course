class Gth1 extends Thread { //���1
	@Override
	public void run(){
		while(true){
			System.out.println("������ �Ѵ�");	
			try{ 
				Thread.sleep(2000); 
			}catch(InterruptedException e){}
		}
	}
}
class Gth2 implements Runnable { //���2
	@Override
	public void run() {
		try{
			while(true){
				System.out.println("�丮�� �Ѵ�");
				Thread.sleep(2000); 
			}
		}catch(InterruptedException e){}
	}
}
class G {
	void mainW(){
		Thread th11 = new Gth1();
		th11.start();
		Thread th12 = new Gth1();
		th12.start();

		Runnable r = new Gth2();
		Thread th2 = new Thread(r);
		th2.start();

		while(true){
			System.out.println("������� ����Ѵ�");
			try{ 
				Thread.sleep(3000); 
			}catch(InterruptedException e){}
		}
	}
	public static void main(String[] args) 
	{
		new G().mainW();
	}
}
