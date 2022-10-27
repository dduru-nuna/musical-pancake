package kr.co.demo04;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 *     - 문자열을 기본 자료형으로 변환해주는 클래스
		 *     - 기본 자료형을 클래스로 만들어서 클래스처럼 다루어서 사용할 수 있게 도와주는 클래스
		 *     
		 * Wrapper 종류
		 *     Boolean, Byte, Character, Short, Integer, Long, Float, Double
		 */
		
		// 형식 자체가 각 기본자료형에 맞는 형식이어야 변환 가능
		boolean bool1 = Boolean.parseBoolean("true"); // "t" 이런식이면 변환 불가
		byte bt1 = Byte.parseByte("100");
		char ch1 = "가".charAt(0); // char 만 charAt() 메서드 사용
		short sh1 = Short.parseShort("100");
		int it1 = Integer.parseInt("100");
		long lg1 = Long.parseLong("100");
		float ft1 = Float.parseFloat("100");
		double db1 = Double.parseDouble("100");
		
		// 기본 자료형을 Wrapper 객체로 변환
		Boolean bool2 = Boolean.valueOf(bool1);
		Byte bt2 = Byte.valueOf(bt1);
		Character ch2 = Character.valueOf(ch1);
		Short sh2 = Short.valueOf(sh1);
		Integer it2 = Integer.valueOf(it1);
		Long lg2 = Long.valueOf(lg1);
		Float ft2 = Float.valueOf(ft1);
		Double db2 = Double.valueOf(db1);

	}

}
