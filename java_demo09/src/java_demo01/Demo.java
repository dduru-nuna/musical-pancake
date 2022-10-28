package java_demo01;

public class Demo {

	public static void main(String[] args) {
		// 설명 카톡캡쳐확인
		
		/*
		int arr[] = new int[0];
		
		arr[0] = 10;
		arr[1] = 20;
		
		컴파일 체크 안하지만 (try/catch 강제 안함 - 언체크드익셉션) 실행하면 exception 발생하게 만드는 런타임오류 
		*/
		
		int arr[] = new int[0];
		
		try {
			arr[0] = 10;
			arr[1] = 20;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 벗어 났습니다.");
		}
		
		System.out.println("정상 종료!");
	}

}
