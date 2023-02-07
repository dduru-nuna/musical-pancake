package controller.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.dto.BoardDTO;
import model.dto.BoardImageDTO;
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
		ServletContext sc = req.getServletContext();
		
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContext(context);
		dto.setWriter(((UserDTO)session.getAttribute("user")).getUserId());
		dto.setBtype("B");
		if(req.getParameter("notice") != null) {  //공지사항 체크박스가 체크되어 있으면 글 타입을 N(공지) 으로 설정 
			if(req.getParameter("notice").equals("yes")) {
				dto.setBtype("N");			
			}
		}
		
		int maxFileSize = Integer.parseInt(sc.getInitParameter("maxFileSize"));
		String permitFileType = sc.getInitParameter("permitFileType");
		String[] permitFileExt = sc.getInitParameter("permitFileExt").split(",");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String path = "/static/img/board/" + df.format(new Date()) + "/";
		String realPath = sc.getRealPath(path);
		File f = new File(realPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		Collection<Part> parts = req.getParts();
		List<BoardImageDTO> boardImageList = new ArrayList<BoardImageDTO>();
		for(Part part: parts) {
			if(part.getName().equals("imageUpload")) {
				if(part.getSize() <= maxFileSize) {
					if(part.getContentType().startsWith(permitFileType)) {
						if(part.getContentType().endsWith(permitFileExt[0]) ||
								part.getContentType().endsWith(permitFileExt[1])) {
							part.write(String.join("/", realPath, part.getSubmittedFileName()));
							BoardImageDTO boardImageDTO = new BoardImageDTO();
							boardImageDTO.setPath(path);
							boardImageDTO.setName(part.getSubmittedFileName());
							boardImageList.add(boardImageDTO);
						}
					}
				}
			}
		}
		
		BoardService service = new BoardService();
		boolean result = service.add(dto, boardImageList);
		if(result) {
			resp.sendRedirect(req.getContextPath() + "/board/detail?id=" + dto.getId());
		} else {
			req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
		}
	}
}
