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
			/*
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
				continue;
			}
			
			boolean isNumber = true;
			String phoneArr[] = input.split("-");
			
			for(int i = 1; i < phoneArr.length; i++) { // 010은 이미 체크했으니 인덱스 1부터 확인
				for(int j = 0; j < phoneArr[i].length(); j++) {
					if(!(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9')) {
						System.out.println("0 ~ 9에 해당하는 숫자가 아닙니다.");
						isNumber = false;
						break;
					}
				}
				if(!isNumber) { //중첩 반복문이라 한번 더 break
					break;
				}
			}
			
			if(!isNumber) {
				continue;
			}
			
			boolean cntError = false;
			for(int i = 1; i < phoneArr.length; i++) {
				if(phoneArr[i].length() != 4) {
					cntError = true;
					break;
				}
			}
			if(cntError) {
				System.out.println("전화번호는 010-4자리-4자리 여야 합니다.");
				continue;
			}
			*/
			Phone phone = Phone.valuOf(input);
			
			if(phone.isInvalid()) {
				switch(phone.reason()) {
				case Phone.PREFIX_ERROR:
					System.out.println("전화번호는 010으로 시작해야 합니다.");
					break;
				case Phone.DELIMITER_ERROR:
					System.out.println("전화번호는 - 구분자만 사용해야 합니다.");
					break;
				case Phone.FORMATTING_ERROR:
					System.out.println("전화번호 형식이 잘못되었습니다.");
					break;
				case Phone.LENGTH_ERROR:
					System.out.println("전화번호의 길이를 다시 확인하세요.");
					break;
				case Phone.NUMBER_ERROR:
					System.out.println("전화번호에 숫자가 아닌 문자가 있습니다.");
					break;
				}
				continue;
			} else {
				System.out.println("전화번호 출력 : " + phone.getNumber(true));
			}
			break;
			
		}
	}

}
