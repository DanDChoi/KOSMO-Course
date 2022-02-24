import java.io.*;

class FileCopyBySoo 
{
	PrintStream ps = System.out; //����� 
	InputStream is = System.in; //Ű���� 
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    FileInputStream fis; //�д� ���� 
	FileOutputStream fos; //���� ���� 
	BufferedInputStream bis;
	BufferedOutputStream bos;

	int option = CopyOption.COPY; //���� or �߶󳻱� 
	String oriFileName = "";
	String fName = "";
	File fileDir;
	String dirName = "";

	void inputOption(){
		pln("1. ����   2. �߶󳻱�"); 
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("�Է��� �ʼ�");
                inputOption();
				return;
			}
            int temp = Integer.parseInt(str);
			if(!(temp == 1 || temp == 2)){
				pln("1 or 2�� �Է� ����");
                inputOption();
			}
           
		    option = temp;
			inputOriginal();
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("���ڸ� �Է� ����");
			inputOption();
		}
	}
	void inputOriginal(){
		p("���� ���� ���� : ");
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("�Է��� �ʼ�");
                inputOriginal();
				return;
			}
			fis = new FileInputStream(str);
			bis = new BufferedInputStream(fis, 2048);

            oriFileName = str;
            int idx = str.lastIndexOf("\\");
			fName = str.substring(idx+1);
			//pln("fName : " + fName);

            inputCopyDir();
		}catch(FileNotFoundException fe){
			pln("�Է��� ������ ����");
            inputOriginal();
		}catch(IOException ie){
		}
	}
	void inputCopyDir(){
		p("������ ���� ��ġ : ");
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("�Է��� �ʼ�");
                inputCopyDir();
				return;
			}
            fileDir = new File(str);
			if(fileDir.isFile()){
				pln("������ �Է� ����");
                inputCopyDir();
			}else{
				dirName = str;

				if(fileDir.exists()){
					checkDuplication();
				}else{
					showMsgNotExistDir();
				}  
			}
		}catch(IOException ie){
		}
	}
	void showMsgNotExistDir(){
		p("�������� �ʴ� ���丮! ������?(Yes/No) : ");
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.equalsIgnoreCase("yes")){
				if(fileDir.mkdirs()){
					goCopyOrCut();
				}
			}else if(str.equalsIgnoreCase("no")){
				return;
			}else{
				pln("yes�� no�� ����!");
			}
		}catch(IOException ie){
		}
	}
	
	boolean isDuplication;
	void checkDuplication(){
         File[] childs = fileDir.listFiles(); 
		 for(File child : childs){
			 if(child.isFile()){
			     String childFileName = child.getName();
                 if(fName.equals(childFileName)){
					 isDuplication = true;
				 }
			 }
		 }
		 showMsgDuplication();
	}
	void showMsgDuplication(){
        if(isDuplication){
			p("���� �̸� ���� ����! ���� �����?(Yes/No) : "); 
			try{
				String str = br.readLine();
				if(str != null) str = str.trim();
				if(str.equalsIgnoreCase("yes")){
					goCopyOrCut();
				}else if(str.equalsIgnoreCase("no")){
                    return;
				}else{
                    pln("yes�� no�� ����!");
				}
			}catch(IOException ie){
			}
		}else{
			goCopyOrCut();
		}
	}
	void goCopyOrCut(){
		String destination = dirName+"\\"+fName;
		try{
			fos = new FileOutputStream(destination);
			bos = new BufferedOutputStream(fos, 2048);
            
			int count = 0;
			byte bs[] = new byte[512];
			while((count = bis.read(bs)) != -1){
				bos.write(bs, 0, count);
			}
			bos.flush();
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}finally{
            try{
				if(bos != null) bos.close();
				if(bis != null) bis.close();
				if(fos != null) fos.close();
				if(fis != null) fis.close();
			}catch(IOException ie){
			}
		}

		showMsgResult();
	}
	void showMsgResult(){
        if(option == CopyOption.COPY){
			pln("���� ����");
		}else { //option == CopyOption.CUT
            if(new File(oriFileName).delete()){
				pln("�߶󳻱� ����");
			}else{
				pln("���� ���� ����");
			}
  		}
	}
	void pln(String str){
        ps.println(str);
	}
	void p(String str){
		ps.print(str);
	}
	public static void main(String[] args) 
	{
		FileCopyBySoo fc = new FileCopyBySoo();
        fc.inputOption();
	}
}

// keyboard �Է�, Moniter ��� 
// ���� �Է�, ���� ���  
