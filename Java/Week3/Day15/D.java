class RunChild implements Runnable {
	public void run(){
		while(true){
			System.out.println("쓰레드의 일1");
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
}

class D {
	void use(){
		//방식1
		//Runnable r = new RunChild();
		//Thread th = new Thread(r);

		//방식2
		/*Runnable r = new RunChild(){
			public void run(){
				while(true){
					System.out.println("쓰레드의 일2");
					try{
						Thread.sleep(1000);
					}catch(Exception e){}
				}
			}
		};
		Thread th = new Thread(r);
		*/

        //방식3
		/*Runnable r = () -> {
			while(true){
				System.out.println("쓰레드의 일3");
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			}
		};
		Thread th = new Thread(r);*/
		//th.start();


		new Thread(() -> {
			while(true){
				System.out.println("쓰레드의 일3");
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			}
		}).start();
	}
	public static void main(String[] args) {
		D d = new D();
		d.use();
	}
}
