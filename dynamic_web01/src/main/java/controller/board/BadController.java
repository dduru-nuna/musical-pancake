package controller.board;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.service.BoardService;

@WebServlet("/board/clickBad")
public class BadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> goodHistory = (List<Integer>)session.getAttribute("boardGoodHistory");
		List<Integer> badHistory = (List<Integer>)session.getAttribute("boardBadHistory");
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		BoardDTO dto = new BoardDTO();
		dto.setId(id.intValue());
		
		BoardService service = new BoardService();
		
		if(!goodHistory.contains(id) && !badHistory.contains(id)) {
			service.upBad(dto);
			badHistory.add(id);
		} else if(badHistory.contains(id)) {
			service.downBad(dto);
			badHistory.remove(id);
		}
		session.setAttribute("boardBadHistory", badHistory);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + id);
	}
}
