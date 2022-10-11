package weekendexam;

import java.util.Scanner;

public class Exam1007 {

	public static void main(String[] args) {
		/*
		 * 1. 년도 값을 입력 받아 해당 년도가 윤년인지 아닌지 구하세요.
		 *   - 윤년은 4의 배수이면 윤년이 됩니다.
		 *   - 4의 배수이면서 100의 배수이면 윤년이 아닙니다.
		 *   - 4, 100, 400 의 배수에 해당하면 윤년입니다.
		 *  ex. 년도 : 2022
		 *      윤년이 아닙니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년도를 입력하세요.");
		int year = sc.nextInt();
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println("년도 : " + year + "\n윤년입니다.");
		} else {
			System.out.println("년도 : " + year + "\n윤년이 아닙니다.");
		}
		
		/*
		 * 2. 2022년 10월 달력을 참고하여 사용자가 입력한 일자가 무슨 요일인지 출력하세요.
		 *  ex. 일자 : 10
		 *      월요일 입니다.
		 */
		System.out.print("=================\n");
		System.out.println("일자를 입력하세요.");
		int date = sc.nextInt();
		
		if(date == 3 || date == 10 || date == 17 || date == 24 || date == 31) {
			System.out.println("일자 : " + date + "\n월요일 입니다.");
		} if(date == 4 || date == 11 || date == 18 || date == 25) {
			 System.out.println("일자 : " + date + "\n화요일 입니다.");
		 } if(date == 5 || date == 12 || date == 19 || date == 26) {
			  System.out.println("일자 : " + date + "\n수요일 입니다.");
		  }	if(date == 6 || date == 13 || date == 20 || date == 27) {
			   System.out.println("일자 : " + date + "\n목요일 입니다.");
		   } if(date == 7 || date == 14 || date == 21 || date == 28) {
				 System.out.println("일자 : " + date + "\n금요일 입니다.");
		    } if(date == 8 || date == 15 || date == 22 || date == 29) {
				  System.out.println("일자 : " + date + "\n토요일 입니다.");	
		     } if(date == 9 || date == 16 || date == 23 || date == 30) {
					System.out.println("일자 : " + date + "\n일요일 입니다.");	
		     }
	}

}
