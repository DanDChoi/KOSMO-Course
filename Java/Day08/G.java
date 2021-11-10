class G
{
	int is1[] = {10, 20};
	int is2[] = {30, 40, 50};
	int iss[][] = {is1, is2};
	int isss[][][] = {iss, {{60, 70, 80, 90},{100}}};
	/*
	void out(){
		System.out.println(isss[0][0][0]);
		System.out.println(isss[0][0][1]);
		System.out.println(isss[0][1][0]);
		System.out.println(isss[0][1][1]);
		System.out.println(isss[0][1][2]);
		System.out.println(isss[1][0][0]);
		System.out.println(isss[1][0][1]);
		System.out.println(isss[1][0][2]);
		System.out.println(isss[1][0][3]);
		System.out.println(isss[1][1][0]);
	}
	*/
	
	void out1(){
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					System.out.println("isss["+i+"]["+j+"]["+k+"] : " +isss[i][j][k]);
				}
			}
		}
	}

	void out2(){ //좌표 (0,1,2)의 데이터를 출력
		System.out.println(isss[0][1][2]);
	}
	void out3(){ //80의 좌표를 출력
		aa:
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					if(isss[i][j][k]==80){
					System.out.println("isss["+i+"]["+j+"]["+k+"] : " +isss[i][j][k]);
					break aa;
					}
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		G g = new G();
		//g.out1();
		//g.out2();
		g.out3();
	}
}
