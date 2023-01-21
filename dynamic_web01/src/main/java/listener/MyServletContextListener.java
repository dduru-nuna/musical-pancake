package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override  //어플리케이션(서버) 전역적으로 사용할 데이터가 있으면 여기에서 셋팅하면 된다.
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("컨텍스트 객체가 생성되었습니다");
		sce.getServletContext().setAttribute("hello", "안녕하세요");
	}
	
	@Override //어플리케이션(서버) 종료될 때 해야할게 있으면 여기에 셋팅
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("컨텍스트 객체가 소멸되었습니다");
	}
	
	
}
