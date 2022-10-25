package kr.co.exam02;

public class Staff extends Member {

	public void delete() {
		System.out.println("글을 삭제합니다.");
	}

	@Override
	public String toString() {
		return "Staff [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	
	
}
