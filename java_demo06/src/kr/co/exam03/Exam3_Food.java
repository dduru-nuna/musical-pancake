package kr.co.exam03;

import java.util.Scanner;

public class Exam3_Food {

	public static void main(String[] args) {
		
		Menu_kh2 menu = new Menu_kh2();
		
		//메서드 오버로딩 (overloading)
		//  동일한 이름의 메서드를 여러개 작성하는 것 -> 여기 예제에선 일단 적용안시키고 다음에..
		
		menu.add("라면", 3500);
		menu.add("치즈라면", 4000);
		menu.add("김밥", 3000);
		menu.add("치즈김밥", 3500);
		menu.add("돈까스", 4000);
		menu.add("치즈돈까스", 4500);
		
		// 가변길이 매개변수 사용법. 가변길이 매개변수는 하나만 존재할 수 있다
		menu.add("잔치국수","비빔국수");
		menu.add("잔치국수","비빔국수","냉모밀");
		
		Scanner sc = new Scanner(System.in);
		String name = "";
		int total = 0;
		while(true) {
			System.out.print("메뉴 선택 : ");
			name = sc.nextLine();
			
			if(name.equals("exit")) {
				break;
			}
			
			int price = menu.getPrice(name);
			if(price != -1) {
				System.out.printf("%s 메뉴를 선택했습니다. 가격은 %,d 입니다.\n", name, price);
				total += price;
			} else {
				System.out.printf("%s 에 해당하는 메뉴는 없습니다.\n", name);
			}
		}
		System.out.printf("지금까지 선택한 메뉴의 총 가격은 %,d 입니다.\n", total);
	}

}
