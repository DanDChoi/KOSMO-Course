import java.io.*;

class FileCopyBySoo 
{
	PrintStream ps = System.out; //모니터 
	InputStream is = System.in; //키보드 
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    FileInputStream fis; //읽는 파일 
	FileOutputStream fos; //쓰는 파일 
	BufferedInputStream bis;
	BufferedOutputStream bos;

	int option = CopyOption.COPY; //복사 or 잘라내기 
	String oriFileName = "";
	String fName = "";
	File fileDir;
	String dirName = "";

	void inputOption(){
		pln("1. 복사   2. 잘라내기"); 
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("입력은 필수");
                inputOption();
				return;
			}
            int temp = Integer.parseInt(str);
			if(!(temp == 1 || temp == 2)){
				pln("1 or 2만 입력 가능");
                inputOption();
			}
           
		    option = temp;
			inputOriginal();
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("숫자만 입력 가능");
			inputOption();
		}
	}
	void inputOriginal(){
		p("복사 원본 파일 : ");
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("입력은 필수");
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
			pln("입력한 파일은 없음");
            inputOriginal();
		}catch(IOException ie){
		}
	}
	void inputCopyDir(){
		p("복사할 폴더 위치 : ");
		try{
			String str = br.readLine();
			if(str != null) str = str.trim();
			if(str.length() == 0) {
				pln("입력은 필수");
                inputCopyDir();
				return;
			}
            fileDir = new File(str);
			if(fileDir.isFile()){
				pln("폴더만 입력 가능");
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
		p("존재하지 않는 디렉토리! 만들까요?(Yes/No) : ");
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
				pln("yes와 no만 가능!");
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
			p("동일 이름 파일 존재! 덮어 쓸까요?(Yes/No) : "); 
			try{
				String str = br.readLine();
				if(str != null) str = str.trim();
				if(str.equalsIgnoreCase("yes")){
					goCopyOrCut();
				}else if(str.equalsIgnoreCase("no")){
                    return;
				}else{
                    pln("yes와 no만 가능!");
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
			pln("복사 성공");
		}else { //option == CopyOption.CUT
            if(new File(oriFileName).delete()){
				pln("잘라내기 성공");
			}else{
				pln("원본 삭제 실패");
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

// keyboard 입력, Moniter 출력 
// 파일 입력, 파일 출력  
