package kr.co.demo02;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringBuilder / StringBuffer
		 */
		StringBuilder sb= new StringBuilder(); //기본 크기가 16이지만 128 이렇게 크게 설정해놓으면 늘릴수 있는 문자열이 많아진다.
		
		// append() 는 미리 준비된 공간에 계속 문자열이 추가되는것이다. 다른 공간에 저장된 문자열을 합치는것이 아님.
		sb.append("문자열");
		System.out.println(sb.toString());
		
		sb.append(" append 로 문자열 추가");
		System.out.println(sb.toString());
		
		int capacity = sb.capacity();
		System.out.println(capacity);

		int length = sb.length();  
		System.out.println(length);
		
		// delete()
		sb.delete(0, 4);
		System.out.println(sb.toString());
		
		// insert() : 원하는 위치에 문자열 추가
		sb.insert(15,"완료");
		System.out.println(sb.toString());
		
		// reverse() : 역순
		sb.reverse();
		System.out.println(sb.toString());
		
		// setLength() : 문자열 길게 늘려주기
		sb.setLength(30);
		System.out.println(sb.toString()); 
		
		// trimToSize() : 빈공간 없애기
		sb.trimToSize();
		capacity = sb.capacity();
		System.out.println(capacity);
		
		// indexOf(), replace(), charAt(), compareTo(), substring() 의 기능도 존재
	}

}
