
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