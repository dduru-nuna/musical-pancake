package controller.ajax;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

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
		
		JsonFactory jf = new JsonFactory();
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createGenerator(sw);
		
		jg.writeStartObject();
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
//			json += "\"type\": \"success\",";
//			json += "\"count\": " + data.getGood();
			jg.writeStringField("type", "success");
			jg.writeNumberField("count", data.getGood());
			
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
//			json += "\"type\": \"success\",";
//			json += "\"count\": " + data.getBad();
			jg.writeStringField("type", "success");
			jg.writeNumberField("count", data.getBad());
		} else {
//			json += "\"type\": \"error\",";
//			json += "\"msg\": \"잘못된 타입 입니다.\",";
			jg.writeStringField("type", "error");
			jg.writeStringField("msg", "잘못된 타입 입니다.");
		}
		jg.writeEndObject();
		jg.close();
		
		resp.getWriter().print(sw.toString());
		resp.getWriter().flush();
	}
}
