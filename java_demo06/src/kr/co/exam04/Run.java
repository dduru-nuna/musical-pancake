package kr.co.exam04;

import java.util.Scanner;

public class Run {
	
	private Scanner sc = new Scanner(System.in);
	private Student student = new Student("홍길동");
	
	private void printMenu() {
		System.out.println("1. 성적표 출력");
		System.out.println("2. 과목 성적 출력");
		System.out.println("3. 과목 성적 추가");
		System.out.println("4. 과목 성적 수정");
		System.out.println("5. 과목 성적 삭제");
		System.out.println("6. 프로그램 종료");
	}
	
	private void select(int number) {
		Student stu = new Student();
		
		switch(number) {
		case 1:
			// 성적표 출력기능 수행하는 메서드 호출
			String s = student.getAll();
			System.out.print(s);
			break;
		case 2:
			// 과목 성적 출력을 수행하는 메서드 호출
			// sub = sub.getName("수학");
			break;
		case 3:
			// 과목 성적 추가 기능을 수행하는 메서드 호출
			stu.add("사회", 85);
			s = stu.getAll();
			System.out.print(s);
			break;
		case 4:
			// 과목 성적 수정 기능을 수행하는 메서드 호출
			stu.update("국어", 76);
			s = stu.getAll();
			System.out.print(s);
			break;
		case 5:
			// 과목 성적 삭제 기능을 수행하는 메서드 호출
			stu.remove("사회");
			s = stu.getAll();
			System.out.print(s);
			break;
		case 6:	
			System.out.println("프로그램이 종료 됩니다.");
			System.exit(0);  // 프로그램 종료
		default:
			// 메뉴 번호를 잘못 입력했을 경우
		}
	}
	
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			int number = sc.nextInt(); sc.nextLine();
			this.select(number);
			
			System.out.println("초기 메뉴로 돌아가려면 Enter 입력");
			sc.nextLine();
		}
	}
}
