import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt(); //시
    int M = sc.nextInt(); //분
    int CT = sc.nextInt(); //요리에 필요한 시간
    sc.close();
 
    if(M+CT >59){
        H++;
        if(M+CT > 119){ H++;}
        int MM = (CT+M)-60;
        if(H<0){ H = 23;}
        if(H==24){ H = 0;}
        if(MM==60){MM = 0;}
        System.out.println(H+" "+MM);
    }else{
        System.out.println(H+" "+(CT+M));
    }
    }
}