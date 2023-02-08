package controller.ajax;

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

@WebServlet("/ajax/recommend")
public class RecommendController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> goodHistory = (List<Integer>)session.getAttribute("boardGoodHistory");
		List<Integer> badHistory = (List<Integer>)session.getAttribute("boardBadHistory");
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(id.intValue());
		
		BoardService service = new BoardService();
		String json = "{";
		if(type.equals("good")) {
			if(!goodHistory.contains(id) && !badHistory.contains(id)) {
				service.upGood(dto);
				goodHistory.add(id);
			} else if(goodHistory.contains(id)) {
				service.downGood(dto);
				goodHistory.remove(id);
			}
			session.setAttribute("boardRecCntHistory", goodHistory);
			BoardDTO data = service.getData(dto);
			json += "\"type\": \"success\",";
			json += "\"count\": " + data.getGood();
		} else if(type.equals("bad")) {
			if(!goodHistory.contains(id) && !badHistory.contains(id)) {
				service.upBad(dto);
				badHistory.add(id);
			} else if(badHistory.contains(id)) {
				service.downBad(dto);
				badHistory.remove(id);
			}
			session.setAttribute("boardNRecCntHistory", badHistory);
			BoardDTO data = service.getData(dto);
			json += "\"type\": \"success\",";
			json += "\"count\": " + data.getBad();
		} else {
			json += "\"type\": \"error\",";
			json += "\"msg\": \"잘못된 타입 입니다.\",";
		}
		json += "}";
		
		resp.getWriter().print(json);
		resp.getWriter().flush();
	}
}
