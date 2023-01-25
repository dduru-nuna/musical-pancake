package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;
import paging.Paging;

/**
 * 즐겨찾기 작성할 수 있는 기능을 제공하기 위한 Servlet
 * 맵핑된 URL 주소는 /bookmark 이다. (web.xml 사용)
 */
public class BookmarkController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
	//	if(session.getAttribute("login")  == null) {  //로그인 안되어 있는 상태에서 즐겨찾기 링크 모음에 접근하면 먼저 로그인 부터 하게 로그인창 실행
	/**	필터 등록해놔서 제거함
	 *  if(!(boolean)session.getAttribute("login")) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
	*/ 	
		UserDTO userData = (UserDTO)session.getAttribute("user"); //세션에 저장되어있는 "user" 정보 가져와서 dto 객체로 저장
		
		String p = req.getParameter("p");
		if(p == null) {
			p = "1";
		} else {
			if(p.isEmpty()) {
				p = "1";
			}
		}
		
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for(Cookie opt: cookies) {
			if(opt.getName().equals("cnt")) {
				cookie = opt;
			}
		}
		
		int cnt = 10;
		if(cookie != null) {
			if(req.getParameter("opt") != null) {
				if(!req.getParameter("opt").isEmpty()) {
					cnt = Integer.parseInt(req.getParameter("opt"));
					cookie = new Cookie("cnt", String.valueOf(cnt));
					cookie.setMaxAge(60 * 60 * 24 * 5);
					resp.addCookie(cookie);
				}
			} else {
				cnt = Integer.parseInt(cookie.getValue());
			}
		} else {
			if(req.getParameter("opt") != null) {
				if(!req.getParameter("opt").isEmpty()) {
					cnt = Integer.parseInt(req.getParameter("opt"));
					cookie = new Cookie("cnt", String.valueOf(cnt));
					cookie.setMaxAge(60 * 60 * 24 * 5);
					resp.addCookie(cookie);
				}
			}
		}
		
		BookmarkService service = new BookmarkService();
		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		
//		List<BookmarkDTO> data = service.getAll(dto); //조회해서 저장
		
		Paging data = service.getPage(dto, Integer.parseInt(p), cnt);
		
		req.setAttribute("paging", data);
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
	//	if(session.getAttribute("login")  == null) {  //로그인 안되어 있는 상태에서 즐겨찾기 링크 모음에 접근하면 먼저 로그인 부터 하게 로그인창 실행
	/*	if(!(boolean)session.getAttribute("login")) {	
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
	*/	
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		String url = req.getParameter("url");
		String name = req.getParameter("name");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		dto.setUrl(url);
		dto.setName(name);
		
		BookmarkService service = new BookmarkService();
		boolean result = service.add(dto);
		
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/bookmark"); //재요청
		} else {
			resp.sendRedirect(req.getContextPath() + "/error"); //에러페이지 만들기
		}
	}
}

