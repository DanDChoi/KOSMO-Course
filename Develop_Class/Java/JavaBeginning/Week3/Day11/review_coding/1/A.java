import java.io.*;

class A{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void m1(){
        String line = null;
        try{
            line = br.readLine();
            System.out.println("line: "+ line);
        }catch(IOException ie){}
    }
    void m2(){
        String str = "����ũ";
        try{
            int i = Integer.parseInt(str);
            System.out.println("i: "+(i+1));
        }catch(NumberFormatException ne){
            System.out.println("������ ���°� �ƴϳ�");
        }
    }

    public static void main(String[] args){
        A a = new A();
        //a.m1();
        a.m2();
    }
}