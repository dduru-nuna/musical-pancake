package model.dto;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
//userDTO 가 세션에 바인딩(데이터를 붙였을 때) 됐을 때만 리스너 실행-(메세지출력) 
public class UserDTO implements HttpSessionBindingListener {

	private String userId;
	private String password;
	private String email;
	private String pImg;
	
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", email=" + email + "]";
	}
	
	@Override  //dto데이터 set 할 때
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSessionBindingListener.super.valueBound(event);
		HttpSession session = event.getSession(); //set 됐을 때 세션에 추가할 것이 있으면 여기서 설정
		session.setAttribute("login", true);
	}
	
	/*
	@Override  //dto데이터 remove, invalidate 할 때
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSessionBindingListener.super.valueUnbound(event);
		HttpSession session = event.getSession(); //remove,invalidate 됐을 때 세션에 추가할 것이 있으면 여기서 설정
		session.setAttribute("login", false);
	}
	*/
}
