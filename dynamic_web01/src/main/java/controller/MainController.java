package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet{

	//요청 form method 가 "get" or "post" 이냐에 따라 나뉨. 또는 a 링크 클릭하는 것 = "get", 사용자가 입력하고 그거를 처리하게 보내는 것은 거의 "post"
	//get 이냐 post 이냐인 것은 개발자가 정하는 것이기 때문에 어떤 메서드(doGet, doPost)를 써야할지 알 수 있다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n = req.getParameter("num"); //input name과 동일해야함. type="number"라고 해서 number형이 아니라 단순히 숫자를 입력받게 해주는 것. getParameter 는 항상 String으로 받음
		Integer number = 0;
		if(n != null && !n.isEmpty()) {   //n을 숫자타입으로 변환하기
			number = Integer.parseInt(n);
		}               //   속성명, 속성값
		req.setAttribute("number", number); //setAttribute 에서는 number 가 object로 업캐스팅 된다
		req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp); //사용자에게 보여줄 jsp 를 실행해라(forward로 요청,응답 객체 jsp에 함께 전달)
	}
}
