package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet{

	//요청 form method 가 "get" or "post" 이냐에 따라 나뉨. 또는 a 링크 클릭하는 것 = "get", 사용자가 입력하고 그거를 처리하게 보내는 것은 거의 "post"
	//get 이냐 post 이냐인 것은 개발자가 정하는 것이기 때문에 어떤 메서드(doGet, doPost)를 써야할지 알 수 있다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 GET 요청을 보냈습니다.");
	}
}
