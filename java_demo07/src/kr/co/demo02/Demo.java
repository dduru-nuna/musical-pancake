package kr.co.demo02;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		/*
		 * java.lang.Object
		 * 	   자바의 모든 클래스는 java.lang.Object 클래스를 상속하며
		 *     Object 클래스는 다음의 메서드를 포함하고 있다.
		 *     
		 *     toString() 메서드
		 *        객체를 읽을 수 있는 문자열로 변환하여 반환하는 메서드
		 *        
		 *     equals() 메서드
		 *        동일 참조 주소 또는 동일 값을 가지는 객체인지 구분하고
		 *        true/false 를 반환하는 메서드
		 */
		
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setName("홍길동");
		p1.setAge(23);
		p1.setGender('M');
		
		p2.setName("홍길동");
		p2.setAge(23);
		p2.setGender('M');
		
		System.out.println(p1);
		System.out.println(p1.toString());
		
		Person pArr[] = new Person[3];
		pArr[0] = new Person();
		pArr[1] = new Person();
		pArr[2] = new Person();
		
		pArr[0].setName("김철수");
		pArr[1].setName("박주하");
		pArr[2].setName("곽호연");
		
		System.out.println(Arrays.toString(pArr));
		System.out.println(p1.equals(p2));
		
	}

}
