import java.io.*;
import java.net.*;

class UServer { // 비연결지향
    int port = 6000;
    DatagramSocket ds; // 메시지함 (우체통)
    DatagramPacket dp; // 메시지 (편지봉투)

    UServer() {
        try {
            ds = new DatagramSocket(port);
            pln(port + "번에서 UDP서버 대기중...");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length);
            while (true) {
                ds.receive(dp);
                String msg = new String(buf);
                msg = msg.trim();
                pln("Client>>" + msg);
                for (int i = 0; 1 < buf.length; i++)
                    buf[i] = 0;
            }
        } catch (SocketException se) {
        } catch (IOException ie) {
        } finally {
            if (ds != null)
                ds.close();
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        new UServer();
    }
}