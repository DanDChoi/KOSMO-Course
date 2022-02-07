import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i;
    i = sc.nextInt();
    sc.close();

    for(int j=1; j<=i; j++){
        for(int k=i; k>=j; k--){
            System.out.print(" ");
        }
        for(int l=1; l<=j; l++){
            System.out.print("*");
        }
        System.out.println();
    }
}
}