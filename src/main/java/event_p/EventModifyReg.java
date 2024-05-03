package event_p;

import java.io.IOException;

import dao_p.EventDAO;
import dto_p.EventDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventModifyReg implements EventService{

	
	//not null 항목 => 작성하지 않았을 경우 수정되지 않게 원래 페이지 유지 & db 업뎃 안되도록
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		try {
			EventDTO edto = new EventDTO();	
			
			edto.setEveNo(Integer.parseInt(request.getParameter("e_no")));
			String upFileName = request.getPart("upFile").getSubmittedFileName();
			
			//사진 삭제 후 변경
			if(upFileName != null) {				
					upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
					edto.setEveImg(upFileName); 
			}
			//사진 변경하지 않을 경우
			else {
				edto.setEveImg(request.getParameter("upFile")); 
			}
					
			//제목 + 시작일은 빈칸 안됨
			if(request.getParameter("e_title").equals("")||request.getParameter("e_startDate").equals("")) {
				request.setAttribute("msg", "제목과 시작일은 필수입력사항입니다");
				request.setAttribute("move","EventModifyForm?e_no="+edto.getEveNo());
				request.setAttribute("incUrl", "components/moveUrl.jsp");
			}else {
				if(!request.getParameter("e_endDate").equals("")){
					edto.setEveEndDateStr(request.getParameter("e_endDate"));
				}else if(!request.getParameter("e_content").equals("")){
					edto.setEveContent(request.getParameter("e_content"));
				}
			
			edto.setEveTitle(request.getParameter("e_title"));
			edto.setEveStartDateStr(request.getParameter("e_startDate"));		
			new EventDAO().eModify(edto); //입력값을 넣어주기s
			
			// 게시글 작성 제출 시 실행 되는 기능 => 확인 후 값을 가지고 Detail 페이지로 이동
			request.setAttribute("msg", "이벤트가 수정되었습니다");
			request.setAttribute("move","EventDetail?e_no="+edto.getEveNo());
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			}			
		
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
