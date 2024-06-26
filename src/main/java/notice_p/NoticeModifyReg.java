package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModifyReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDTO dto = new NoticeDTO();
		
		try {
			String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			
			dto.setnTitle(request.getParameter("nTitle"));
			dto.setnContent(request.getParameter("nContent"));
			dto.setnNo(Integer.parseInt(request.getParameter("nNo")));
			dto.setmImg(upFileName); //파일 이름 뽑기
			
			
			new NoticeDAO().noticeModify(dto);
			
			request.setAttribute("NModifyData", dto);
			request.setAttribute("msg", "수정이 완료되었습니다.");
			request.setAttribute("move", "/notice/NoticeDetail?nNo="+dto.getnNo());
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
