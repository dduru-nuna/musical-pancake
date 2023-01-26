package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.BoardService;
import paging.Paging;

@WebServlet("/board")
public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");
		if(p == null) {
			p = "1";
		} else if(p.isEmpty()) {
			p = "1";
		}
		int pageNumber = Integer.parseInt(p);
		int pageLimit = 10;
		
		BoardService service = new BoardService();
		Paging data = service.getPage(pageNumber, pageLimit);
		System.out.println(data.getData());
		req.setAttribute("paging", data);
		req.getRequestDispatcher("/WEB-INF/view/board/main.jsp").forward(req, resp);
	}
}
