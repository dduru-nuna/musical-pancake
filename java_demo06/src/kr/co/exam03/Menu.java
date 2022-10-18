package kr.co.exam03;

import java.util.Arrays;

public class Menu {
	// Git issue 클래스 만들기 연습 (메뉴판)
	private String name[];
	private int price[];
	
	Menu menuList = new Menu(); 
	
	public void add(String name[], int price[]) {
		System.out.print("메뉴와 가격을 입력하세요 : ");
		this.name = Arrays.copyOf(this.name, this.name.length);
		this.price = Arrays.copyOf(this.price, this.price.length);
	}
	
	public void delete(String name[], int price[]) {
		this.name = Arrays.copyOf(this.name, this.name.length-1);
		this.price = Arrays.copyOf(this.price, this.price.length-1);
	}
	
}
