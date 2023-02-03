package listener;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import model.dto.Role;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSessionListener.super.sessionCreated(se);
		HttpSession session = se.getSession();
		session.setAttribute("login", false); //기본 로그인 상태를 false라고 지정해서 이전에 null인 경우로 따지지 않아도 됨
		session.setAttribute("boardViewHistory", new ArrayList<Integer>()); //조회 기록이 있는지 확인(id 확인)
		session.setAttribute("role", new Role("GUEST")); //기본 역할을 게스트로 지정
		session.setAttribute("boardGoodHistory", new ArrayList<Integer>());
		session.setAttribute("boardBadHistory", new ArrayList<Integer>());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSessionListener.super.sessionDestroyed(se);
		System.out.println("세션이 소멸되었습니다.");
	}
}
