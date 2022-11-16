package kr.co.exam01;

import kr.co.exam01.school.Subject;

public class Exam {

	public static void main(String[] args) throws NumberRangeOverException, NegativaNumberException {
		/*
		 * 과목에 대한 점수 및 등급을 계산하고 사용할 수 있도록 도와주는 클래스를 만든다.
		 *   - 점수는 0 ~ 100 사이의 정수 및 실수만 입력할 수 있다.
		 *     해당 범위를 벗어나는 경우 NumberRangeOverException 이 발생할 수 
		 *     있도록 사용자 정의 예외를 만드세요.
		 *     
		 *   - 점수에 음수 값을 입력하는 경우 NegativeNumberException 이 발생할
		 *     수 있도록 사용자 정의 예외를 만드세요.
		 *     
		 *   - 과목 클래스는 kr.co.exam01.school 패키지 안에 Subject 로 만드세요.
		 *   
		 *   - 새로 추가하는 사용자 정의 예외는 kr.co.exam01.school.exception
		 *     패키지 안에 추가하세요.
		 *     
		 *   - 생성한 과목 인스턴스를 System.out.println() 으로 출력에 사용할 때
		 *     "과목명(점수 : 등급)" 형식으로 출력될 수 있게 toString() 을 오버라이드 하세요.
		 *     
		 *   - 두 개의 과목 객체가 제공될 때 점수가 가장 높은 과목 객체를 반환하는 메서드인
		 *     greatTime() 메서드를 추가하세요.
		 */

		Subject s1 = new Subject();
		s1.setScore(54);
		
		Subject s2 = new Subject();
		s2.setScore(70);
		
		Subject grate = s1.grateThen(s2);
		System.out.println(grate);
	}

}
