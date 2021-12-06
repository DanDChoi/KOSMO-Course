import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

class OneCliMod extends Thread {
    MtServer ms;
    Socket s;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String chatId;

    OneCliMod(MtServer ms) {
        this.ms = ms;
        this.s = ms.s;
        try {
            is = s.getInputStream();
            os = s.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException ie) {
        }
    }

    public void run() {
        listen();
    }

    void listen() {
        String msg = "";
        try {
            chatId = dis.readUTF();
            broadcast(chatId + "님 입장(인원:" + ms.v.size() + ")명");
            ms.pln(chatId + "님 입장(인원:" + ms.v.size() + ")명");
            while (true) {
                msg = dis.readUTF();
                broadcast(msg);
                ms.pln(msg);
            }
        } catch (IOException ie) {
            ms.v.remove(this);
            broadcast(chatId + "님 퇴장(인원:" + ms.v.size() + ")명");
            ms.pln(chatId + "님 퇴장(인원:" + ms.v.size() + ")명");
        } finally {
            closeAll();
        }
    }

    void broadcast(String msg) {
        try {
            for (OneCliMod ocm : ms.v) {
                ocm.dos.writeUTF(msg);
                ocm.dos.flush();
            }
        } catch (IOException e) {
        }
    }

    void closeAll() {
        try {
            if (dis != null)
                dis.close();
            if (dos != null)
                dos.close();
            if (os != null)
                os.close();
            if (s != null)
                s.close();
        } catch (IOException ie) {
        }
    }
}