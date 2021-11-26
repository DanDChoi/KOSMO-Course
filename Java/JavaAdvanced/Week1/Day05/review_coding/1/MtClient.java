import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class MtClient extends Thread {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Socket s;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String chatId;

    MtClient() {
        connect();
    }

    void connect() {
        try {
            p("Server IP(default: 192.168.0.63): ");
            String ip = br.readLine();
            ip = ip.trim();
            if (ip.length() == 0)
                ip = "192.168.0.63";

            p("port(default: 3000): ");
            String portStr = br.readLine();
            portStr = portStr.trim();
            if (portStr.length() == 0)
                portStr = "3000";
            int port = Integer.parseInt(portStr);
            if (port < 0 || port > 65535) {
                pln("범위가 유효하지 않는 포트입니다.");
                connect();
                return;
            }
            s = new Socket(ip, port);
            pln("Connected");
            is = s.getInputStream();
            os = s.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            start();
            speak();
        } catch (UnknownHostException ue) {
            pln("해당서버를 찾지 못함");
            connect();
        } catch (IOException ie) {
            connect();
        } catch (NumberFormatException ne) {
            pln("숫자만 입력하세요");
            connect();
        }
    }

    public void run() {
        try {
            while (true) {
                String msg = dis.readUTF();
                pln(msg);
            }
        } catch (IOException ie) {
            pln("서버다운, 2초후 종료.");
            try {
                Thread.sleep(2000);
                System.exit(0);
            } catch (Exception e) {
            }
        } finally {
            closeAll();
        }
    }

    void speak(){
        p("채팅ID(기본:GUEST): ");
        try{
            chatId = br.readLine();
            chatId = chatId.trim();
            if(chatId.length() == 0)
                chatId = "GUEST";
            dos.writeUTF(chatId);
            dos.flush();

            inputMsg();
        }catch(IOException ie){

        }
    }

    void inputMsg(){
        try{
            while(true){
                String msg = br.readLine();
                dos.writeUTF(chatId+":"+msg);
                dos.flush();
            }
        }catch(IOException ie){

        }finally{
            closeAll();
        }

    }

    void closeAll() {
        try {
            if (dis != null)
                dis.close();
            if (dos != null)
                dos.close();
            if (is != null)
                is.close();
            if (os != null)
                os.close();
            if (s != null)
                s.close();
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
        new MtClient();
    }
}