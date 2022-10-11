package kr.co.Exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 * 
		 * 현재 보유하고 있는 주식의 평단가 80000원, 보유 주식 수 10주,
		 * 현 주식 가격이 65000원 일 때 10주를 더 구매했을 경우의 총 구매액,
		 * 총 보유 주식수, 평단가, 수익률을 구하여 출력하세요. (수익률은 실수로 출력)
		 * 
		 * 사용자 입력으로 현재 보유 주식의 평단가, 보유 주식 수, 현 주식 가격, 추가 구매 주식 수를
		 * 받아서 풀어보세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("현재 보유 주식의 평단가 : ");
		int av = sc.nextInt();
		System.out.println("보유 주식 수 : ");
		int n = sc.nextInt();
		System.out.println("현 주식 가격 : ");
		int pr = sc.nextInt();
		System.out.println("추가 구매 주식 수 : ");
		int add = sc.nextInt();
		
		int total = (n+add);
		double nav = (av*n + pr*add)/(n+add);
		double rate = (pr - nav) ;   
		System.out.println(add + "주를 더 구매했을 경우 총 보유 주식수는 " + total);
		System.out.println(add + "주를 더 구매했을 경우 평단가는 " + nav); 
		System.out.println(add + "주를 더 구매했을 경우 수익률은 " + rate);	
				
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int holdSockPrice, holdStockCount;
		 * int presentStockPrice, presentStockCount;
		 * int totalStockPrice, totalStockCount;
		 * int averageStockPrice;
		 * double rateOfReturn;
		 * 
		 * System.out.print("보유 주식 평단가 : ");
		 * holdStockPrice = sc.nextInt();
		 * 
		 * System.out.print("보유 주식수 : ");
		 * holdStockCount = sc.nextInt();
		 * 
		 * System.out.print("현재 주식 단가 : ");
		 * presentStockPrice = sc.nextInt();
		 * 
		 * System.out.print("구입 예정 주식 수 : ");
		 * presentStockCount = sc.nextInt();
		 * 
		 * totalStockPrice = holdStockPrice * holdStockCount;
		 * totalStockPrice += presentStockPrice * presentStockCount;
		 * 
		 * totalStockCount = holdStockCount + presentStockCount;
		 * 
		 * averageStockPrice = totalStockPrice / totalStockCount;
		 * 
		 * rateOfReturn = ((double)averageStockPrice / holdStockPrice - 1) * 100;
		 *                             정수      /     정수    => 형변환 필요 
		 * 
		 * String king = rateOfReturn < 0 ? "감소" : "증가";
		 * 
		 * String message = "총 구매액 : %,d\n"
		 * 	   + "총 보유 주식수 : %d\n"
		 *     + "평단가 : %d\n"
		 *     + "수익률 : %.2f%%\n"
		 *     + "현재 자산이 %s 하였습니다.";
		 *     
		 * System.out.printf(message, totalStockPrice, totalStockCount,
		 *    , averageStockPrice, rateOfReturn, kind);
		 * 
		 */
	

	}

}
