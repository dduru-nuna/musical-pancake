package kr.co.demo;

import java.util.Scanner;

public class Demo03 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 */
		Scanner sc = new Scanner(System.in);
		
		int arr1[] = new int[3];
		arr1[0] = 1; arr1[1] = 2; arr1[2] = 3;
		
		System.out.println("기본 배열의 참조 주소 -> " + arr1);
		
		for(int i = 0; i < 3; i++) {
			System.out.print("정수값 입력 : ");
			int num = sc.nextInt();
			
			int tmp[] = new int[arr1.length + 1];
			
			for(int j = 0; j < arr1.length; j++) {  // 깊은 복사
				tmp[j] = arr1[j];
			}
			
			tmp[tmp.length - 1] = num;
			
			arr1 = tmp;  // 얕은 복사로 주소 옮기기
		
			System.out.printf("%d 값을 배열 arr1 에 추가하였습니다.",num);
		}
		
		System.out.println("기본 배열의 참조 주소 -> " + arr1); //주소가 바뀐걸 볼 수 있다
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
				
	}

}
