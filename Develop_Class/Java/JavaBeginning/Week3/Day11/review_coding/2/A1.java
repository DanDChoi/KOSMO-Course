import java.io.*;

class A1{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void m1(){
        String line = null;
        try{
            line = br.readLine();
            System.out.println("line: "+ line);
        }catch(IOException ie){}
    }
    void m2(){
        String str = "������";
        try{
            int i = Integer.parseInt(str);
            System.out.println("i: "+(i+1));
        }catch(NumberFormatException ne){
            System.out.println("���ڰ� �ƴ�");
        }
    }

    public static void main(String[] args){
        A1 a = new A1();
        a.m1();
        a.m2();
    }
}