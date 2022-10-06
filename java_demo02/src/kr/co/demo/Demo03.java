package kr.co.demo;

public class Demo03 {

	public static void main(String[] args) {
		// 형변환 : 변수에 저장된 특정 자료형의 데이터를 다른 자료형의 변수에 저장하기
		//        위해서 자료형의 종류를 변환시켜주는 작업. =캐스팅(Casting)
		
		// 형변환은 일반적으로 다음의 경우에 필요
		// 정수 -> 정수 / 정수 -> 실수 / 실수 -> 정수 / 실수 -> 실수
		
		// 자료형의 크기가 작은 자료형에서 큰 자료형으로 변환 할 때는 자동 형변환
		// 자료형의 크기가 큰 자료형에서 작은 자료형으로 변환 할 때는 강제 형변환
		
		byte bt1;
		short st1 = 500;
		
		bt1 = (byte)st1;

		//손실,누락을 감당할것인지 하지 않을 것인지는 선택
		double it1 = 10 + 10.5;
		System.out.println(it1);
		int it2 = (int)(10 + 10.5);
		System.out.println(it2);
		
		String str1 = "문자열";
		str1 = str1 + 10;
		System.out.println(str1);  //결합된 문자열
		
	}

}
