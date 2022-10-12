package kr.co.exam;

public class Exam06 {

	public static void main(String[] args) {
		/*1.
		 * 1부터 시작하여 31까지 출력하기 위한 출력 구문을 만든다.
		 * 단, 달력처럼 1줄에 7개의 값이 출력 되어야한다.
		 * (반드시 중첩 for을 사용할 필요는 없음)
		 */

		/*2.
		 * 다음과 같은 출력이 나오도록 하시오.(중첩 for을 사용하세요)
		 * 1
		 * 2	3
		 * 4	5	6
		 * 7	8	9	10
		 * 11	12	13	14	15
		 */
		
		//1-1
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%d\t",i);
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		//1-2 일부러 중첩 for 사용해봄 
		for(int i = 1; i <= 5; i++) {
			int day = 0;
			for(int j = 1; j <= 7; j++) {
				day = 7 * (i -1) + j;
				System.out.printf("%d\t", day);
				if(day >= 31) {
					break;
				}
			}
			System.out.println();
			if(day >= 31) {
				break;
			
		}
    }	
		
		//2번
		for(int a = 1 ; a <= 5; a++) {
			for(int j = 1; j <= a; j++) {
				for(int num = 1; num <= 15; num++) {
				   System.out.print(num);
				}
			}
			System.out.println();
		}
		
		/*2-1
		 * int colCount = 1, rowCount = 1;
		 * for(int i =1; i <= 15; i++, colCount++) {
		 * 	  System.out.printf("%d\n", i);
		 * 	  if(colCount == rowCount) {
		 * 		System.out.print("\n");
		 * 		colCount = 0;
		 * 		rowCount++;
		 * 	  }
		 * }
		 * 
		 *2-2 
		 * int n = 0;
		 * for(rowCount = 1; rowCount <= 5; rowCount++) {   //라인(줄)수
		 * 	  for(colCount = 1; colCount <= rowCount; colCount++) {
		 * 		 System.out.printf("%d\t", ++n);
		 *    }
		 *    System.out.print("\n");
		 * } 
		 */
	}

}
