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
		
		if(bmi >= 25) {
			System.out.println("비만입니다.");
		} else {
			System.out.println("비만이 아닙니다.");
		}
	
		/*
		 * String message = "비만입니다.";
		 * if(bmi < 25) {
		 *     message = "비만이 아닙니다.;
		 * }
		 * System.out.println(message);
		 * 
		 * ------------------------------
		 * String message = bmi < 25 ? "비만이 아닙니다." : "비만입니다.";
		 * System.out.println(message);
		 */
		
		/*  숙제 풀이
		 * 1.
		 * int year;
		 * String message = "";
		 * year = sc.nextInt();
		 * 
		 * if(year % 4 == 0) {
		 *   if(year % 100 == 0) {
		 *     if(year % 400 == 0) {
		 *        message = "%d 년은 윤년입니다.");
		 *     } else {
		 *        message = "%d 년은 윤년이 아닙니다.");
		 *     }
		 *   } else {
		 *      message = "%d 년은 윤년입니다.");
		 *   }
		 * } else {
		 *    message = "%d 년은 윤년이 아닙니다.");
		 * }
		 * 
		 * System.out.printf(message, year);
		 * 
		 * 2.
		 * int day;
		 * System.out.print("일자 : ");
		 * day = sc.nextInt();
		 * 
		 * if(day % 7 == 0) {
		 *    message = "금";
		 * } else if(day % 7 == 1) {
		 *    message = "토";
		 * } else if(day % 7 == 2) {
		 *    message = "일";
		 * } else if(day % 7 == 3) {
		 *    message = "월";
		 * } else if(day % 7 == 4) {
		 *    message = "화";
		 * } else if(day % 7 == 5) {  
		 *    message = "수";
		 * } else if(day % 7 == 6) { 
		 *    message = "목";
		 * }
		 * 
		 * System.out.printf("%s요일 입니다.", message);
		 */	 
	}

}
