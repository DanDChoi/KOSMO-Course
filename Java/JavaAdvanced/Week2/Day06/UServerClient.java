import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Hashtable;

class UServerClient extends Thread {
	String ip = "127.0.0.1"; // 비대면학생: 115.91.81.106, 대면:192.168.0.143
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Hashtable<String, String> ht = new Hashtable<String, String>();
	BufferedReader brFile;
	FileReader fr;
	int port = 7000;
	String fName = "ips.txt";
	String nickName, str, ipClient, name, clientIP;

	UServerClient() {
		init();
	}

	void init() {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		inputIp();

		start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ie) {
		}

		try {
			ds = new DatagramSocket();
			while (true) {
				String msg = br.readLine();
				msg = msg.trim();
				byte[] buf = msg.getBytes();
				InetAddress ia = InetAddress.getByName(ip);
				dp = new DatagramPacket(buf, buf.length, ia, port);
				ds.send(dp);
			}
		} catch (SocketException se) {
		} catch (UnknownHostException ue) {
			pln("네트웍상에 해당서버(" + ip + ")를 찾을 수 없음");
			init();
		} catch (IOException ie) {
		} finally {
			if (ds != null)
				ds.close();
		}
	}

	void inputIp() {
		try {
			p("IP ");
			ip = br.readLine();
			ip = ip.trim();
			if (ip.length() == 0)
				//ip = "192.168.152.1";
				ip = "115.91.81.106";
		} catch (IOException ie) {
		}
	}

	void in() {
		ht.put(clientIP, name);
	}

	public void run() {
		DatagramSocket ds = null;
		DatagramPacket dp = null;

		try {
			ds = new DatagramSocket(port);
			pln(port + "번에서 UDP서버 대기중..");
			byte[] buf = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);

			while (true) {
				ds.receive(dp);
				InetAddress ia = dp.getAddress();
				ipClient = ia.getHostAddress();
				String msg = new String(buf);
				msg = msg.trim();
				readF();
				pln(ht.get(ipClient) + ">> " + msg);
				for (int i = 0; i < buf.length; i++)
					buf[i] = 0;
			}
		} catch (SocketException se) {
		} catch (IOException ie) {
		} finally {
			if (ds != null)
				ds.close();
		}
	}

	void readF() {
		try {
			fr = new FileReader(fName);
			brFile = new BufferedReader(fr);

			while (true) {
				String line = brFile.readLine();
				if (line == null)
					break;
				str = line;
				str = str.trim();

				if (str.length() > 3) {
					int idx = str.lastIndexOf(" ");
					name = str.substring(0, idx);
					clientIP = str.substring(idx + 1);
					in();
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

	void p(String str) {
		System.out.print(str);
	}

	void pln(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		new UServerClient();
	}
}
