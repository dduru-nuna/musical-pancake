package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserDTO;
import model.service.UserService;

@WebServlet("/ajax/userIdCheck")
public class UserIdCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		
		UserService service = new UserService();
		UserDTO data = service.getData(dto);

		//사용자가 입력한 아이디가 기존에 있는 아이디인지 아닌지 확인
/*		String json = "{";
		if(data == null) {
			json += "\"msg\": \"OK\""; //json에서 (키: 문자열) 형식 "" 을 사용해야 하니 escape 필요			
		} else {
			json += "\"msg\": \"Fail\"";
		}
		json += "}"; */
		
		
		//jackson 라이브러리 적용하면 이런식으로 사용할 수 있다. escape 신경쓰지 않아도 됨
		JsonFactory jf = new JsonFactory();
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createGenerator(sw);
		
		jg.writeStartObject();  //"{"
		if(data == null) {
			jg.writeStringField("msg", "OK");
		} else {
			jg.writeStringField("msg", "Fail");	
		}
		jg.writeEndObject();  //"}"
		
		jg.close();
		
		PrintWriter out = resp.getWriter();
		out.println(sw.toString());
		out.flush(); //버퍼에 남아있는 데이터 모두 전송
	}
}
