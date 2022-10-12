package kr.co.exam;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		/*
		 * 1부터 시작하여 10까지 총 10번 반복하는 반복문을 작성하시오.
		 * 출력 메시지는 다음의 형식으로 합니다.
		 * 출력 형식
		 *    총 10 번 반복중 n 번 반복
		 * (n 이 1 ~ 10 까지 1 씩 증가 되어서 출력되어야함)
		 */
		
		/*
		 * 총 15번 반복하는 반복문을 사용하고 3부터 시작하여 45까지 3의 배수 값만
		 * 출력하는 코드를 작성하시오.
		 */
		
		/*
		 * 7부터 시작하여 7의 배수에 해당하는 값을 출력할 때 150 이전에 출력되는
		 * 7의 배수 값과 총 반복 횟수를 출력하시오.
		 */
		
		/*
		 * 사용자 입력을 활용하여 사용자가 입력한 정수값만큼 반복을 수행하는 반복문을
		 * 작성하시오.
		 * (사용자 입력값이 0 이하인 경우 "1 이상의 값을 입력하세요" 라는 메시지를
		 * 출력하고 종료한다. 1부터 시작)
		 */
		
		/*
		 * 사용자 입력을 활용하여 사용자가 입력한 2개의 정수값 n,m 을 n ~ m 까지의
		 * 반복 또는 m ~ n 까지의 반복을 수행하는 코드를 작성하시오.
		 */
		
		/*
		 * 사용자 입력과 if, for 을 활용하여 사용자로부터 정수값을 입력 받았을 때
		 * 1 ~ 45 사이의 값이 저장 될 수 있게 한다.
		 * (단, 3번의 입력 기회만 부여하고 3번의 기회를 넘기면 0값이 저장)
		 */
		
		//1번
		for(int i = 1; i <= 10 ; i++) {
			System.out.printf("총 10번 반복 중 %d번 반복\n", i);
		}
		
		//2번
		for(int i = 1; i <= 15 ; i++) {
		    System.out.println(i*3);
		}
		/* for(int i =1, x =3; i<=15; i++, x+=3) {
		 *    System.out.printf("%d번째 반복 -> %d\n", i, x);
		 * 이런식으로도 쓸 수 있음
		 */
		
		
		//3번
		int z;
		for(z =1; 7*z < 150; z++) {
			System.out.println(7*z);
		}
		System.out.println("총 반복 횟수 : " + z);
		/* int cnt = 0;
		 * for(int i =7; i <150 ; i+=7) {
		 *    cnt += 1;
		 *    System.out.printf("%d번째 반복 -> %d\n", cnt, i)
		 * }
		 * System.out.println("총 %d번 반복함\n", cnt);   
		 */
		
		
		//4번
		System.out.println("정수값을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int i;
		int a = sc.nextInt();
		for(i = 1 ; i <= a; i++) {
			if(a < 0) {
				System.out.println("1 이상의 값을 입력하세요");
			}
			System.out.println(i);
		}
		/* Scanner sc = new Scanner(System.in);
		 * System.out.print("1 이상의 정수값 입력 : ");
		 * cnt = sc.nextInt();
		 * 
		 * if(cnt >= 1) {
		 *     for(int i = 1; i <= cnt; i++) {
		 *         System.out.printf("총 %d 반복 중 %d 번째 반복입니다.\n",cnt,i);
		 * } else {
		 *     System.out.println("1 이상의 값을 입력하세요.");
		 */
		
		
		//5번
		int n, m, q, p;
		n = sc.nextInt();
		m = sc.nextInt();
		q = (n >= m) ? n-m : m-n;
		for(p = 1 ; p <= q; p++) {
			System.out.println(p);
		}
		/* Scanner sc = new Scanner(System.in);
		 * int n,m;
		 * System.out.print("첫번째 정수값 입력 : ");
		 * n = sc.nextInt();
		 * System.out.print("두번째 정수값 입력 : ");
		 * m = sc.nextInt();
		 * 
		 * if(n < m) {
		 *    for(; n <= m ; n++) {
		 *       System.out.printf("%d\n", n);
		 *    }
		 * } else {
		 *    for(; m <= n ; m++) {
		 *       System.out.printf("%d\n", m);      
		 *    }
		 * }
		 * 
		 * =======다른 방법========
		 * int n,m,min,max;
		 * System.out.print("첫번째 정수값 입력 : ");
		 * n = sc.nextInt();
		 * System.out.print("두번째 정수값 입력 : ");
		 * m = sc.nextInt();
		 * 
		 * if(n < m) {
		 *   min = n ; max = m;
		 * } else {
		 *   min = m ; max = n;
		 * }
		 * for(; min <= max; min++) {
		 *    System.out.printf("%d\n", min);
		 * }   
		 * 
		 * 
		 * min = n < m ? n : m;
		 * max = n < m ? m : n;  으로 쓸 수 도 있음
		 */
		
		
		//6번
		System.out.println("정수값을 입력하세요");
		int b = sc.nextInt();
		int num;
		for(num = 1; num <= 3; num++) {
			if(b >= 1 && b <= 45) {
				System.out.println(b);
			} else {
				System.out.println("1 ~ 45 사이의 값을 입력하세요");
			}
		}
		/* int number = 0;
		 * for(int i = 1; i <= 3; i++) { 
		 *     System.out.print("1 ~ 45 사이의 정수값 입력 : ");
		 *     int inputNumber = sc.nextInt();
		 *     if(inputNumber >= 1 && inputNumber <= 45) {
		 *        number = inputNumber;
		 *        break;
		 *     } else {
		 *        System.out.printf("입력 기회가 %d 번 남았습니다.", 3-i);
		 *     }
		 * }
		 * System.out.printf("%d 값이 저장되었습니다.", number);       
		 */
	
   }

}
