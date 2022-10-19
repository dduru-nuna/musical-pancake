package kr.co.exam03;

import java.util.Arrays;

public class Menu_kh2 {
	// 객체 배열
	private Food food[] ;
	
	public Menu_kh2() {
		this.food = new Food[0];
	}
	
	
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.food.length; i++) {
			Food f = this.food[i];
			str += String.format("%s\t%,d\n", f.name, f.price);
		}                               //인스턴스 객체안에 있는 name과 price
		return str;
	}
	
	public void add(String menuName, int price) {
		boolean isExists = this.findIndex(menuName) != -1 ? true : false;
		
		if(!isExists) {
			this.food = Arrays.copyOf(this.food, this.food.length + 1);
			this.food[this.food.length - 1] = new Food(menuName, price);
		}	
	}
	
	// 동일한 이름의 메서드 (기존에 만든 메서드의 매개변수와 타입이 달라야한다)
	// ex.println을 보면 char타입,int타입 등등 여러개의 메서드가 오버로딩 되어있다.
	/*
	  public void add(Food food) {
	 
		boolean isExists = this.findIndex(food.name) != -1 ? true : false;
		
		if(!isExists) {
			this.food = Arrays.copyOf(this.food, this.food.length + 1);
			this.food[this.food.length - 1] = food;
		}	
	}*/
	
	
	
	public boolean update(String menuName, int price) {
		int idx = this.findIndex(menuName);
		if(idx != -1) {
		    this.food[idx].price = price;
		    return true;
		}
		return false;
	}
	
	public void remove(String menuName) {
		int idx = this.findIndex(menuName);
		if(idx != -1) {
			for(int i = idx; i < this.food.length - 1; i++) {
				this.food[i] = this.food[i + 1];
			}
			this.food = Arrays.copyOf(this.food, this.food.length - 1);
		}
	}	
		
	
	public int getPrice(String menuName) {
		int idx = this.findIndex(menuName);
		return idx != -1 ? this.food[idx].price : idx;
	}
	
	
	
	private int findIndex(String menuName) {
		for(int i = 0; i < this.food.length; i++) {
			if(this.food[i].name.equals(menuName)) {
				return i;
			}
		}
		return -1; 
	}
}
