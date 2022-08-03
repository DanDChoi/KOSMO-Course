import java.net.*;
import java.io.*;

public class AClient implements Runnable {
    Socket s;
    String ip = "192.168.0.63"; // at home: 115.91.81.106 , at class: 192.168.0.142
    int port = 4000;
    OutputStream os;
    DataOutputStream dos;
    BufferedReader br1, br2;
    PrintWriter pw1;
    Thread t1, t2;
    String in = "", out = "";

    AClient() {
        try{
        t1 = new Thread(this);
        t1 = new Thread(this);
        s = new Socket(ip, port);
        t1.start();
        t2.start();
        }catch(IOException ie){    
        }finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException ie) {
            }
        }

        /*try {
            s = new Socket(ip, port);
            pln("서버(" + ip + ")와 접속 성공");
            os = s.getOutputStream();
            speak();
        } catch (UnknownHostException ne) {
            pln("네트워크에서 해당 서버(" + ip + ")를 찾을 수 없음");
        } catch (IOException ie) {
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException ie) {
            }
        }*/
    }

    public void run(){
        try{
            if(Thread.currentThread() == t2){
                do{
                    br1 = new BufferedReader(new InputStreamReader(System.in));
                    pw1 = new PrintWriter(s.getOutputStream(), true);
                    in = br1.readLine();
                    pw1.println(in);
                }while(!in.equals("END"));
            }else{
                do{
                    br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out = br2.readLine();
                    pln("Server Says :" + out); 
                }while(!out.equals("END"));
            }
        }catch(IOException ie){  
        }finally {
            try {
                if (dos != null)
                    dos.close();
                if (os != null)
                    dos.close();
            } catch (IOException ie) {
            }
        }
    }

    
/*
    void speak() { // keyboard -> socket
        dos = new DataOutputStream(os);
        try {
            String msg = "";
            while (true) {
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("서버가 다운됐습니다. 2초 후에 종료합니다.");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException iee){}
        } finally {
            try {
                if (dos != null)
                    dos.close();
                if (os != null)
                    dos.close();
            } catch (IOException ie) {
            }
        }
    }
    */

    void p(String str) {
        System.out.print(str);
    }

    void pln(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        AClient c = new AClient();
    }
}