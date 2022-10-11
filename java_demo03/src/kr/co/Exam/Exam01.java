package kr.co.Exam;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 * 
		 * 사용자 입력으로 키(m), 몸무게(kg) 를 tall, weight 변수에
		 * 저장하여 BMI 지수를 구하고 출력하세요.
		 * 
		 * BMI 지수는 몸무게(kg) / 키(m)^2 으로 구합니다.
		 * 
		 * 출력 형식
		 *   당신의 BMI 지수 값은 23.52 입니다.
		 */

		Scanner sc = new Scanner(System.in);
		
		double tall, weight, bmi;
		
		System.out.println("키(m)를 입력하세요 : "); // 입력단위 확인필
		tall = sc.nextDouble();
		
		System.out.println("몸무게(kg)를 입력하세요 : ");
		weight = sc.nextDouble();
		
		bmi = weight / (tall * tall);
		
		System.out.printf("당신의 BMI 지수 값은 %.2f 입니다.", bmi);
	}

}
