class G
{
	G g; //참조형, 디폴트 초기값이 null로 나옴
	void m(){
		System.out.println("g: "+g);
	}

	public static void main(String[] args) 
	{
		new G().m();
	}
}
