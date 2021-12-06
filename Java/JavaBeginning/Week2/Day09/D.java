class D 
{
	String items[] = {"하나", "둘", "셋", "넷"};
	
	void out(){
		/*
		for(int i=0; i<items.length; i++){
			System.out.println("item: " + items[i]);
		}*/
		for(String item: items){
			System.out.println("item: " + item);
		}	
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.out();
	}
}
