import java.io.*;
import java.net.*;
import java.util.*;

class UServerClient extends Thread {
	String ip = "192.168.0.23"; //�����л�: 115.91.81.106, ���:192.168.0.143
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //�ؽø�
	BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));// ������Է°�
	int port = 7000;
	String fName = "ips.txt";
	FileReader fr = null;

	UServerClient(){
		try{
			fr = new FileReader(fName);
			readFile();

			init();
		}catch(FileNotFoundException fe){
			System.out.println("���� ����");
		}catch(IOException ie){
			System.out.println("���� �д� �� ���� �߻�");
		}
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
				String msg = br2.readLine();
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
	
	HashMap<String,String> map = new HashMap<String,String>(); //������ ���� �̸�, IP�ּҰ��� ������ �ؽø�
	String line = null;
	void readFile() throws IOException{ //���� ���� �б� �޼ҵ�
		br = new BufferedReader(fr);
		while((line = br.readLine()) != null){
			this.line = line.trim();//��������
			int idx = this.line.lastIndexOf(" ");
			if(idx == -1) idx = line.length(); //�̸����������
			String substr = line.substring(0,idx);//�̸�����
			//System.out.println(substr);
			String subip = line.substring(idx); //�����ĭ���� ������ ����
			subip = subip.trim();
			//System.out.println(subip);
			map.put(substr,subip); //�ؽøʿ� ���� ���ڿ�(�̸��� ������) ����
		}
	}

	void inputIp(){
		try{
			p("IP(�⺻:192.168.0.23): ");
			ip = br2.readLine();
			ip = ip.trim();
			//if(ip.length() == 0) ip="192.168.0.23";
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
				String ipClient = ia.getHostAddress();//Ŭ���̾�Ʈ IP����
				String name = "�����ǻ����";
				for (String key : map.keySet()) {// �ؽø� ���ǹ�
					String value = map.get(key);
					if(ipClient.equalsIgnoreCase(value)){ //Ŭ���̾�Ʈ IP�� �ؽøʿ� ������ value�� ������
						name = key;
						break;
					}
				}
				String msg = new String(buf);
				msg = msg.trim();
				pln(name+">> " + msg);
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

