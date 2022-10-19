package kr.co.exam03;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	// Git issue 클래스 만들기 연습 (메뉴판)
	private String name[] = {"김치찌개", "된장찌개", "순두부찌개"};
	private int price[] = {8000, 7500, 9000};
	
	Menu menu = new Menu(); 
	Scanner sc = new Scanner(System.in);
	
	public void add(String name[], int price[]) {
		this.name = Arrays.copyOf(this.name, this.name.length);
		this.price = Arrays.copyOf(this.price, this.price.length);
	}
	
	public void delete(String name[], int price[]) {
		this.name = Arrays.copyOf(this.name, this.name.length-1);
		this.price = Arrays.copyOf(this.price, this.price.length-1);
	}
	
}
