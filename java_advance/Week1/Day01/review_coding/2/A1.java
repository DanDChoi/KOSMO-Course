import java.io.*;

class A1{
    InputStream is = System.in;
    Reader r = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(r);

    PrintStream ps = System.out;

    void input(){
        try{
        String line = br.readLine();
        ps.println("keyboard data: "+ line);
        }catch(IOException ie){
        }
    }

    public static void main(String[] args){
        A1 a1 = new A1();
        a1.input();
    }
}