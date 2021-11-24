import java.net.*;
import java.io.*;

class AClient {
    Socket s;
    String ip = "192.168.0.142";
    int port = 4000;

    AClient() {
        try {
            s = new Socket(ip, port);
            pln("서버(" + ip + ")와 접속 성공");
        } catch (UnknownHostException ne) {
        } catch (IOException ie) {
        }
    }

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