import java.io.*;

//System.in: 표준 입력
//System.out: 표준 출력

class A {
    InputStream is = System.in; //근본스트림 (Node Stream)
    Reader r = new InputStreamReader(is); //다리스트림 (Bridge Stream)
    BufferedReader br = new BufferedReader(r); //목적(응용)스트림 (Filter Stream)

    PrintStream ps = System.out;

    void input(){
        try{
        String line = br.readLine();
        ps.println("키보드에서 읽은 값: "+ line);
        }catch(IOException ie){ 
        }
    }
    public static void main(String[] args){
        A a = new A();
        a.input();
    }
}