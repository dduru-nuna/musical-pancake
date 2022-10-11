package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		// 연산자
		
		// 비트 연산
		// 10 -> 1010
		//  6 -> 0110
		// &에 대한 결과 -> 0010
		// |에 대한 결과 -> 1110
		// ^에 대한 결과 -> 1100  (^:xor -> 서로 다르면 1)

		int x = 10;
		// x += 1; ->x =  x + 1;
		// x -= 1; -> x = x - 1;
		// x *= 2; -> x = x * 2;
		// x /= 2; -> x = x / 2;
		x /= 2;
		System.out.println(x);
		
		// 나열 연산
		for(int y = 0, z = 2; y < 5; y++, z += 2) {
			System.out.println(y + "/" + z);
		}
		
		// 삼항 연산
		// x > 3 참이면 변수 x에 10을 저장하고 거짓이면 0을 저장
		x = x > 3 ? 10 : 0;
		System.out.println(x);
		
		
		// 산술연산
		int x1 = 3;
		int y1 = 2;
		
		System.out.println("더하기(+) 연산 결과 -> " + (x1 + y1));
		System.out.println("빼기(-) 연산 결과 -> " + (x1 - y1));
		System.out.println("곱하기(*) 연산 결과 -> " + (x1 * y1));
		System.out.println("나누기(/) 연산 결과 -> " + (x1 / y1));
		System.out.println("나머지(%) 연산 결과 -> " + (x1 % y1));
		
		double x2 = 3.0;
		System.out.println("더하기(+) 연산 결과 -> " + (x2 + y1));
		System.out.println("빼기(-) 연산 결과 -> " + (x2 - y1));
		System.out.println("곱하기(*) 연산 결과 -> " + (x2 * y1));
		System.out.println("나누기(/) 연산 결과 -> " + (x2 / y1));
		System.out.println("나머지(%) 연산 결과 -> " + (x2 % y1));
		
		// 비교연산
		System.out.println("> 연산 결과 -> " + (x1 > y1));
		System.out.println("< 연산 결과 -> " + (x1 < y1));
		System.out.println(">= 연산 결과 -> " + (x1 >= y1));
		System.out.println("<= 연산 결과 -> " + (x1 <= y1));
		System.out.println("== 연산 결과 -> " + (x1 == y1));
		System.out.println("!= 연산 결과 -> " + (x1 != y1));
		
		// 논리연산
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println("논리 연산 true && true 결과 -> " + (b1 && b1));
		System.out.println("논리 연산 true && false 결과 -> " + (b1 && b2));
		System.out.println("논리 연산 false && true 결과 -> " + (b2 && b1));
		System.out.println("논리 연산 false && false 결과 -> " + (b2 && b2));
		
		System.out.println("논리 연산 true || true 결과 -> " + (b1 || b1));
		System.out.println("논리 연산 true || false 결과 -> " + (b1 || b2));
		System.out.println("논리 연산 false || true 결과 -> " + (b2 || b1));
		System.out.println("논리 연산 false || false 결과 -> " + (b2 || b2));
		
		// 증감연산
		int z1 = 10;
		int z2 = 10;
		
		System.out.println("전위 증감 연산 ++z1 결과 -> " + (++z1));
		System.out.println("후위 증감 연산 z2++ 결과 -> " + (z2++));
		
		System.out.println("전위/후위 최종 결과 -> " + z1 + "/" + z2);

		// 삼항연산
		int a = 1;
		int b = 0;
		b = a > 3 ? 5 : 10;
		System.out.println(b);
	}

}
