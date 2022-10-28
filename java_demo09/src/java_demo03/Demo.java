package java_demo03;

public class Demo {

	public static void main(String[] args) throws Exception{
		String sArr[] = {"A", "B", "C", null, "D", "E"};
		
		for(int i = 0; i < sArr.length; i++) {
		//	System.out.println(sArr[i].charAt(0));  //실행하면 이 줄에 NullPointException 발생
			System.out.println(sArr[i]);  // 에러 발생하면 일단 배열이 제대로 생성되었는지 확인해본다
			 //에러 발생 줄 위에서부터 확인해보는게 기본. 보통 닷연산자에서 에러가 많이 발생하니 사용하지 않고 확인해본다.
		}
		
		throw new Exception(); // 강제로 에러 발생시키기
	}

}
