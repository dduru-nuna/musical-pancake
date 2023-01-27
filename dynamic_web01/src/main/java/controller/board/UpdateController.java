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

@WebServlet("/board/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(id));
		
		BoardService service = new BoardService();
		BoardDTO data = service.getData(dto);
		
		//여기서도 작성자와 로그인 사용자가 일치할 때만 수정페이지가 보이도록 작업해야함(완료)
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		if(data.getWriter().equals(user.getUserId())) {
			req.setAttribute("data", data);
			req.getRequestDispatcher("/WEB-INF/view/board/update.jsp").forward(req, resp);	
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(id));
		
		BoardService service = new BoardService();
		BoardDTO data = service.getData(dto);
		
		if(data.getWriter().equals(user.getUserId())) {  //작성자와 로그인 사용자가 같을 때만 수정작업 가능하게
			data.setTitle(title);
			data.setContext(context);
			
			boolean result = service.updateData(data);
			if(result) {
				resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + data.getId());
			} else {
				req.getRequestDispatcher("/WEB-INF/view/board/update.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
		}
		
	}
}
