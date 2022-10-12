package kr.co.exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * Exam03.java 파일을 생성 후 다음의 문제를 풀어보세요.
		 * 사용자 입력으로 2 ~ 5 사이의 정수 값을 입력 받아 입력 받은 정수값과
		 * 동일한 크기의 배열을 생성 하고, 배열의 값을 초기화 하기 위해 다시 
		 * 사용자 입력을 사용하여 1 ~ 10 사이의 값만을 입력 받아 초기화 하세요.
		 */

		Scanner sc = new Scanner(System.in);
		int size = 0;
		
		while(!(size >= 2 && size <= 5)) {
			System.out.println("2 ~ 5 사이의 정수 값을 입력하세요");
			size = sc.nextInt();
		}	
		
		int arr1[] = new int[size];
		
		for(int i = 0; i < size;) {
			System.out.print("1 ~ 10 사이의 정수 입력 : ");
			int num = sc.nextInt();
			
			if(num >= 1 && num <= 10) {
				arr1[i] = num;
				System.out.printf("%d 위치에 %d 값으로 초기화 하였습니다.\n",i,num);
				i++;
			} else {
				System.out.println("값을 다시 확인해서 입력하세요.");
			}
		}
		
		for(int i = 0; i < size; i++) {
			System.out.printf("%d\t", arr1[i]);
		}
	}

}
