package kr.co.demo;

import java.util.Random;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * Random 클래스
		 */
		Random rand = new Random();

		int num = rand.nextInt(5);  // 지정한 범위의 난수 생성 (0 ~ 4)
		
		System.out.println(num);
	}

}
