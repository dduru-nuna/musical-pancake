package listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
		//속성이 set, 수정, remove 될 때 실행(추가,삭제,수정)
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		ServletContextAttributeListener.super.attributeAdded(event);
		System.out.println("ServletContext 에 데이터 추가됨 -" + event.getName() + ":" + event.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		ServletContextAttributeListener.super.attributeRemoved(event);
		System.out.println("ServletContext 에 데이터 삭제됨 -" + event.getName() + ":" + event.getValue());
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		ServletContextAttributeListener.super.attributeReplaced(event);
		System.out.println("ServletContext 에 데이터 수정됨 -" + event.getName() + ":" + event.getValue());
	}
}
