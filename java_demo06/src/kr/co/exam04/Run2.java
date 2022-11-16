package kr.co.exam04;
import java.util.Scanner;

public class Run2 {

	private Scanner sc = new Scanner(System.in);
	private Student2 student = new Student2("홍길동");
		
	public Run2() {
		this.student.addSubject("국어", 78.8);
		this.student.addSubject("영어", 88.8);
		this.student.addSubject("수학", 83.4);
		this.student.addSubject("과학", 68.3);
	}
	
	private void printMenu() {
		System.out.println("1. 성적표 출력");
		System.out.println("2. 과목 성적 출력");
		System.out.println("3. 과목 성적 추가");
		System.out.println("4. 과목 성적 수정");
		System.out.println("5. 과목 성적 삭제");
		System.out.println("6. 프로그램 종료");
	}
		
	private void select(int number) {
		switch(number) {
			case 1:
				// 성적표 출력기능 수행하는 메서드 호출
				this.printAll();
				break;
			case 2:
				// 과목 성적 출력을 수행하는 메서드 호출
				this.printSubject();
				break;
			case 3:
				// 과목 성적 추가 기능을 수행하는 메서드 호출
				this.add();
				break;
			case 4:
				// 과목 성적 수정 기능을 수행하는 메서드 호출
				this.update();
				break;
			case 5:
				// 과목 성적 삭제 기능을 수행하는 메서드 호출
				this.remove();
				break;
			case 6:	
				System.out.println("프로그램이 종료 됩니다.");
				System.exit(0);  // 프로그램 종료
			default:
				// 메뉴 번호를 잘못 입력했을 경우
				System.out.println("메뉴 번호를 잘못 입력하였습니다.");
			}
	}
	
	private void printAll() {
		String result = this.student.getGradeTable();
		System.out.println(result);
	}
	
	public void printSubject() {
		while(true) {
			System.out.print("출력할 과목명 : ");
			String name = sc.nextLine();
			
			if(name.equals("exit")) {
				break;
			}
			
			Subject subject = student.getSubject(name);
			if(subject != null) {
				System.out.printf("\t%s\n", subject.getName());
				System.out.printf("점수\t%s\n", subject.getScore());
				System.out.printf("등급\t%c\n\n", subject.getGrade());
			} else {
				System.out.println("출력 할 과목 정보가 없습니다.\n");
			}
		}
	}
	
	private void add() {
		while(true) {
			System.out.print("추가 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();

			if(name.equals("exit")) {
				break;
			}

			double score = -1;
			while(!(score >= 0 && score <= 100)) {
				System.out.print("성적 입력(0 ~ 100) : ");
				if(sc.hasNextDouble()) {
					score = sc.nextDouble();
				}
				sc.nextLine();
				System.out.println();
			}

			boolean result = this.student.addSubject(name, score);
			if(result) {
				System.out.println("과목 추가 완료되었습니다.");
			} else {
				System.out.println("이미 존재하는 과목 정보 입니다.");
			}
			System.out.println();
		}
	}
	
	private void update() {
		while(true) {
			System.out.print("수정 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();

			if(name.equals("exit")) {
				break;
			}

			double score = -1;
			while(!(score >= 0 && score <= 100)) {
				System.out.print("성적 입력(0 ~ 100) : ");
				if(sc.hasNextDouble()) {    //실수 맞는지 확인하고 맞으면 값 저장 (실수 외의 값이 입력되면 에러가 뜨는게 아니라 저장되지 않고 넘어감)
					score = sc.nextDouble();
				}
				sc.nextLine();
				System.out.println();
			}

			boolean result = this.student.updateSubject(name, score);
			if(result) {
				System.out.println("과목 수정 완료되었습니다.");
			} else {
				System.out.println("수정 할 과목이 존재하지 않습니다.");
			}
			System.out.println();
		}
	}
	
	private void remove() {
		while(true) {
			System.out.print("삭제 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();

			if(name.equals("exit")) {
				break;
			}

			boolean result = this.student.removeSubject(name);
			if(result) {
				System.out.println("과목 삭제 완료되었습니다.");
			} else {
				System.out.println("삭제 할 과목이 존재하지 않습니다.");
			}
			System.out.println();
		}
	}
	
	private void clear() {
		String cls = "";
		for(int i = 0; i < 25; i++) {
			cls += "\n";
		}
		System.out.println(cls);
	}
	
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			
			int number = -1;
			if(sc.hasNextInt()) {
				number = sc.nextInt(); sc.nextLine();
				this.select(number);
			} else {
				sc.nextLine();
				continue;
			}
				
			System.out.println("초기 메뉴로 돌아가려면 Enter 입력");
			sc.nextLine();
			this.clear();
		}
	}
}

