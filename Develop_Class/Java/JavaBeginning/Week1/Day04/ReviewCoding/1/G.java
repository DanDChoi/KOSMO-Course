class G
{
	G g; //������, ����Ʈ �ʱⰪ�� null�� ����
	void m(){
		System.out.println("g: "+g);
	}

	public static void main(String[] args) 
	{
		new G().m();
	}
}
