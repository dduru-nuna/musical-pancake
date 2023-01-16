package model.dto;

public class VisitDTO {  //DTO 역할은 매개변수 저장해서 다른 객체에 전달하기 위한 용도
	
	private int id;
	private String context;
	private String nickname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "VisitDTO [id=" + id + ", context=" + context + ", nickname=" + nickname + "]";
	}
	
}
