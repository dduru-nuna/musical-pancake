package kr.co.demo;

public class Demo05 {

	public static void main(String[] args) {
		/*
		 * while 반복문
		 * 
		 * while(조건식) {
		 * 		실행코드;
		 * }
		 * 
		 * 조건식의 결과 값이 참일 때 반복을 수행하며, 거짓이 되면 반복을 중단.
		 * 
		 * break, continue 를 사용하여 반복문을 제어할 수 있다.
		 */

		int i = 0;
		while(i < 5) {
			System.out.println(i);
			i++;                     //앞서 if문 예제들을 while로 바꿔보는 연습 주말에 해보기
		}
		
		// 무한 반복
		while(true) {
			System.out.println("무한 반복");
			break;
		}
		
		//Exam05 문제들 while 로 변경해서 풀어보기
		int x = 1;
		while(x <= 10) {
			System.out.println(x);
			x++;
		}
		
		int y = 1;
		while(y <= 15) {
			System.out.println(y*3);
			y++;
		}
		
		int count = 0, z = 7;
		while(z < 150) {
			count+=1;
			System.out.printf("%d번째 반복 -> %d\n", count, z);
			z+=7; 
		}
		System.out.printf("총 %d 번 반복함\n", count);
		
		
		/*
		 * do while 반복문
		 * 		일단 1회 반복을 수행 후 조건식의 결과에 따라 참이면 반복을 계속 진행
		 * 		거짓이면 반복을 중단
		 * 
		 * do {
		 *     실행 코드
		 * } while(조건식);
		 */
		
		do {
			System.out.println("조건식의 결과가 거짓이여도 일단 1회 실행됨");
		} while(false);
	}

}
