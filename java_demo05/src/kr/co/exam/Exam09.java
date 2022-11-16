package kr.co.exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exam09 {

	public static void main(String[] args) {
		/*
		 * 3행, n열에 해당하는 2차 배열을 만들어보세요.
		 *    1. n은 사용자 입력을 통해 3 ~ 9 사이의 정수를 받아 사용
		 *    2. 배열에 초기화 하는 데이터는 랜덤을 사용하여 1 ~ 99 사이의 값을 저장
		 */

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		/*
		System.out.println("3 ~ 9 사이의 정수를 입력하세요.");
		int num = sc.nextInt();
		
		int arr1[][] = new int[3][num];
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < num; j++) {
				int data = rand.nextInt(100);
				arr1[i][j] = data;
			}
		}
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < num; j++) {
				System.out.printf("arr1[%d][%d] -> %d\n", i, j, arr1[i][j]);
			}
		}*/
		
		//강사님 풀이
		/*
		int size;
		
		while(true) {
			System.out.print("3 ~ 9 사이의 정수 입력 : ");
			size = sc.nextInt();
		    if(size >= 3 && size <= 9) {
		    	break;
		    }
		}	
	
		int arr[][] = new int[3][size];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < size; j++) {
				int num = rand.nextInt(100);
				arr[i][j] = num;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {     //2차 배열이기 때문에 반복문 써줘야 arrays.toString 썼을때 값이 보인다
		System.out.println(Arrays.toString(arr[i]));
		}*/
		
		int size;
		
		while(true) {
			System.out.print("3 ~ 9 사이의 정수 입력 : ");
			size = sc.nextInt();
		    if(size >= 3 && size <= 9) {
		    	break;
		    }
		}	
	
		int arr[][] = new int[3][];
		
		//1. 일반적인 1차배열 생성
		//2. 1차배열을 동적배열로 활용하여 랜덤값 추가
		//3. 1차배열의 참조주소를 2차배열의 행에 등록 -> arr[0] = 참조주소;
		
		for(int i = 0; i < arr.length; i++) {
			int tmp[] = new int[0];
			for(int j = 0; j < size; j++) {
				//동적 배열 적용하여 2차 배열에 값 저장
				int num = rand.nextInt(100);
				tmp = Arrays.copyOf(tmp, tmp.length + 1);
				tmp[tmp.length - 1] = num;
			}
			arr[i] = tmp;
		}
		
		for(int i = 0; i < arr.length; i++) {     
			System.out.println(arr[i].length);
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
