/*
import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt(); 
    int j = sc.nextInt(); 
    int k = sc.nextInt(); 
    sc.close();
	
	int r1, r2, r3;
	if(i == j && j == k){
		r1 = i*1000+10000;
		System.out.println(r1);
	}else if (i == j || i == k || j == k){
		r2 = i*100 + 1000;
		System.out.println(r2);
	}else if(i != j || i != k || j != k){
		int[] list = {i, j, k};
		Arrays.sort(list);
		int max = list[list.length -1];
		r3 = max*100;
		System.out.println(r3);
	}
	}
}
*/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //ÁÙ¼ö
        int b = sc.nextInt(); //º°°¹¼ö
        
        for(int i=0; i>=b; i++){
            for(int j=0; j>=a; j++){
                System.out.print("*");
            }
        }
    }
}