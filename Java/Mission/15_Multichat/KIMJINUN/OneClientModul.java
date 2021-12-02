import java.io.*;
import java.util.*;
import java.net.*;


//어떤 클라이언트로 부터 받은 메세지를.. 모든 클라이언트들에게 전송해주는 서버측 클래스 
class OneClientModul extends Thread 
{
	MServer ms;
	Socket s;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	String chatId;

	OneClientModul(MServer ms){
		this.ms = ms;
		this.s = ms.s;
		try{
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
		}catch(IOException ie){}
	}
	public void run(){
		listen();
	}
	void listen(){ //우선 틀만 만들어 놓자
		String msg = "";
		try{
			chatId = dis.readUTF();
			broadcast(chatId+"님 입장!!(인원: "+ms.v.size()+"명)"); //다른 클라이언트들에게 씀
			ms.pln(chatId+"님 입장!!(인원: "+ms.v.size()+"명)"); //관리자에게 씀 
			while(true){
				msg = dis.readUTF();
				broadcast(msg);  
				ms.pln(msg); 
			}
		}catch(IOException ie){
			ms.v.remove(this);
			broadcast(chatId+"님 퇴장!!(인원: "+ms.v.size()+"명)"); 
			ms.pln(chatId+"님 퇴장!!(인원: "+ms.v.size()+"명)"); 
		}finally{
			closeAll();
		}
	}
	void checkoption(){
	
	}
	void broadcast(String msg){
		try{
		    for(OneClientModul ocm: ms.v){
				ocm.dos.writeUTF(msg);
				ocm.dos.flush();
			}
		}catch(IOException ie){
		}
	}
	void closeAll(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(s != null) s.close();
		}catch(IOException ie){}
	}
	void removeSelf(){
		ms.v.remove(this);
		closeAll();
		//ms.v.trimToSize();
	}
}











