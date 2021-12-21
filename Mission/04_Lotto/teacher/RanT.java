import java.util.*;

class RanT 
{
	Random r = new Random();
	void showInt(){
		int i = r.nextInt(30); //0~(n-1) //0~29
		System.out.println("i: " + i);
	}
	public static void main(String[] args) 
	{
		RanT rt = new RanT();
		rt.showInt();
	}
}
