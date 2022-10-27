package kr.co.demo03;

import java.util.StringTokenizer;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringTokenizer
		 *     문자열을 특정 구분 문자를 기준으로 분리하는 클래스
		 *     
		 *     string의 split 쓰는게 더 효율적
		 *     
		 *     참고용으로 소개
		 */
		String str = "A,B,C,D,E";
		
		StringTokenizer sToken = new StringTokenizer(str, ",");
		
		while(sToken.hasMoreElements()) {
			System.out.println(sToken.nextToken());
		}

	}

}
