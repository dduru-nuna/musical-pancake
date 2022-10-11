package kr.co.exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 키(m)와 체중(kg) 값을 
		 * 입력 받아 BMI 를 구하여 결과값을 출력할 때 25 이상인 경우
		 * "비만입니다." 라는 메시지가 출력되도록 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키(m) : ");
		double tall = sc.nextDouble();
		
		System.out.println("체중(kg) : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (tall * tall);
		System.out.printf("BMI : %.2f\n" , bmi);
		
		if(bmi > 25) {
			System.out.println("비만입니다.");
		}
	
		
	}

}
