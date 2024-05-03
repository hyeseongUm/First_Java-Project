package etc_p;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUp {
	String dir;
	
	public FileUp(HttpServletRequest request) {		
		dir = request.getServletContext().getRealPath("images/");	
dir = "C:\\woong\\workspace\\Novel101\\src\\main\\webapp\\images\\"; 	//운만
//		dir = "D:\\Hyeseong\\workspace\\Novel101\\src\\main\\webapp\\images";  //혜성  
//		dir = "C:\\gunwoopark\\workspace\\Novel101\\src\\main\\webapp\\images\\"; //건우
//		dir = "C:\\GYUHWI\\workspace\\Novel101\\src\\main\\webapp\\images\\";	 //규휘
	}
	
	/** 파일 올리기 : new FileUp(request).fileUpload(request.getPart("upFile"));
	 * input type=file name = upFile로 getPart / String type 으로 파일이름 지정하여 설정하세요 
	 * */
	public String fileUpload(Part file) {
		System.out.println("111111");
		if(!file.getSubmittedFileName().equals("")) {
			String upFileName = file.getSubmittedFileName();
			try {	
				
				System.out.println("222222 : "+upFileName);
				int cnt = 1;
				String extension = upFileName.substring(upFileName.lastIndexOf("."));			
				String fileName = upFileName.substring(0,upFileName.lastIndexOf("."));
				File nowFile = new File(dir+upFileName);
				System.out.println("222 while 전");
				while(nowFile.exists()) {
					System.out.println("222 while 진입");
					upFileName = fileName+"("+cnt+")"+extension;
					nowFile = new File(dir+upFileName);
					cnt++;
					System.out.println("222 while 나가기 전");
				}
				file.write(dir+upFileName);
				file.delete();
				System.out.println("33333333");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return upFileName;	
		}
		return null;				
	}
	
	/** images 파일에서 file 지우기 */
	public void fileDelete(String upFileName) {
		
		new File(dir+upFileName).delete();		
	}
		
}
