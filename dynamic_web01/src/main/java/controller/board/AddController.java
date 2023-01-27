package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.dto.UserDTO;
import model.service.BoardService;

@WebServlet("/board/add")
public class AddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); //세션에 계정 정보가 있으니 필요
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContext(context);
		dto.setWriter(((UserDTO)session.getAttribute("user")).getUserId());
		dto.setBtype("B");
		
		BoardService service = new BoardService();
		boolean result = service.add(dto);
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + dto.getId());
		} else {
			req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
		}
	}
}
