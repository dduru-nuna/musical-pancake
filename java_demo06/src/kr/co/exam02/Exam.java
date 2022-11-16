package kr.co.exam02;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 과목(Subject) 클래스를 만들어 본다.
		 * 과목 클래스는 다음의 속성 및 기능을 가진다.
		 *    속성 : 과목명, 점수, 등급
		 *    기능 : 점수등록, 과목확인, 점수확인, 등급확인
		 *    
		 * 과목명은 한 번 정해지면 변경할 수 없어야 한다.
		 * 점수는 언제든 변경할 수 있으나 0 ~ 100 사이의 값만 저장해야 한다.
		 * 등급은 점수에 의해 결정되며, A ~ F 등급까지 부여한다.(등급을 별도로 설정하는 것은 금지)
		 * 과목 객체의 속성값을 확인하는 것은 허용한다.
		 * 
		 */

		Subject s1 = new Subject("국어");
		s1.setScore(85.5);
		
		System.out.println("과목명 : " + s1.getName());
		System.out.println("점수 : " + s1.getScore());
		System.out.println("등급 : " + s1.getGrade());
		
		/*
		 * 로또(Lotto) 클래스를 만들어 본다.
		 * 로또 클래스는 다음의 속성 및 기능을 가진다.
		 * 		속성 : 회차, 로또번호(배열), 보너스
		 * 		기능 : 번호생성, 번호확인
		 * 
		 * - 회차는 한 번 정해지면 변경 할 수 없어야 한다.
		 * - 로또 번호는 1 ~ 46 사이의 번호 6개 + 보너스 번호가 생성되어야 한다.
		 * - 로또 번호는 "번호생성" 기능을 통해서만 생성되어야 한다.
		 * - 모든 번호는 중복이 있어선 안된다.
		 * - "번호확인" 기능을 통해 확인할 수 있는 번호는 보너스 까지이며, 문자열로 반환해야 한다.
		 */
		
		Lotto lotto = new Lotto(976);
		lotto.generate();
		System.out.println(lotto.getLotto());
	}

}
