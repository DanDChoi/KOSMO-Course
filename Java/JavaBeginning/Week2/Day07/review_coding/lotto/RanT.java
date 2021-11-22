import java.util.*;

class RanT
{
	Random r = new Random();
	
	void showInt(){
		int i =r.nextInt(30);
		System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		RanT rt = new RanT();
		rt.showInt();
	}
}
