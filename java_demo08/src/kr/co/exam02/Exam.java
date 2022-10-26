package kr.co.exam02;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 전화번호를 입력 받고 입력 받은 전화번호의 일부 내용을 
		 * 숨겨서 출력하기 위한 기능을 구현하세요.
		 *   1. 전화번호 형식은 반드시 010 으로 시작하는 문자열이어야 합니다.
		 *   2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
		 *   3. 전화번호의 2번째 3번째 번호는 반드시 4자리여야 합니다.
		 *   4. 사용자가 입력한 전화번호는 출력할 때 일부 내용이 숨김 처리되어야 합니다.
		 *         입력 : 010-1234-5678
		 *         출력 : 010-1234-****
		 */
		
		Scanner sc = new Scanner(System.in);
		/* 내가푼거
		System.out.println("전화번호를 입력하세요 : ");
		String input = sc.nextLine();
		boolean isStarts = input.startsWith("010");
		if(isStarts) {
			input = String.join("-", input.substring(0,3), input.substring(3,7), String.format("****",input.substring(7)));
			System.out.println(input);
		} else {
			System.out.println("010으로 시작하는 번호를 입력하세요");
		}
		*/
		
		while(true) {
			System.out.print("전화번호 입력 : ");
			String input = sc.nextLine();
			
			if(input.contains("exit")) {
				break;
			}
			
			if(!input.startsWith("010")) {
				System.out.println("010으로 시작하는 번호를 입력하세요.");
				continue;
			}
			
			if(input.length() != 13) {
				System.out.println("하이픈(-)을 포함한 13자리 번호를 입력하세요");
				continue;
			}
			if(input.split("-").length != 3) {
				System.out.println("올바른 전화번호 형식이 아닙니다.");
			}
			
			boolean isNumber = true;
			String phoneArr[] = input.split("-");
			
			
			for(int i = 0; i < phoneArr.length; i++) {
				for(int j = 0; j < phoneArr[i].length(); j++) {
					if(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9') {
						isNumber = false;
						break;
					}
				}
				if(!isNumber) {
					break;
				}
			}
			
			if(!isNumber) {
				continue;
			}
			
			phoneArr[2] = "****";
			System.out.println("전화번호 출력 : "+  String.join("-", phoneArr));
		}
	}

}
