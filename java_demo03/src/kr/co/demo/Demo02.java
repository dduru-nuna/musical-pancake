package kr.co.demo;

import java.util.Scanner;  // import는 가져오기 기능

public class Demo02 {

	public static void main(String[] args) {
		// 사용자 입력을 받을 때 사용하는 클래스 -> Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int x1 = sc.nextInt();  sc.nextLine();
		System.out.println("사용자 입력으로 정수값 " + x1 + "을 입력 받아 x1 변수에 저장하였습니다.");
		
		System.out.print("실수값 입력 : ");
		double y1 = sc.nextDouble(); sc.nextLine();  //sc.nextLine(); 입력해줘야 엔터값을 입력받아 문자열 입력값을 받아준다
		
		System.out.println("사용자 입력으로 실수값 " + y1 + "을 입력 받아 y1 변수에 저장하였습니다.");
		
		System.out.print("문자열 입력 : ");
		String s1 = sc.nextLine();
		
		System.out.println("사용자 입력으로 문자열값 " + s1 + "을 입력 받아 s1 변수에 저장하였습니다.");
		
		
	}

}
