import java.io.*;

class A{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void m1(){ //CheckedException
        String line = null;
        try{
        line = br.readLine();
        System.out.println("line: " +line);
        }catch(IOException ie){}
    }

    void m2(){
        String str = "재테크";
        try{
            int i = Integer.parseInt(str);
            System.out.println("i: "+ (i+1));
        }catch(NumberFormatException ne){
            System.out.println("숫자의 형태가 아니네");
        }
    }


    public static void main(String[] args){
        A a = new A();
        //a.m1();
        a.m2();
    }
}