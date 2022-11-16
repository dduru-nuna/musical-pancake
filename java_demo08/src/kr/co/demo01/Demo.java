package kr.co.demo01;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		/*
		 * String 관련 클래스
		 *     - String : 문자열 클래스로 문자열 데이터를 다루기 위해 사용한다.
		 *            수정 불가능(불변타입) 으로 데이터 수정 시 원본 데이터를 복사하여
		 *            새로운 문자열 데이터로 만드는 형식으로 사용
		 *     - StringBuilder : 문자열 클래스로 String 의 불변타입을 변경가능으로
		 *            사용할 수 있게 만들어진 클래스이다.
		 *            Thread Safe 기능을 제공하지 않음
		 *     - StringBuffer : StringBuilder 클래스와 동일한 기능을 제공
		 *            Thread Safe 기능을 제공함.
		 *            Thread Safe 기능은 멀티쓰레드 작업에 활용할 때 공유 자원에
		 *            대한 안정성을 높여 주기 위해 사용하는 기능. 대신 성능은 좀 떨어질 수 있음
		 */
		
		// 문자열 생성 방법
		String str1 = "문자열";
		String str2 = new String("문자열");
		String str3 = new String(new char[] {'문','자','열'});
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		// charAt() : 문자열에서 매개변수로 전달한 정수값의 위치에 해당하는 문자를 반환하는 메서드
		for(int i=0 ; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			System.out.println(ch);
		}
		
		// codePointAt() : 문자열에서 매개변수로 전달한 정수값의 위치에 해당하는 문자의 문자코드를 반환하는 메서드
		for(int i = 0; i < str1.length(); i++) {
			int code = str1.codePointAt(i);
			System.out.println(code + "|" + (char)code);
		}
		
		// compareTo()
		str1 = new String("A");
		str2 = new String("B");
		int compare = str1.compareTo(str2);  
		System.out.println(compare);  // str1 기준으로 str2 보다 사전상 순서가 앞에 있으니 - 나옴
		compare = str2.compareTo(str1);
		System.out.println(compare);  // str2 기준으로 str1 보다 사전상 순서가 뒤에 있으니 + 나옴
		
		System.out.println(str1.codePointAt(0));
		System.out.println(str2.codePointAt(0));  //compareTo 는 코드값 서로 뺀거 A:65, B:66
		
		// compareToIgnoreCase() : 대소문자 무시하고 비교
		
		// concat() : 문자열 결합
		str1 = new String("대한");
		str2 = new String("민국");
		str3 = str1.concat(str2); // str1을 str2랑 결합
		System.out.println(str3);
		
		// contains() : 문자열 안에 포함된 내용이 있는지 확인
		str1 = new String("이 메서드는 contains 메서드 예제 입니다.");
		boolean isContains = str1.contains("contains");
		System.out.println(isContains);
		isContains = str1.contains("컨테인");
		System.out.println(isContains);
		
		// contentEquals() : contains()와 다르게 내용이 완전 동일 해야 한다
		str1 = new String("동일한 내용이 있는지 검사하는 메서드");
		boolean isEquals = str1.contentEquals("동일한 내용이 있는지 검사하는 메서드");
		System.out.println(isEquals);  // equals()랑 다른점은 StringBuffer 기능 사용(Thread Safe)
		isEquals = str1.contentEquals("동일한");
		System.out.println(isEquals);
		
		// endsWith() , startsWith() : 문자열 시작과 끝 확인
		str1 = new String(" startsWith(), endsWith() 메서드 예제");
		boolean isEnds = str1.endsWith("end");
		boolean isStarts = str1.startsWith("start");
		System.out.println(isEnds + "|" + isStarts);
		
		// toUpperCase(), toLowerCase() : 전부 소문자 / 대문자로 변환
		str1 = str1.toLowerCase();
		System.out.println(str1);
		str1 = str1.toUpperCase();
		System.out.println(str1);
		
		// indexOf() : 특정 문자열 위치 인덱스 반환
		str1 = new String("indexOf() 메서드 사용 예제로 이 메서드는 특정 문자열의 위치를 알려주는 메서드.");
		int index = str1.indexOf("메서드");
		System.out.println(index);
		index = str1.indexOf("메서드", 11); //10번 찾았으니 그 다음 위치(11)에서부터 "메서드" 찾아라
		System.out.println(index);
		index = str1.indexOf("메서드", 24);
		System.out.println(index);
		
		// 문자열에서 사용자가 지정한 문자열이 몇개 있는지 출력하시오.
		int count = 0;
		index = 0;
		while(true) {
			str1.indexOf("메서드", index);
			if(index != -1) {
				index++; count++;
			} else {
				break;
			}
		}
		System.out.println("str1 문자열에서 \"메서드\" 단어는 " + count + " 개 있습니다.");
		
		System.out.println(str1.indexOf((int)'문')); // 문자코드 알아내서 그 문자코드가 있는 인덱스 위치 알려줌
		
		// isBlank(), isEmpty() : Blank 는 공백,개행 모두 비어있다고 여김. Empty는 공백,개행을 비어있지 않다 여김
		str1 = new String("");
		boolean isBlank = str1.isBlank();
		boolean isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		str1 = new String(" ");
		isBlank = str1.isBlank();
		isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		str1 = new String("\n");
		isBlank = str1.isBlank();
		isEmpty = str1.isEmpty();
		System.out.println(isBlank + "|" + isEmpty);
		
		// lines(), split() : 개행 기준으로 분리
		str1 = new String("문자열에\n개행이 있으면\n개행을 기준으로\n분리하는 메서드");
		Stream<String> stream = str1.lines(); //시스템(윈도우,리눅스 등) 상관없이 개행 동일 (시스템마다 개행표현방식이 다름)
		Object objArr[] = stream.toArray();
		for(int i = 0; i < objArr.length; i++) {
			String s = (String)objArr[i];
			System.out.println(s);
		}
		
		String strArr[] = str1.split("\\n"); // 정규표현식에 대한 \n으로 보게 하기 위해 \\n 으로 작성 (\n escape)
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		str1 = new String("split 메서드는 매개변수로 전달하는 구분 문자열을 기준으로 문자열을 분리하는 메서드");
		strArr = str1.split(" "); // 사용자 입력을 한번에 받아서 처리하게 하는데 활용 가능 ex.스캐너 이용시 nextLine() 10 20 30 한번에 입려해서 배열에 저장
		System.out.println(Arrays.toString(strArr));
		
		strArr = str1.split(" ", 3); 
		System.out.println(Arrays.toString(strArr));
		
		// repeat() : 문자열 반복
		str1 = new String("Hell!");
		str1 = str1.repeat(5);
		System.out.println(str1);
		
		// replace()
		str1 = new String("문자열의 일부를 변경하기 위한 문자열 메서드 입니다.");
		str2 = str1.replace("문자열", "String");
		System.out.println(str2);
		
		// strip(), stripLeading(), stripTrailing(), trim()
		str1 = new String("    문자열의 앞 뒤로 존재하는 공백을 제거     ");
		str2 = str1.strip();
		System.out.println("|" + str2 + "|");
		
		str2 = str1.stripLeading();  // 공백 앞쪽이 Leading 뒷쪽이 Trailing
		System.out.println("|" + str2 + "|");
		
		str2 = str1.stripTrailing();
		System.out.println("|" + str2 + "|");
		
		str2 = str1.trim(); // 11버전 이전은 모두 trim()
		System.out.println("|" + str2 + "|");
		
		// substring()
		str1 = new String("문자열 자르기 위한 메서드");
		str2 = str1.substring(4); //"자르기 위한 메서드"
		System.out.println(str2);
		
		str2 = str1.substring(8, 10); //"위한"
		System.out.println(str2);
		
		
		// 위에는 모두 인스턴스 메서드. 여기부턴 클래스(정적) 메서드 public static ~ : 인스턴스 생성 없이 그냥 String.method() 로 사용
		// String.format() : 문자열 형식 정하기
		str1 = String.format("%s %d %f", "문자열포멧", 1234, 12.34);
		System.out.println(str1);
		
		// String.join() : 구분문자 입력하기
		str1 = String.join(", ", "가", "나", "다");
		System.out.println(str1);
		
		// String.valueOf() : 타입을 문자열로 변환
		str1 = String.valueOf(true);
		System.out.println(str1);
		str1 = String.valueOf(10);
		System.out.println(str1);
		str1 = String.valueOf(12.34);
		System.out.println(str1);
	}

}
