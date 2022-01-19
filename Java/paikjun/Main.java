import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


class Main {
    BufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        i = sc.nextInt();

        for(int l=1; l<=i; l++){
            int j;
            int k;
            j = sc.nextInt();
            k = sc.nextInt();
            System.out.println(j+k);
        }
    }
    BufferedReader.flush();
}
