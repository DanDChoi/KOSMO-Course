class F extends Thread { //MultiThread 
	F(){
		start();

		for(int i=0; i<10; i++){
			System.out.println("main�� ��");
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println("�ڽ�Thread ��");
			try{
				Thread.sleep(700);
			}catch(Exception e){}
		}
	}
	public static void main(String[] args) { //SingleThread 
		new F();
	}
}
