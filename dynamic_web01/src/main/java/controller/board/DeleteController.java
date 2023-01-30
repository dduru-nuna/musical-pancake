package controller.board;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.dto.Role;
import model.dto.UserDTO;
import model.service.BoardService;

@WebServlet("/board/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		String id = req.getParameter("id");
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(id));
		
		BoardService service = new BoardService();
		BoardDTO data = service.getData(dto);
		
		if(((Role)session.getAttribute("role")).isAdmin()) {
			boolean result = service.delete(data);
			resp.sendRedirect(req.getContextPath() + "/board");
		} else {
			if(data.getWriter().equals(user.getUserId())) {
				boolean result = service.delete(data);
				if(result) {
					resp.sendRedirect(req.getContextPath() + "/board");
				} else {
					resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + data.getId());
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/error");
			}
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String[] ids = req.getParameterValues("chk_id");
		if(((Role)session.getAttribute("role")).isAdmin()) {
			BoardService service = new BoardService();
			int[] arrId = new int[ids.length];
			for(int i = 0; i < ids.length; i++) {
				arrId[i] = Integer.parseInt(ids[i]);
			}
			service.delete(arrId);
		}
		resp.sendRedirect(req.getContextPath() + "/board");
	}
}
