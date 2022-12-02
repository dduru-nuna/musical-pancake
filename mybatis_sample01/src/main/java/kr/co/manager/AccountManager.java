package kr.co.manager;

import java.util.Scanner;

import kr.co.controller.AccountController;

public class AccountManager {
	private Scanner sc = new Scanner(System.in);
	
	public void start() {
		while(true) {
			System.out.println("[1] 회원 가입 요청 목록");
			System.out.println("[9] 프로그램 종료");
			
			int menu = 0;
			while(true) {
				System.out.print("메뉴 번호 : ");
				if(sc.hasNextInt()) {
					menu = sc.nextInt(); sc.nextLine();
					break;
				}
			}
			switch(menu) {
			case 1:
				this.getAccountRequestList();
				break;
			case 9:
				System.exit(0);
			}
		}
	}

	private void getAccountRequestList() {
		AccountController ac = new AccountController();
		ac.getAccountRequestList();
		
	}
}