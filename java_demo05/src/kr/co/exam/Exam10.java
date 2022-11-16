package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam10 {

	public static void main(String[] args) {
		/*
		 * 1. 
		 *   A. 3 ~ 10 사이의 랜덤값을 생성하면 이것을 1차 배열의 크기로 사용한다.
		 *   B. 1차 배열의 크기가 정해지면 다시 5 ~ 10 사이의 랜덤값을 생성하고
		 *      이것을 2차 배열의 크기로 사용한다.
		 *   C. 2차 배열까지의 크기가 정해지면 다시 10 ~ 99 사이의 랜덤값을 생성하고
		 *      이것을 2차 배열에 초기값으로 사용한다.
		 *   D. C에서 만들어진 2차 배열을 전체 탐색을 통해 짝수는 별도의 짝수 배열에
		 *      홀수는 별도의 홀수 배열에 저장한다.
		 *   E. D에서 만든 짝수 배열, 홀수 배열의 동일한 위치에 있는 정수값들의 합을
		 *      구하고 구해진 합들만을 저장할 배열을 만든다.
		 *      (짝수와 홀수의 갯수가 다른 경우 수량이 더 많은 배열을 기준으로
		 *       자기 자신의 합을 구하여 저장하도록 한다.)
		 *      {6,8,4,2}
		 *      {3,7}
		 *    ->{9,15,8,4}
		 */

		Random rand = new Random();
		int rowSize = rand.nextInt(8) + 3;
		
		int colSize = rand.nextInt(6) + 5;
		
		int arr[][] = new int[rowSize][colSize];
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				arr[i][j] = rand.nextInt(90) + 10;
			}
		}
		// 짝수, 홀수 배열 만들어 저장하기
		int even[] = new int[0];
		int odd[] = new int[0];
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				if(arr[i][j] % 2 ==0) {
					//짝수만 짝수 배열에 저장
					even = Arrays.copyOf(even, even.length + 1);
					even[even.length - 1] = arr[i][j];
				} else {
					//홀수만 홀수 배열에 저장
					odd = Arrays.copyOf(odd, odd.length + 1);
					odd[odd.length - 1] = arr[i][j];
				}
			}
		}
		System.out.println(even.length + " | " + Arrays.toString(even));
		System.out.println(odd.length + " | " + Arrays.toString(odd));
		
		/*
		int sum[] = new int[0];
		
		int minSize = odd.length;
		boolean isEvenLong = true;  // 짝수 배열의 크기가 큰가? true -> 네
		
		if(even.length < odd.length) {
			minSize = even.length;
			isEvenLong = false;    // 짝수 배열의 크기가 큰가? false -> 아니요
		}
		
		for(int i = 0; i < minSize; i++) {
			sum = Arrays.copyOf(sum, sum.length + 1);
			sum[i] = even[i] + odd[i];
		}
		
		int overSize = 0;
		if(isEvenLong) {
			// 짝수 배열의 크기가 클 때
			overSize = even.length - odd.length;
			sum = Arrays.copyOf(sum, sum.length + overSize);
			for(int i = odd.length; i < sum.length; i++) {
				sum[i] = even[i] * 2;
			}
		} else {
			// 홀수 배열의 크기가 클 때
			overSize = odd.length - even.length;
			sum = Arrays.copyOf(sum, sum.length + overSize);
			for(int i = even.length; i < sum.length; i++) {
				sum[i] = odd[i] * 2;
			}
		}
		
		System.out.println(Arrays.toString(sum));
		*/
		
		//또다른 풀이. 더 간단 버전
		int sum[]; int tmp[];
		if(even.length > odd.length) {
			sum = Arrays.copyOf(even, even.length);  //배열의 크기가 큰것을 복사
			tmp = Arrays.copyOf(odd, even.length);   //배열 크기가 큰 거 기준으로 길이 늘림
		} else {
			sum = Arrays.copyOf(odd, odd.length);
			tmp = Arrays.copyOf(even, odd.length);
		}	
		
		for(int i = 0; i < sum.length; i++) {
			sum[i] = tmp[i] != 0 ? sum[i] + tmp[i] : sum[i] * 2;
		}   //큰 거 기준으로 길이가 늘어나면 0 값이 들어가 있으니 tmp에 0이 들어가있는 인덱스는 sum값을 두번 더하게 해주는 과정
		System.out.println(sum.length + " | " + Arrays.toString(sum));
	}

}
