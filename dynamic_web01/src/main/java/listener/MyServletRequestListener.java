package listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

//@WebListener 
public class MyServletRequestListener implements ServletRequestListener {
	
	@Override  //요청이 되면 실행
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequestListener.super.requestInitialized(sre);
		System.out.println("Request 객체가 생성되었습니다.");
	//	HttpServletRequest req = (HttpServletRequest)sre.getServletRequest(); 상위 객체인 ServletRequest 로 반환하니 만약 HttpServletRequest 로 반환하려면 다운캐스팅 필요
	}
	
	@Override  //응답되면 실행
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequestListener.super.requestDestroyed(sre);
		System.out.println("Request 객체가 소멸되었습니다.");
	}
}
