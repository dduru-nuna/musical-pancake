package kr.co.exam;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if문을 활용하여 사용자로부터 정수값을 입력 받았을 때
		 * 5의 배수 값만 출력하게 하세요.
		 */
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		if(x % 5 == 0) {
			System.out.print(x);
		} else {
			System.out.print("5의 배수 값만 입력하세요");
		}
	}

}