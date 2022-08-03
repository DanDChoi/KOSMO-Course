class F2 extends Thread { 
	F2(){
		start();

		for(int i=0; i<10; i++){
			System.out.println("main");
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println("Thread");
			try{
				Thread.sleep(700);
			}catch(Exception e){}
		}
	}
	public static void main(String[] args) { 
		new F2();
	}
}
