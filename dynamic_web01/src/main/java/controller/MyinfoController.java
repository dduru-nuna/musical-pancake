package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.service.UserService;

public class MyinfoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("login") == null) { //로그인 안한 상태에서는 myinfo 못들어가게 함
			resp.sendRedirect(req.getContextPath());
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/view/myinfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login") == null) { //로그인서블릿에서 로그인 정보가 있을 때 "login" = true 로 설정했었음. null이면 정보 없는 경우이다
			resp.sendRedirect(req.getContextPath()); //로그인 안한 상태에서 myinfo 접근하지 못하게 함
			return;
		}
		
		UserDTO userData = (UserDTO)session.getAttribute("user"); //로그인서블릿에서 로그인 했을 때 설정한 계정 정보 불러오기. 저장될 때 object 로 됐으니 캐스팅 필요
		
		String password = req.getParameter("password");
		String changePass = req.getParameter("changePass");
		String email = req.getParameter("email");
		
		UserDTO dto = new UserDTO();
		dto.setPassword(changePass);
		dto.setEmail(email);
		
		UserService service = new UserService();
		boolean result = service.update(userData, dto, password);
		
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/logout");
		} else {
			req.setAttribute("error", "문제 발생");
			req.getRequestDispatcher("/WEB-INF/view/myinfo.jsp").forward(req, resp);
		}
		
	}
}
