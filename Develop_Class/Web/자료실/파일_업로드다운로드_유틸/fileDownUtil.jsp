<%@ page contentType="text/html;charset=utf-8" import = "java.io.*" %>

<%//file.do?filename=파일네임 << 
	String fileName = new String(request.getParameter("fname"));
  
    String saveDir = application.getRealsaveDir("fileupload/store");
    System.out.println(saveDir);
//    out.println("saveDir : " + saveDir);
//	File file = new File("./workspace/M3Project/fileupload/store/" + fileName);
	File file = new File(saveDir +"/"+fileName);

	response.setContentType("application/octet-stream"); 

	String Agent=request.getHeader("USER-AGENT");

	if( Agent.indexOf("MSIE") >= 0 ){
		int i = Agent.indexOf( 'M', 2 );

		String IEV = Agent.substring( i + 5, i + 8 );

		if( IEV.equalsIgnoreCase("5.5") ){
			response.setHeader("Content-Disposition", "filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
		}else{
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"8859_1"));
		}
	}else{
		response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
	}

	byte b[] = new byte[1024];
	
	if( file.isFile()){ 
		try{ 
			BufferedInputStream fin = new BufferedInputStream( new FileInputStream( file ) );  
			BufferedOutputStream outs = new BufferedOutputStream( response.getOutputStream() );  

			int read = 0;

			while( ( read = fin.read( b ) ) != -1 ){  
				outs.write(b,0,read);
			}

			outs.flush();
			outs.close();  
			fin.close(); 
		}catch( Exception e ){}
	}
%>
