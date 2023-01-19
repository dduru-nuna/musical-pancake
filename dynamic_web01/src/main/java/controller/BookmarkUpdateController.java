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

public class BookmarkUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login")  == null) {  //로그인 안되어 있는 상태에서 즐겨찾기 링크 모음에 접근하면 먼저 로그인 부터 하게 로그인창 실행
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
				
		String id = req.getParameter("id");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		dto.setUserId(userData.getUserId());  //dto에 사용자id 까지 넘겨서 동일 계정일 때만 업데이트화면이 띄워지게 함
		
		BookmarkService service = new BookmarkService();
		BookmarkDTO data = service.getId(dto);
		
		if(data == null) {
			resp.sendRedirect(req.getContextPath() + "/error");
		} else {
			req.setAttribute("data", data);
			req.getRequestDispatcher("/WEB-INF/view/bookmarkupdate.jsp").forward(req, resp);		
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login")  == null) {  //로그인 안되어 있는 상태에서 즐겨찾기 링크 모음에 접근하면 먼저 로그인 부터 하게 로그인창 실행
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		String id = req.getParameter("id");
		String url = req.getParameter("url");
		String name = req.getParameter("name");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		dto.setUserId(userData.getUserId());  //실제 수정 작업 할 때도 사용자계정 일치하는지 확인하는 작업 후 업데이트 진행될 수 있게 함
		dto.setUrl(url);
		dto.setName(name);
		
		BookmarkService service = new BookmarkService();
		boolean result = service.update(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		} else {
			resp.sendRedirect("../error");
		}
	}
}

