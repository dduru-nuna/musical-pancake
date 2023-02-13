package main.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import board.dto.BoardDTO;
import main.service.MainService;

@WebServlet("/main")
public class MainController extends HttpServlet {

	/**
	 * 메인 화면을 위한 컨트롤러
	 * 메인 화면에는 게시판에 작성된 글 중 최근글과 조회수가 많은 글을
	 * 조회하여 사용자에게 제공하기 위한 기능을 수행한다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/WEB-INF/view/main/index.jsp";
		
		MainService service = new MainService();
		List<BoardDTO> latestData = service.getLatestBoard(5);
		List<BoardDTO> bestData = service.getBestBoard(5);
		
		req.setAttribute("latestData", latestData);
		req.setAttribute("bestData", bestData);
		
		//데이터 조회 또는 추가, 수정, 삭제 처리 이후에는 req.getRequestDispatcher()
		//또는 resp.sendRedirect() 메서드를 사용하여 처리 결과를 사용자에게 알려줌
		// req.getRequestDispatcher() : 보통 데이터 조회 후 조회 결과를 JSP 페이지를 통해 만들어서 제공할 때 사용
		//                              사용자의 초기 요청 주소가 그대로 유지
		// resp.sendRedirect() : 보통 데이터 추가, 수정, 삭제 후 처리 결과를 다른 컨트롤러를 통해 확인할 수 있도록
		//                       해당 컨트롤러의 접근 URL을 사용자에게 알려줄 때 사용
		//                       사용자의 초기 요청 주소가 변경되어 있음
		
		req.getRequestDispatcher(view).forward(req, resp);
		
		//Part 객체 : 사용자 요청 데이터 중에 파일이 있는 경우 사용
		//           HTML form 태그에는 enctype="multipart/form-data" 속성이 사용된다.
		//           Controller 에 @MultipartConfig 또는 web.xml 에 <multipart-config> 태그가 설정되어 있어야 함
		Part part = req.getPart("uploadFile"); // uploadFile 은 form 태그에 있는 <input type="file" name="uploadFile"> 에서 업로드한 파일을 나타냄
		Collection<Part> parts = req.getParts(); // <input type="file" name="uploadFile" mutiple> 이 사용된 경우 활용
		for(Part p: parts) {
			if(p.getName().equals("uploadFile")) {
				// .getName() 메서드로 uploadFile 로 업로드한 파일을 찾아야함
			}
		}
		part.getContentType(); //업로드한 파일의 종류 -> MIME 형식으로 반환 (text/css, text/html, text/plain, image/jpeg, image/png, ...)
		part.getSize(); //파일 크기(바이트 단위)
		part.getSubmittedFileName(); //업로드한 파일명
		part.write("파일명"); //지정한 파일명으로 하드디스크에 쓰기 작업 진행. 파일명만 있는 경우에는 location 속성에 설정한 경로에 지정
		//파일명 대신 (절대 경로 + 파일명) 으로 작성하는 경우 해당 위치에 쓰기 작업 진행
		//웹 서버에 저장 후 사용자에게 다시 제공하는 것을 고려하여 서버의 실제 동작 위치에 파일이 저장되도록 하기 위해 다음의 코드를 작성
		ServletContext sc = req.getServletContext();
		String realPath = sc.getRealPath("서버의 webapp 디렉터리의 경로를 root(/) 로 생각하고 작성");
		
		//파일 업로드를 할 때 사용자들이 업로드한 파일명이 동일한 경우 덮어쓰기 되는것을 고려하여
		//사용자들마다 다른 파일명으로 업로드 될 수 있게 만들어야 함 (ex. UUID)
		
		//Request 객체
		HttpServletRequest request = req;
		req.setAttribute("속성명", "속성값");
		req.getAttribute("속성명"); //Object 객체로 속성값 반환
		req.removeAttribute("속성명");
		
		//Session 객체
		HttpSession session = req.getSession();
		session.setAttribute("속성명", "속성값");
		session.getAttribute("속성명"); //Object 객체로 속성값 반환
		session.removeAttribute("속성명");
		
		//쿠키
		Cookie cookie = new Cookie("쿠키명", "쿠키값");
		resp.addCookie(cookie); //서버에 저장하는 것이 아니라 클라이언트에 전달 함
		//사용자가 요청을 보낼 때 같이 보낸 쿠키를 반복문 이용하여 찾음
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("쿠키명")) {
				c.getValue(); //문자열로 쿠키값 반환
			}
		}
		//쿠키 삭제는 사용자에게 쿠키 만료시간이 0초인 쿠키를 새로 보내서 브라우저가 만료시간을 보고 삭제하도록 함
		cookie = new Cookie("쿠키명", "쿠키값");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		//서블릿컨텍스트
		ServletContext application = req.getServletContext();
		application.setAttribute("속성명", "속성값");
		application.getAttribute("속성명"); //Object 객체로 속성값 반환
		application.removeAttribute("속성명");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
