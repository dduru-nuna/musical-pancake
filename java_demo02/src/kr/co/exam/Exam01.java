package kr.co.exam;

public class Exam01 {

	public static void main(String[] args) {
		// 1. 문자열 변수 name 에 자신의 이름을 저장
		
		// 2. 정수 변수 age 에 자신의 나이를 저장
		
		// 3. 실수 변수 tall 에 자신의 키를 저장
		
		// 4. 변수에 저장된 모든 값을 .println() 메서드를 사용하여 출력
		
		// 5. 변수에 저장된 값을 활용하여 다음 형식에 맞추어 출력
		//    형식에 맞추어 출력할 때 .print() / .printf() / .println() 중
		//    자신이 사용하기 편한 메서드 선택하여 출력
		//    
		//	  형식 : 저의 이름은 홍길동 입니다. 올해 30 세이며, 내년에는 31 세가 됩니다.
		
		// 6. 문자열 상수 MALE 과 FEMALE 을 생성하고 각각 "남성", "여성" 으로 초기화 하세요
		
		// 7. 변수와 상수에 저장된 값을 활용하여 다음 형식에 맞추어 출력하세요.
		
		//    형식 : 저의 키는 175.5 로 대한민국 남성 표준 키보다 조금 큽니다.
				
		String name = "서윤지";
		int age = 26;
		double tall = 164;
		System.out.println(name);
		System.out.println(age);
		System.out.println(tall);
		// println 안쓰고 print 나 printf 를 사용하여 개행이 필요할땐 문장 끝에 \n 을 쓰면 된다
		System.out.println("저의 이름은 " + name + " 입니다. 올해 " + age + " 세이며, 내년에는 "
				+ (age+1) + " 세가 됩니다.");
		
		final String MALE = "남성";
		final String FEMALE = "여성";
		
		System.out.println("저의 키는 " + tall + " 로 대한민국 " + FEMALE + " 표준 키보다 조금 큽니다." );
		
		
	}

}
