import java.net.*;
import java.io.*;

class AServer {
	int port = 4000; //well-known port : 0 ~ 1023 
	ServerSocket ss;
	Socket s;
	String ipClient;

	InputStream is;
	DataInputStream dis;

	AServer() {
		try {
			ss = new ServerSocket(port);
			pln(port + "번 포트에서 서버 대기중...");

			s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			pln("클라이언트(" + ipClient + ")입장");

			is = s.getInputStream();
			listen();
		} catch (IOException ie) {
			pln("ie: " + ie);
		} finally {
			try {
				if (s != null)
					s.close();
				if (ss != null)
					s.close();
			} catch (IOException ie) {
			}
		}
	}

	void listen() { // socket -> monitor
		dis = new DataInputStream(is);
		try {
			while (true) {
				String msg = dis.readUTF();
				pln("client(" + ipClient + "): " + msg);
			}
		} catch (IOException ie) {
				pln("클라이언트(" + ipClient + ")퇴장");
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (is != null)
					dis.close();
			} catch (IOException ie) {
			}
		}
	}

	void p(String str) {
		System.out.print(str);
	}

	void pln(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		new AServer();
	}
}
