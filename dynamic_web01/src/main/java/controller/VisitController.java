package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.VisitDTO;
import model.service.VisitService;

/**
 * 방명록을 작성할 수 있는 기능을 제공하기 위한 Servlet
 * 맵핑된 URL 주소는 /visit 이다. (web.xml 사용)
 */
public class VisitController extends HttpServlet {
	
	/**
	 * 사용자가 방명록 페이지를 요청하면 방명록을 작성할 수 있는 폼을 담은 JSP 페이지를 실행하여 제공한다.
	 * JSP 페이지는 /WEB-INF/view/visit.jsp 이다. 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}
	
	/**
	 * 사용자가 방명록을 작성한 후 저장 요청을 하면 해당 데이터를 저장하기 위한 처리를 수행한다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String context = req.getParameter("context");
		String nickname = req.getParameter("nickname");
		
		VisitDTO dto = new VisitDTO();
		dto.setContext(context);
		dto.setNickname(nickname);
		
		VisitService service = new VisitService();
		boolean result = service.add(dto);
		
		if(result) {
			System.out.println("추가 됨");
		} else {
			System.out.println("추가 안됨");
		}
	}
}
