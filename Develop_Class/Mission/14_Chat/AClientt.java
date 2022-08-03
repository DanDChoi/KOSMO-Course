import java.net.*;
import java.io.*;

class AClientt extends Thread {

   Socket s;
   String ip = "192.168.0.138"; //at home : 115.91.81.106
   int port = 4000;
   OutputStream os;
   DataOutputStream dos;
   InputStream is;
   DataInputStream dis;


   AClientt(){
      try{
         s = new Socket(ip, port);
         pln("����("+ip+")�� ���� ����!!");      
         is = s.getInputStream();
         os = s.getOutputStream();
         start();
         speak();

      }catch(UnknownHostException ne){
         pln("��Ʈ������ �ش� ����("+ip+")�� ã�� �� ����");
      }catch(IOException ie){
      }finally{
         try{
            if(s != null) s.close();
         }catch(IOException ie){}
      }
   }
   public void run(){
      listen();
   }
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   void speak(){ //keyboard -> socket 
      dos = new DataOutputStream(os);
      try{
         String msg = "";
         while(true){
            msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
         }
      }catch(IOException ie){
         pln("������ �ٿ��.. 2�� �Ŀ� �����ϰڽ��ϴ�");
         try{
            Thread.sleep(2000);
         }catch(InterruptedException iee){}
         System.exit(0);
      }finally{
         try{
            if(dos != null) dos.close();
            if(os != null) os.close();
         }catch(IOException ie){}
      }
   }
   void listen (){ //socket -> monitor 
      dis = new DataInputStream(is);
      try{
         while(true){
            String msg = dis.readUTF();
            pln("client" + msg);
         }
      }catch(IOException ie){
         pln("Ŭ���̾�Ʈ");
      }finally{
         try{
            if(dis != null) dis.close();
            if(is != null) is.close();
         }catch(IOException ie){}
      }
   } 

   void p(String str){
      System.out.print(str);
   }
   void pln(String str){
      System.out.println(str);
   }
   public static void main(String[] args) {
      AClientt c = new AClientt();
   }
}