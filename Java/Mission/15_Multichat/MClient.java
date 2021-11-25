import java.io.*;
import java.net.*;

public class MClient {
	public static void main(String[] args)
	{
		try {
			Socket sock = new Socket("172.30.1.8",4000);
			SendThread sendThread = new SendThread(sock);
			Thread thread = new Thread(sendThread);thread.start();
			RecieveThread recieveThread = new RecieveThread(sock);
			Thread thread2 =new Thread(recieveThread);thread2.start();
		} catch (Exception e) {System.out.println(e.getMessage());} 
	}
}
class RecieveThread implements Runnable
{
	Socket sock=null;
	BufferedReader recieve=null;
	
	public RecieveThread(Socket sock) {
		this.sock = sock;
	}//end constructor
	public void run() {
		try{
		recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));//get inputstream
		String msgRecieved = null;
		while((msgRecieved = recieve.readLine())!= null)
		{
			System.out.println("From Server: " + msgRecieved);
		}
		}catch(Exception e){System.out.println(e.getMessage());}
	}//end run
}//end class recievethread

class SendThread implements Runnable
{
	Socket sock=null;
	PrintWriter print=null;
	BufferedReader brinput=null;
	
	public SendThread(Socket sock)
	{
		this.sock = sock;
	}//end constructor
	public void run(){
		try{
		if(sock.isConnected())
		{
			System.out.println("Client connected to "+sock.getInetAddress() + " on port "+sock.getPort());
			this.print = new PrintWriter(sock.getOutputStream(), true);	
		while(true){
			brinput = new BufferedReader(new InputStreamReader(System.in));
			String msgtoServerString=null;
			msgtoServerString = brinput.readLine();
			this.print.println(msgtoServerString);
			this.print.flush();
		
			if(msgtoServerString.equals("EXIT"))
			break;
			}//end while
		sock.close();}}catch(Exception e){System.out.println(e.getMessage());}
	}//end run method
}//end class