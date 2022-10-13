package kr.co.exam;

import java.util.Random;
import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성해 배열에 추가한다.
		 * 총 6개의 정수 값을 추가하도록 한다.
		 */
		int arr1[] = new int[0];
		
		Random rand = new Random();
		
		for(int i = 0; i < 6; i++) {
			int num = rand.nextInt(101);
			
			int tmp[] = new int[arr1.length + 1]; 
			
			for(int j = 0; j < arr1.length; j++) {
				tmp[j] = arr1[j];
			}
			
			tmp[tmp.length - 1] = num;
			
			arr1 = tmp;
		}
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		
		System.out.println();
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성해 배열에 추가한다.
		 * 단, 홀수에 해당하는 값만 6개 추가하도록 한다.
		 */
		
		int arr2[] = new int[0];
		
		for(int i = 0; i < 6;) {
			int num2 = rand.nextInt(101);
			
			if(num2 % 2 == 0) {
				continue;       //짝수라서 continue 가 동작하면 반복의 처음으로 돌아감
			}
			
			int tmp[] = new int[arr2.length + 1]; 
			
			for(int j = 0; j < arr2.length; j++) {
				tmp[j] = arr2[j];
			}
			
			tmp[tmp.length - 1] = num2;
			
			arr2 = tmp;
			i++;
			
		} 
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("%d\t", arr2[i]);
		}
		System.out.println();
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
		 * 1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장한다.
		 * 2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 * 3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 한다.
		 * 
		 * 예제
		 *     1 번째 정수값 입력 : 7
		 *     2 번째 정수값 입력 : 12
		 *     3 번째 정수값 입력 : 24
		 *     4 번째 정수값 입력 : -1
		 *     
		 *     총 합 : 43
		 *     평균 : 14.3
		 */
		
		/*Scanner sc= new Scanner(System.in);
		
		System.out.println("입력 횟수 : ");
		int num3 = sc.nextInt();
		
		System.out.println(num3 + "번 만큼 값을 입력하세요.");
		int arr3[] = new int[num3];
		
		for(int i = 0; i < num3; i++) {
			
			int tmp[] = new int[arr3.length]; 
			
			for(int j = 0; j < arr3.length - 1; j++) {
				tmp[j] = arr3[j];
			}
			
			tmp[tmp.length - 1] = num3;
			
			arr3 = tmp;
		}
		for(int i = 0; i < arr3.length; i++) {
			System.out.printf("%d\t", arr3[i]);
		}*/
		
	}

}
