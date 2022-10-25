package kr.co.demo02;

public class Person {

	private String name;
	private int age;
	private char gender;
	
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	//Source 메뉴에서 toString 자동으로 만든 버전
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	//Source 메뉴에서 generate hashCode and equals 자동 만들기 가능
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		// equals 오버라이딩을 통해 두 객체를 비교하는 값들을 조작할 수 있다
		// 여기선 이름과 나이가 같은지 확인하도록 만듦
		if(name.equals(person.name) && age == person.age) {
			return true;
		}
		return false;
	}
}
