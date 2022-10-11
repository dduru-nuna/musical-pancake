package kr.co.Exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 문제를 풀어보세요.
		 * 
		 * 카카오의 더치페이 기능을 모방하여 다음의 출력 결과가 나오도록 하세요.
		 * 
		 * 출력 형식
		 *     총 비용 50000원을 5명이 더치페이하여 10000원씩 다음의 계좌로 입금해주세요.
		 *     입금 계좌번호 : 1234-56-789-123456789
		 *     나머지 금액 0원은 제가 부담합니다.
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.println("계좌번호 : ");
		String bank = sc.nextLine();
		
		System.out.println("총 비용을 입력하세요 : ");
		int total = sc.nextInt();
		
		System.out.println("총 인원수를 입력하세요 : ");
		int n = sc.nextInt();
		
		System.out.println("총 비용 " + total + "원을 " + n + "명이 더치페이하여 " 
				+ (total/n) +"원씩 다음의 계좌로 입금해주세요.");
		System.out.println("입금 계좌번호 : " + bank);
		System.out.println("나머지 금액 " + (total%n) + "원은 제가 부담합니다.");
		
		
		/* Scanner sc = new Scanner(System.in);
		 * 
		 * int totalAmount, count, perAmount, leftAmount;
		 * String bankNumber;
		 * 
		 * System.out.print("입금 계좌 번호 : ");
		 * bankNumber = sc.nextLine();
		 * 
		 * System.out.print("총 비용 : ");
		 * totalAmount = sc.nextInt();
		 * 
		 * System.out.print("총 인원 : ");
		 * count = sc.nextInt();
		 * 
		 * perAmount = totalAmount / count;
		 * leftAmount = totalAmount % count;
		 * 
		 * String message = "총 비용 %d 원을 %d 명이 더치페이 하여 %d 원씩 \n"
		 * + "다음의 계좌로 입금해주세요.\n"
		 * + "입금 계좌 번호 : %s\n"
		 * + "나머지 금액 %d 원은 제가 부담합니다.";
		 * 
		 *                         금액단위 %d 를 %,d 로 쓰면 천단위 표기됨
		 * 
		 * System.out.printf(message, totalAmount, count, perAmount, bankNumber, leftAmount);
		 * 
		 */
		
	}

}
