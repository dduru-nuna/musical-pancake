package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;

public class BookmarkDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
	//	if(session.getAttribute("login")  == null) {  //로그인 안되어 있는 상태에서 즐겨찾기 링크 모음에 접근하면 먼저 로그인 부터 하게 로그인창 실행
		if(!(boolean)session.getAttribute("login")) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		String id = req.getParameter("id");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		dto.setUserId(userData.getUserId());
		
		BookmarkService service = new BookmarkService();
		boolean result = service.delete(dto);
		
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/bookmark");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
		}
	}
}
