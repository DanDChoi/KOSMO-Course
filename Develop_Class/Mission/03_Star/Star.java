class Star{

	/*void m1(){							[��������1]
		for (int i = 0; i<4; i++){
			System.out.print("* ");
			}	
		System.out.println();
		for (int j = 0; j<3; j++){
			System.out.print("* ");
			}
		System.out.println();
		for (int a = 0; a<2; a++){
			System.out.print("* ");
			}
		System.out.println();
		for (int b = 0; b<1; b++){
			System.out.print("* ");
			}
	}*/

	void m1(){ //��1234
		for (int i = 0; i<5; i++){
			for (int j = 0; j<i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	void m2(){ //��1234
		for (int i = 0; i<5; i++){
			for (int j = 4; j>i; j--){
				System.out.print("  ");
			}
			for (int k = 0; k<i ; k++){
				System.out.print(" *");
			}
			System.out.println();
		}
		System.out.println();
	}

	void m3(){ //��4321
		for (int i = 0; i<5; i++){
			for (int j = 4; j>i; j--){
				System.out.print("* ");
			}
			System.out.println();
		}
	}


	void m4(){ //��4321
		for (int i = 0; i<5; i++){
			for (int j = 0; j<i; j++){
				System.out.print("  ");
			}
			for (int k = 4; k>i ; k--){
				System.out.print(" *");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		Star st = new Star();
		st.m1();
		st.m2();
		st.m3();
		st.m4();
	}
}
