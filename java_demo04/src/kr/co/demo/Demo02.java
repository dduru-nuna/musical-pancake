package kr.co.demo;

import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {
		/*
		 * 문자열 비교
		 */
		Scanner sc = new Scanner(System.in);
		
		String s1, s2;
		s1 = "Hello";
		
		System.out.print("Hello 라고 입력하세요. : ");
		s2 = sc.nextLine();
		
		//문자열 비교는 반드시 equals 사용
		if(s1.equals(s2)) {
		    System.out.println("입력한 문자열이 Hello 입니다.");
		} else {
			System.out.println("입력한 문자열이 Hello 가 아닙니다.");
		}
		//정수,실수,불린은 변수공간에 값이 들어가 있지만 문자열은 변수공간에 참조값(메모리위치값) 이 있다.
		//s1 이 참조하는 위치와 s2 가 참조하는 위치는 달라도 equals를 사용하면 그 메모리 안의 값을 비교가능
		
	}

}
