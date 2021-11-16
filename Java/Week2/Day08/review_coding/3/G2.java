class G2 
{
	int is1[] = {1, 2};
	int is2[] = {3, 4};
	int iss[][] = {is1, is2};
	int isss[][][] = {iss, {{6, 7, 8, 9}, {10}}};

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
		System.out.println(isss[0][1][3]);
	}

	void out3(){
		aa:
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					if(isss[i][j][k]==100){
					System.out.println("isss["+i+"]["+j+"]["+k+"] : " +isss[i][j][k]);
					break aa;
					}
				}
			}
		}
	}	
	}
	public static void main(String[] args) 
	{
		G2 g2 = new G2();
		//g2.out1();
		//g2.out2();
		g2.out3();
	}
}
