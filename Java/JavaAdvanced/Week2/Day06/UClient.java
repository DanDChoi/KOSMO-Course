import java.io.*;
import java.net.*;

class UClient {
    String ip = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 6000;

    UClient() {
        init();
    }

    void init() {
        inputIp();
        try {
            ds = new DatagramSocket();
            while (true) {
                p("전달할 메시지: ");
                String msg = br.readLine();
                msg = msg.trim();
                byte[] buf = msg.getBytes();
                InetAddress ia = InetAddress.getByName(ip);
                dp = new DatagramPacket(buf, buf.length, ia, port);
                ds.send(dp);
                pln("전송완료!");
            }
        } catch (SocketException se) {
        } catch (UnknownHostException ue) {
            pln("네트워크상에 해당 서버(" + ip + ")를 찾을 수 없음");
            init();
        } catch (IOException ie) {
        } finally {
            if (ds != null)
                ds.close();
        }
    }

    void inputIp() {
        try {
            p("IP(기본: 115.91.81.106)");
            ip = br.readLine();
            ip = ip.trim();
            if (ip.length() == 0)
                ip = "115.91.81.106";
        } catch (IOException ie) {
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        new UClient();
    }
}