class 동물
{
	String 이름;
	int 나이;

	동물(){
		이름 = "사자";
		나이 = 10;
	}
	동물(String 이름, int 나이){
		this.이름 = 이름;
		this.나이 = 나이;
	}
	void 빠르다 (){
		System.out.println("빠르다");
	}
	void 무섭다 (){
		System.out.println("무섭다");
	}
}


class D2
{
	public static void main(String[] args) 
	{
		동물 동물1 = new 동물();
		System.out.print("나이가 " + 동물1.나이 + "살인 " + 동물1.이름 + "는 ");
		동물1.빠르다();

		동물 동물2 = new 동물("호랑이", 5);
		System.out.print("나이가 " + 동물2.나이 + "살인 " + 동물2.이름 + "는 ");
		동물2.무섭다();
	}
}
