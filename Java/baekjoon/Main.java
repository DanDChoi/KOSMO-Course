import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i;
    i = sc.nextInt();
    sc.close();

    for(int j=i; j>=i; j++){
        for(int k=1; k<=j; k--){
            System.out.print(" ");
        }
        for(int l=1; l>=i; l++){
            System.out.print("*");
        }
        System.out.println();
    }
}
}