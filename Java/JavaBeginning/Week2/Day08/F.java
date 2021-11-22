class F {
	int is1[] = {10, 20}; //1차원
	int is2[] = {30, 40}; //1차원
	int iss[][] = {is1, is2}; //2차원 : 선언+생성+초기화
	/*
	int iss[][] = new int[2][2]; //2차원: 선언+생성
	void in(){ //초기화
		iss[0][0]=10;
		iss[0][1]=20;
		iss[1][0]=30;
		iss[1][1]=40;
	}*/
	void out(){
		/*
		System.out.println(iss[0][0]);
		System.out.println(iss[0][1]);
		System.out.println(iss[1][0]);
		System.out.println(iss[1][1]);
		*/
		for (int i=0; i<2; i++){
			for (int j=0; j<2; j++){
				System.out.println("iss["+i+"]["+j+"] : "+ iss[i][j]);
			}
		}
	}
	public static void main(String[] args) {
		F f = new F();
		//f.in();
		f.out();
	}
}
