package kr.co.vo;

import java.sql.Date;
import java.util.Objects;

public class AccountVO {
	//이름을 db 와 매치시켜줘야한다 (mybatis에서 이름으로 매치시켜주는 기능이 있어서 다르면 null 이 나옴)
	private int id; // ID NUMBER PRIMARY KEY
	private String nickname; // NICKNAME VARCHAR2(35) UNIQUE
	private String email; // EMAIL VARCHAR2(100) UNIQUE
	private char isAllow; // ISALLOW CHAR(1) DEFAULT('N') CHECK (ISALLOW IN ('N', 'Y'))
	private Date reqDate; // REQDATE DATE DEFAULT(SYSDATE)
	private String password;
	private Date loginDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getIsAllow() {
		return isAllow;
	}
	public void setIsAllow(char isAllow) {
		this.isAllow = isAllow;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getloginDate() {
		return loginDate;
	}
	public void setloginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountVO other = (AccountVO) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", isAllow=" + isAllow
				+ ", reqDate=" + reqDate + ", password=" + password + ", loginDate=" + loginDate + "]";
	}
	
	
}
