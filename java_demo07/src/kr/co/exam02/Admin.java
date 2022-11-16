package kr.co.exam02;

public class Admin extends Member {

	public void deleteRight() {
		System.out.println("스태프 권한이 삭제되었습니다.");
	}
	
	public void addRight() {
		System.out.println("스태프 권한이 추가되었습니다.");
	}
	
	public void deleteAccount() {
		System.out.println("멤버 탈퇴 되었습니다.");
	}
	
	public void addAccount() {
		System.out.println("멤버 가입 되었습니다.");
	}

	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	
	
}
