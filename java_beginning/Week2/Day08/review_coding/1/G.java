class G 
{
	int is1[] = {1, 2};
	int is2[] = {3, 4, 5};
	int iss[][] = {is1, is2};
	int isss[][][] = {iss, {{6, 7, 8, 9}, {100}}};

	void out1(){
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					System.out.println("isss["+i+"]["+j+"]["+k+"]: "+isss[i][j][k]);
				}
			}
		}
	}

	void out2(){ //ÁÂÇ¥ 0,1,2 µ¥ÀÌÅÍ Ãâ·Â
		System.out.println(isss[0][1][2]);
	}

	void out3(){ //80ÀÇ ÁÂÇ¥Ãâ·Â
		aa:
		for (int i=0; i<isss.length; i++){
			for (int j=0; j<isss[i].length; j++){
				for (int k=0; k<isss[i][j].length; k++){
					if(isss[i][j][k]==80){
					System.out.println("isss["+i+"]["+j+"]["+k+"]: "+isss[i][j][k]);
					break aa;
					}
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
