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

public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/**쿠키확인
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			System.out.println(c.getName() + "|" + c.getValue());
		}		
		                         // 쿠키명 , 쿠키값
		Cookie cookie = new Cookie("name" , "value"); //localhost:8080/web01/ 하위에 있으면 따로 요청하지 않아도 쿠키 정보가 보내짐
		cookie.setMaxAge(60 * 60 * 24); //쿠키 유효시간 설정(초단위)		
		resp.addCookie(cookie); //쿠키 담기 
	*/	
	/**	세션
		HttpSession session = req.getSession(); //만약 세션이 없는 경우엔 새로 생성 후 반환해준다. 따라서 세션은 항상 있음. 그런데 false 가 들어가있는 경우는 있으면 반환해주고 없으면 null
		session.getAttribute("세션명");
		session.setAttribute("세션명", 객체);
		session.removeAttribute("세션명"); //세션객체에 저장된 데이터 삭제
		session.invalidate(); // 세션객체 자체를 삭제
	*/
		HttpSession session = req.getSession();
		if(session.getAttribute("login") != null) { //로그인한 상태면 다시 로그인창 못들어가게하기. 메인페이지 redirect
			resp.sendRedirect(req.getContextPath());
			return;
		}
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("remember")) {
				req.setAttribute("remember", c.getValue());
			}
		}
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
	//	System.out.println(remember); 체크박스 체크 되어 있는 상태에선 on, 안되어 있을 땐 null
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);  //사용자 입력한 값으로 저장
		dto.setPassword(password);
		
		UserService service = new UserService();
		UserDTO userData = service.login(dto);  //userData에 login 실행했을 때 return 값 반환(data 아님 null)
		
		Cookie cookie = new Cookie("remember", userId);
		
		if(userData != null) { //id,email,password 정보가 담긴 data 가 반환됐을 때 session 설정
			HttpSession session = req.getSession();
			session.setAttribute("login", true);
			session.setAttribute("user", userData); //세션의 user 라는 속성명이 login return 값 data를 가지게 함.
			
			if(remember != null) { //로그인 성공하고 아이디기억하기 체크 했을 때 쿠키 생성
				cookie.setMaxAge(60 * 60 * 24 * 5); //5일간 저장
			} else {
				cookie.setMaxAge(0); //쿠키 만료시켜서 지워지게 함
			}
			resp.addCookie(cookie); //쿠키 유효시간만 필요할 때,아닐 때 나눠서 설정하고 addCookie는 항상 한다.
			resp.sendRedirect(req.getContextPath());  //로그인 성공하면 다시 /web01/로 되돌아가기
		} else {
			req.setAttribute("error", "로그인 실패 다시 시도하세요.");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		}
	}
}
