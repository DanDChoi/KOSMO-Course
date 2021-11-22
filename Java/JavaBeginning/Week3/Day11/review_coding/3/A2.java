import java.io.*;

class A2{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void m1(){
        String line = null;
        try{
            line = br.readLine();
            System.out.println("line: "+line);
        }catch(IOException ie){}
    }
    void m2(){
        String str = "아아아";
        try{
            int i = Integer.parseInt(str);
            System.out.println("i: "+ (i+1));
        }catch(NumberFormatException ne){
            System.out.println("숫자아님");
        }
    }
    
    public static void main(String[] args){
        A2 a = new A2();
        a.m1();
        a.m2();
    }
}