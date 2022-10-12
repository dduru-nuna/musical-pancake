package kr.co.exam;

import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 월, 시작 요일, 마지막 일자 정보를 입력 받아
		 * 다음 예시와 같이 출력하세요.
		 * 예시
		 *    월 : 10
		 *    시작요일 : 토
		 *    마지막 일자 : 31
		 *    
		 *    10 월
		 *    일	   월	화	 수	  목	   금	 토
		 *    								 1
		 *    2    3    4	 5	  6	   7	 8
		 *    9    10   11   12   13   14    15
		 *    16   17   18   19   20   21    22
		 *    23   24   25   26   27   28    29
		 *    30   31
		 */

		/*내가 풀다 만거..
		Scanner sc = new Scanner(System.in);
		
		int month, lastDay, i;
		String firstDay;
		
		System.out.println("달을 입력하세요");
		month = sc.nextInt();
		System.out.println("시작 요일을 입력하세요");
		firstDay = sc.nextLine(); sc.nextLine();
		System.out.println("마지막 일자를 입력하세요");
		lastDay = sc.nextInt(); sc.nextLine();
		
		System.out.printf("월 : %d\n" + "시작요일 : %s\n" + "마지막 일자 : %d\n", month,firstDay,lastDay);
		System.out.println();
		System.out.println("월 : " + month);
		System.out.println("일\t" + "월\t" + "화\t" + "수\t" + "목\t" + "금\t" + "토\t");
		
		
		i = 0;
		for(i = 1; i <= lastDay; i++) {
			if(i % 7 == 0) {
				System.out.println();
			}
		} */
		
		
		//강사님 풀이
		Scanner sc = new Scanner(System.in);
		
		int month, day = 0, lastDay;
		String startDate;
		
		System.out.print("월 : ");
		month = sc.nextInt(); sc.nextLine();
		
		System.out.print("시작요일 : ");
		startDate = sc.nextLine();
		
		System.out.print("마지막 일자 : ");
		lastDay = sc.nextInt();
		
		System.out.printf("%d 월\n", month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int dateIndex = 0;
		switch(startDate) {
			case "일": //1일이 언제 시작할지에 따라 앞에 탭공백이 있어야하기 때문에 day로 초기 시작 조정
				day = 7; dateIndex = 0; break;  //개행을 위해 dateIndex값 설정
			case "월":                        //수요일부터 1일이 시작되면 4개 값만 출력되고 개행하기 위해서
				day = 6; dateIndex = 6; break;
			case "화":
				day = 5; dateIndex = 5; break;
			case "수":
				day = 4; dateIndex = 4; break;
			case "목":
				day = 3; dateIndex = 3; break;
			case "금":
				day = 2; dateIndex = 2; break;
			case "토":
				day = 1; dateIndex = 1; break;
		}
		
		
		//for(int day = dateIndex == 0 ? 0 : dateIndex - 7; day < lastDay; day++) 로 쓸수도있음
		//switch문 case에서 day 삭제하고 처음의 변수선언 day=0 도 삭제
		for(day = day - 7 + 1; day <= lastDay; day++) {
			if(day >= 1) {
				System.out.printf("%d\t", day);
				if(day % 7 == dateIndex) {
					System.out.print("\n");
				}
			} else {
				System.out.print("\t");
			}
		}
		
		/*또다른 풀이
		 * int dateIndex = 0;
		   switch(startDate) {
			case "일":
				dateIndex = 0; break;  
			case "월":                        
				dateIndex = 1; break;
			case "화":
				dateIndex = 2; break;
			case "수":
				dateIndex = 3; break;
			case "목":
				dateIndex = 4; break;
			case "금":
				dateIndex = 5; break;
			case "토":
				dateIndex = 6; break;
		  }
		  for(int day = dateIndex; day > 0; day--) {
		  	 System.out.print("\t");
		  }
		  dateIndex = dateIndex == 0 ? 7 : dateIndex;
		  for(int day = 0; day < lastDay; day++) {
		  	 System.out.printf("%d\t", day+1);
		  	 if((day+1) % 7 == 7 - dateIndex) {
		  	 	System.out.print("\n");
		  	 }
		  }
		
		 */
	}

}
