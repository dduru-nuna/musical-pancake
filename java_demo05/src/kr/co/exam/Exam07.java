package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 0인 정수 배열을 생성 후 난수(Random)를 사용하여
		 * 0 ~ 100 까지의 임의값을 생성해 배열에 추가한다.
		 * 총 6개의 정수 값을 추가하도록 한다.
		 */
		
		Random rand = new Random();
		
		int arr1[] = new int[0];
		
		for(int i = 0; i < 6; i++) {
			int num = rand.nextInt(101);
			
			arr1 = Arrays.copyOf(arr1, arr1.length+1);
			
			/*
			 int tmp[] = new int[arr1.length + 1];
			 System.arraycopy(arr1, 0, tmp, 0, arr1.length);
			 */
			
			arr1[arr1.length - 1] = num;
			
			//arr1 = tmp; //Arrays.copyOf 에서는 얕은 복사 작업 필요없음
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		/*for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
		*/
		
		
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
			
			int tmp[] = Arrays.copyOf(arr2, arr2.length+1);
			
			/*
			 
			 */
			
			tmp[tmp.length - 1] = num2;
			
			arr2 = tmp;
			i++;
			
		} 
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("%d\t", arr2[i]);
		}
	}

}
