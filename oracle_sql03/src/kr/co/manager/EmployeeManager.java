package kr.co.manager;

import java.util.Scanner;

import kr.co.controller.DeptController;
import kr.co.controller.EmployeeController;
import kr.co.controller.JobController;

public class EmployeeManager {

	private Scanner sc = new Scanner(System.in);
	EmployeeController ec = new EmployeeController();
	DeptController dc = new DeptController();
	JobController jc = new JobController();
	
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			int menuNumber = 0;
			if(sc.hasNextInt()) {
				menuNumber = sc.nextInt(); sc.nextLine();
				this.selectMenu(menuNumber);
			}
		}
		
	}

	// MVC Pattern 으로 코드 짬(Model : DB연결(조회,추가,수정,삭제), View : 출력 전용, Controller : 중간제어)
	// VO 활용하고 패키지 분리해서 함
	// Servlet/JSP, Spring 에서도 사용
	private void selectMenu(int menuNumber) {
		switch(menuNumber) {
		case 1:
			//사원 조회(전체, ID, 이름, 부서명, 직무명)
			this.empSearchMenu();
			break;
		case 2:
			//부서 조회(전체, ID, 이름)
			this.deptSearchMenu();
			break;
		case 3:
			//직무 조회(전체, ID, 이름)
			this.jobSearchMenu();
			break;
		case 4:
			//사원 정보 추가 수정 삭제
			break;
		case 5:
			//부서 정보 추가 수정 삭제
			break;
		case 6:
			//직무 정보 추가 수정 삭제
			break;
		case 7:
			//프로그램 종료
			System.exit(0);
		}
	}

	private void jobSearchMenu() {
		// TODO Auto-generated method stub
		
	}

	private void deptSearchMenu() {
		// TODO Auto-generated method stub
		
	}

	private void empSearchMenu() {
		System.out.println("[1] 전체 조회");
		System.out.println("[2] ID 조회");
		System.out.println("[3] 이름 조회");
		System.out.println("[4] 직무명 조회");
		System.out.println("[5] 부서명 조회");
		
		int menuNumber = 0;
		while(true) {
			System.out.print("번호 입력 : ");
			if(sc.hasNextInt()) {
				menuNumber = sc.nextInt(); sc.nextLine();
				break;
			}
		}
		switch(menuNumber) {
		case 1:
			ec.getAll(); break;
		case 2:
			System.out.print("ID 입력 : ");
			int id = sc.nextInt(); sc.nextLine();
			ec.getId(id); break;
		case 3: //이름 입력 1번 받고 부분일치 가능(like), 대소문자 구분x 인 방법으로 
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			ec.getName(name); break;
		case 4:
			System.out.print("직무명 입력 : ");
			String jobName = sc.nextLine();
			ec.getJobName(jobName); break;
		case 5:
			System.out.print("부서명 입력 : ");
			String deptName = sc.nextLine();
			ec.getDeptName(deptName); break;
		}
	}

	private void printMenu() {
		System.out.println("[1] 사원 조회");
		System.out.println("[2] 부서 조회");
		System.out.println("[3] 직무 조회");
		System.out.println("[4] 사원 정보 추가 수정 삭제");
		System.out.println("[5] 부서 정보 추가 수정 삭제");
		System.out.println("[6] 직무 정보 추가 수정 삭제");
		System.out.println("[7] 프로그램 종료");
	}

}
