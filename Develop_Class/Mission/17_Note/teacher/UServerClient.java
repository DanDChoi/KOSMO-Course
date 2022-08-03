import java.io.*;
import java.net.*;

class UServerClient extends Thread {
	String ip = "127.0.0.1"; //�����л�: 115.91.81.106, ���:192.168.0.143
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int port = 7000;

	UServerClient(){
		init();
	}
	void init(){
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		inputIp();

		start();
		try{
			Thread.sleep(100);
		}catch(InterruptedException ie){}

		try{
			ds = new DatagramSocket();
			while(true){
				//p("�����Ҹ޼���: ");
				String msg = br.readLine();
				msg = msg.trim();
				byte[] buf = msg.getBytes();
				InetAddress ia = InetAddress.getByName(ip);
				dp = new DatagramPacket(buf, buf.length, ia, port);
				ds.send(dp);
				//pln("���ۿϷ�!!");
			}
		}catch(SocketException se){
		}catch(UnknownHostException ue){
			pln("��Ʈ���� �ش缭��("+ip+")�� ã�� �� ����");
			init();
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	void inputIp(){
		try{
			p("IP(�⺻:192.168.0.143): ");
			ip = br.readLine();
			ip = ip.trim();
			if(ip.length() == 0) ip="192.168.0.143";
		}catch(IOException ie){}
	}

	public void run(){
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		try{
			ds = new DatagramSocket(port);
			pln(port+"������ UDP���� �����..");
			byte[] buf = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);
			
			while(true){
				ds.receive(dp);
				InetAddress ia = dp.getAddress();
				String ipClient = ia.getHostAddress();
				String msg = new String(buf);
				msg = msg.trim();
				pln(ipClient+">> " + msg);
				for(int i=0; i<buf.length; i++) buf[i]=0;
			}
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new UServerClient();
	}
}

