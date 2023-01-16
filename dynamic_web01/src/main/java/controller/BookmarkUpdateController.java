package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BookmarkDTO;
import model.service.BookmarkService;

public class BookmarkUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		
		BookmarkService service = new BookmarkService();
		BookmarkDTO data = service.getId(dto);
		
		req.setAttribute("data", data);
		req.getRequestDispatcher("/WEB-INF/view/bookmarkupdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String url = req.getParameter("url");
		String name = req.getParameter("name");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		dto.setUrl(url);
		dto.setName(name);
		
		BookmarkService service = new BookmarkService();
		boolean result = service.update(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		} else {
			resp.sendRedirect("../error");
		}
	}
}

