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
import model.dto.BoardImageDTO;
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
		List<BoardImageDTO> images = service.getImages(data);
		
		if(data != null) {
			req.setAttribute("data", data);
			req.setAttribute("images", images);
			req.getRequestDispatcher("/WEB-INF/view/board/detail.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(id));
		
		BoardService service = new BoardService();
		BoardDTO data = service.getData(dto);
		//이미지 업로드하면 ""가 들어가서 json 형식으로 제대로 보내지지 않음. 따라서 replace 로 '' 로 변경해줌
		resp.getWriter().print("{\"context\": \"" + data.getContext().replace("\"", "'") + "\"}");
		resp.getWriter().flush();
	}
}
