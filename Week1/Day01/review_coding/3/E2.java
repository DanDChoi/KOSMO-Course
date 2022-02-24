import java.io.*;

class E2 {
    String fname = "e.data";
    FileOutputStream fos;
    FileInputStream fis;
    DataOutputStream dos;
    DataInputStream dis;

    E2(){
        try{
        fos = new FileOutputStream(fname);
        fis = new FileInputStream(fname);
        }catch(FileNotFoundException fnfe){
        }
        dos = new DataOutputStream(fos);
        dis = new DataInputStream(fis);
    }

    void w(){
        byte b =10;
        short s = 20;
        char c = 'a';
        int i = 40;
        long lo = 50L;
        float f = 60.0f;
        double d = 70.0;
        boolean flag = false;
        String str = "호랑이";
        try{
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeChar(c);
        dos.writeInt(i);
        dos.writeLong(lo);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(flag);
        dos.writeUTF(str);
        
        dos.flush();
        }catch(IOException ie){
        }finally{
            try{
                dos.close();
                fos.close();
            }catch(IOException ie){}
        }

    }
    void r(){ 
        try{
        byte b = dis.readByte();
        short s = dis.readShort();
        char c = dis.readChar();
        int i = dis.readInt();
        long lo = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        boolean flag = dis.readBoolean();
        String str = dis.readUTF();

        System.out.println("b: " +b+ ",s: " +s+ ",c: " +c+ ",i: "  +i+ ",lo: "+ lo);
        System.out.println("f: "+f+",d: "+d+",flag: "+flag+", str: "+ str);
        }catch(IOException ie){
        }
    }
    public static void main(String[] args){
        E2 e2 = new E2();
        e2.w();
        e2.r();
    }
    

    
}