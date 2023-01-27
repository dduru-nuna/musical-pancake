package controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.service.BoardService;

@WebServlet("/board/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); //세션 유지되는 동안은 id 별 조회수가 한번만 올라가도록 세션 설정
		List<Integer> history = (List<Integer>)session.getAttribute("boardViewHistory");
		//MyHttpSession 리스너에 setAttribute boardViewHistory 함
		String id = req.getParameter("id");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(id));
		
		BoardService service = new BoardService();
		if(!history.contains(Integer.valueOf(id))) { //id가 있다는 것은 조회 기록이 있다는 것
			service.upViewCnt(dto);
			history.add(Integer.valueOf(id));
			session.setAttribute("boardViewHistory", history);
		}
		BoardDTO data = service.getData(dto);
		
		req.setAttribute("data", data);		
		req.getRequestDispatcher("/WEB-INF/view/board/detail.jsp").forward(req, resp);
	}
}
