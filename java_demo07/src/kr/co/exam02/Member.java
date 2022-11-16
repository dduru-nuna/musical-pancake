package kr.co.exam02;

import java.util.Objects;

public class Member {

	// 강사님 깃허브 업로드 내용 다시 확인. 내가 친거랑 다름
	
	
	private String name;
	private int age;
	
	public void write() {
		System.out.println(getName() + "이(가) 글을 작성합니다.");
	}
	
	public void read() {
		System.out.println(getName() + "이(가) 글을 읽습니다.");
	}
	
	public void remove() {
		System.out.println(getName() + "이(가) 글을 수정합니다.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}
