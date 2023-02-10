package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
