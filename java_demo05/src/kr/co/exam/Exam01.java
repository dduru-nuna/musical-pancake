package kr.co.exam;

public class Exam01 {

	public static void main(String[] args) {
		/*
		 * 배열 크기가 3인 정수 배열을 만들고 3부터 시작하는 3의 배수 값으로 
		 * 초기화 후 출력하세요.
		 */
		
		int arr1[] = new int[3];
		
		int i = 0, n = 3;
		while(i < arr1.length) {
			arr1[i] = n;
			i++; n+=3;
		}
		
		for(i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		System.out.println();
		
		/*
		 * 배열 크기가 5인 정수 배열을 만들고 5부터 -1씩 감소된 값으로 초기화 후 출력하세요.
		 */

		int arr2[] = new int[5];
		
		i = 0;
		while(i < arr2.length) {
			arr2[i] = arr2.length - i;
			i++;
		}
		
		for(i = 0; i < arr2.length; i++) {
			System.out.printf("%d\t", arr2[i]);
		}
		System.out.println();
		/*
		 * Exam02.java 파일을 생성 후 다음의 문제를 풀어보세요.
		 * 사용자 입력으로 5 ~ 10 사이의 정수 값을 입력 받아
		 * 입력 받은 정수값과 동일한 크기의 배열을 생성하세요.
		 * 그리고 배열의 값은 -1 로 초기화 하세요.
		 */
		
		/*
		 * Exam03.java 파일을 생성 후 다음의 문제를 풀어보세요.
		 * 사용자 입력으로 2 ~ 5 사이의 정수 값을 입력 받아 입력 받은 정수값과
		 * 동일한 크기의 배열을 생성 하고, 배열의 값을 초기화 하기 위해 다시 
		 * 사용자 입력을 사용하여 1 ~ 10 사이의 값만을 입력 받아 초기화 하세요.
		 */
		
		/*
		 * Exam04.java 파일을 생성 후 다음의 문제를 풀어보세요.
		 * Exam03.java 와 동일한 과정으로 배열을 생성할 때 중복된 값이 없도록 초기화
		 */
	}

}
