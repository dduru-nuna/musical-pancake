package kr.co.exam03;

import java.util.Scanner;

public class Exam {

	public static boolean isNumber(String number) {
		boolean result = true;
		for(int i = 0; i < number.length(); i++) {
			if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
				return false;
			}
		}
		return result;
	}
	
	public static boolean isNumberic(String number) {
		return number.matches("[0-9]+"); // [0-9]+ : 정규표현식 중 하나, '0'~'9'까지의 문자인지 아닌지 확인
	}                                    // + 가 붙어있어야 한 자 이상 확인한다. 위의 반복문과 같은 기능을 함
	
	public static void main(String[] args) {
		/*
		 * 사용자 입력으로 정수형 문자열을 입력받아 총 합 구하기
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.println("공백을 구분자로 하는 정수를 나열하시오 : ");
		String input = sc.nextLine();
		String[] strArr = input.split(" ");
		int[] iArr = new int[strArr.length];
		
		int sum = 0;
		for(int i = 0; i < strArr.length; i++) {
			// 정수로 변환할 수 없는 문자열인 경우 0 으로 저장하게 한다.
			boolean numberValid = isNumber(strArr[i]);
			if(numberValid) {
				iArr[i] = Integer.parseInt(strArr[i]);
				sum += iArr[i];
			}
		}
		
		System.out.println("총 합 : " + sum);
	}

}
