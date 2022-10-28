package java_demo02;

public class Demo {

	public static void methodA() {
		methodB(); // B에서 처리 안하면 여기로 넘어옴. 여기서도 에러 넘겨버리면 main 으로 넘어감
	}
	
	public static void methodB() {
		try{
			methodC();  // 호출한 위치에서 throws 넘어옴. 여기서 try/catch로 처리
		} catch(NegativeArraySizeException e) {
			System.out.println("methodB 에서 에러 처리함");
		}
	}

	public static void methodC() throws NegativeArraySizeException {
		int arr[] = new int[-1];
	}
	
	public static void main(String[] args) {
		methodA();   // 마지막인 main에서도 에러처리 안하면 실행했을때 오류뜸
		             // 메서드 실행스택 : main -> A -> B -> C
	}
}
