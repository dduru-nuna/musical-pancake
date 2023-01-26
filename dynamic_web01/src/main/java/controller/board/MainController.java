package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.BoardService;
import paging.Paging;

@WebServlet("/board")
public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");
		if(p == null) {
			p = "1";
		} else if(p.isEmpty()) {
			p = "1";
		}
		
		//사용자가 select 옵션 선택했을 때 쿠키 저장해서 화면에 전달되는 코드
		//파라메터 추출(사용자가 옵션 선택했을 때 c 있음)
		String c = req.getParameter("c");

		//쿠키에서 데이터 추출(boardListLimit 이란 쿠키가 있을 때)
		Cookie boardCookie = null;
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("boardListLimit")) {
				boardCookie = cookie;
			}
		}
		//기본값 10(쿠키 없고 파라메터 없을 때의 기본값)
		int pageLimit = 10;	
		//쿠키 있는지 확인하고 있으면 쿠키 값이 pageLimit 이 됨
		if(boardCookie != null) {
			pageLimit = Integer.parseInt(boardCookie.getValue());
		}
		//파라메터 있는지(사용자가 옵션 선택했을 때) 확인하고 있으면 파라미터 값을 boardListLimit이란 이름의 쿠키로 설정
		if(c != null) {
			if(!c.isEmpty()) {
				pageLimit = Integer.parseInt(c);
				boardCookie = new Cookie("boardListLimit", c);
				boardCookie.setMaxAge(60 * 60 * 24 * 5);
				resp.addCookie(boardCookie);
			}
		}
		//
		
		int pageNumber = Integer.parseInt(p);
		
		BoardService service = new BoardService();
		Paging data = service.getPage(pageNumber, pageLimit);

		req.setAttribute("paging", data);
		req.getRequestDispatcher("/WEB-INF/view/board/main.jsp").forward(req, resp);
	}
}
