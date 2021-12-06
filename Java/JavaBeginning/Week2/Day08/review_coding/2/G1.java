class G1
{
	int is1[] = {10, 20};
	int is2[] = {30, 40, 50};
	int iss[][] = {is1, is2};
	int isss[][][] = {iss, {{60, 70, 80, 90},{100}}};
	
	
	void out1(){
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					System.out.println("isss["+i+"]["+j+"]["+k+"] : " +isss[i][j][k]);
				}
			}
		}
	}

	void out2(){ 
		System.out.println(isss[0][1][2]);
	}
	void out3(){ 
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
		G1 g1 = new G1();
		//g.out1();
		//g.out2();
		g1.out3();
	}
}