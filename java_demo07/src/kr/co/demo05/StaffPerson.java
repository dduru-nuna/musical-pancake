package kr.co.demo05;

import java.util.Objects;

public class StaffPerson implements Staff {
	
	private String name;
	private int age;
	
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
		return "StaffPerson [name=" + name + ", age=" + age + "]";
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
		StaffPerson other = (StaffPerson) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	@Override
	public void remove() {
		System.out.println("Person 클래스의 remove() 메서드");
	}
	
	@Override
	public void write() {
		System.out.println("Person 클래스의 write() 메서드");
	}
	
	@Override
	public void view() {
		System.out.println("Person 클래스의 view() 메서드");
	}
	@Override
	public void update() {
		System.out.println("Person 클래스의 update() 메서드");
	}
}
