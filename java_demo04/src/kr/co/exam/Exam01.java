package kr.co.exam;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if문을 활용하여 사용자로부터 정수값을 입력 받았을때 1 ~ 45 사이의
		 * 값만 출력하게 하시오.
		 */

		Scanner sc = new Scanner(System.in);
		// 
		int x = sc.nextInt();
		
		if(x > 0 && x < 46) {
			System.out.print(x);
		} else {
			System.out.print("1 ~ 45 사이의 값만 입력하세요");
		}
		
		/*
		 * int x;
		 * System.out.print("정수값 입력 : ");
		 * x = sc.nextInt();
		 * 
		 * if(x>=1) {
		 *    if(x/,=45) {
		 *       System.out.prinf("사용자가 입력한 값 -> %d", x);
		 *    }
		 * }
		 * 
		 * 또는
		 * if(x>=1 && x<=45) {
		 *       System.out.prinf("사용자가 입력한 값 -> %d", x);
		 * }
		 */
				
	}

}
