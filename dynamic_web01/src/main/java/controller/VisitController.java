package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.VisitDTO;
import model.service.VisitService;
import paging.Paging;

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
	//	System.out.println(req.getServletContext().getAttribute("hello"));  ServletContext 실행 확인용 프린트구문
		String p = req.getParameter("p"); //페이지 정보 추출 
		
		if(p == null) {
			p = "1";
		} else {
			if(p.isEmpty()) {
				p = "1";
			}
		}
		
		//cnt 라는 이름의 쿠키 찾기. 있으면 쿠키 저장
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("cnt")) {
				cookie = c;
			}
		}
		
		//쿠키x파라메터x -> 목록수 기본10 , 쿠키o파라메터x -> 쿠키값 , 쿠키ox파라메터o -> 파라메터값&쿠키재설정
		int cnt = 10;
		if(cookie != null) {
			if(req.getParameter("c") != null) {
				if(!req.getParameter("c").isEmpty()) {
					cnt = Integer.parseInt(req.getParameter("c"));
					cookie = new Cookie("cnt", String.valueOf(cnt));
					cookie.setMaxAge(60 * 60 * 24 * 5);
					resp.addCookie(cookie);
				}
			} else {
				cnt = Integer.parseInt(cookie.getValue());
			}
		} else {
			if(req.getParameter("c") != null) {
				if(!req.getParameter("c").isEmpty()) {
					cnt = Integer.parseInt(req.getParameter("c"));
					cookie = new Cookie("cnt", String.valueOf(cnt));
					cookie.setMaxAge(60 * 60 * 24 * 5);
					resp.addCookie(cookie);
				}
			}
		}
		
		
		VisitService service = new VisitService();
	//	List<VisitDTO> data = service.getAll(); //조회해서 저장
		Paging data = service.getPage(Integer.parseInt(p), cnt); //페이지번호, 목록수 가져오기
					
	//	req.setAttribute("data", "Hello"); //리스너 확인용
		req.setAttribute("paging", data);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	//	req.removeAttribute("data"); //리스너 확인용
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
			resp.sendRedirect("./visit"); //재요청
		} else {
			System.out.println("추가 안됨");
		}
	}
}
