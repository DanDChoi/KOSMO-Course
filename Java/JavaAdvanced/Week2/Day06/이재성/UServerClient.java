import java.io.*;
import java.net.*;
import java.util.*;

class UServerClient extends Thread {
	String ip = "192.168.0.23"; //비대면학생: 115.91.81.106, 대면:192.168.0.143
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //해시맵
	BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));// 사용자입력값
	int port = 7000;
	String fName = "ips.txt";
	FileReader fr = null;

	UServerClient(){
		try{
			fr = new FileReader(fName);
			readFile();

			init();
		}catch(FileNotFoundException fe){
			System.out.println("파일 없음");
		}catch(IOException ie){
			System.out.println("파일 읽는 중 예외 발생");
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
				//p("전달할메세지: ");
				String msg = br2.readLine();
				msg = msg.trim();
				byte[] buf = msg.getBytes();
				InetAddress ia = InetAddress.getByName(ip);
				dp = new DatagramPacket(buf, buf.length, ia, port);
				ds.send(dp);
				//pln("전송완료!!");
			}
		}catch(SocketException se){
		}catch(UnknownHostException ue){
			pln("네트웍상에 해당서버("+ip+")를 찾을 수 없음");
			init();
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	
	HashMap<String,String> map = new HashMap<String,String>(); //파일을 읽은 이름, IP주소값을 저장할 해시맵
	String line = null;
	void readFile() throws IOException{ //파일 내용 읽기 메소드
		br = new BufferedReader(fr);
		while((line = br.readLine()) != null){
			this.line = line.trim();//공백제거
			int idx = this.line.lastIndexOf(" ");
			if(idx == -1) idx = line.length(); //이름만있을경우
			String substr = line.substring(0,idx);//이름발췌
			//System.out.println(substr);
			String subip = line.substring(idx); //공백앞칸부터 끝까지 저장
			subip = subip.trim();
			//System.out.println(subip);
			map.put(substr,subip); //해시맵에 읽은 문자열(이름과 아이피) 저장
		}
	}

	void inputIp(){
		try{
			p("IP(기본:192.168.0.23): ");
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
			pln(port+"번에서 UDP서버 대기중..");
			byte[] buf = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);
			
			while(true){
				ds.receive(dp);
				InetAddress ia = dp.getAddress();
				String ipClient = ia.getHostAddress();//클라이언트 IP저장
				String name = "무명의사용자";
				for (String key : map.keySet()) {// 해시맵 조건문
					String value = map.get(key);
					if(ipClient.equalsIgnoreCase(value)){ //클라이언트 IP와 해시맵에 지정된 value와 같을시
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

