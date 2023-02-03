package controller.board;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.dto.UserDTO;
import model.service.BoardService;

@WebServlet("/board/clickGood")
public class GoodController extends HttpServlet {
	
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
			service.upGood(dto);
			goodHistory.add(id);
		} else if(goodHistory.contains(id)) {
			service.downGood(dto);
			goodHistory.remove(id);
		}
		session.setAttribute("boardGoodHistory", goodHistory);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + id);
	}
	
}
