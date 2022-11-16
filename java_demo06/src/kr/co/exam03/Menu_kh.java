package kr.co.exam03;

import java.util.Arrays;

public class Menu_kh {
	
	//길이가 0인 배열으로라도 초기화 하지않으면 nullException 오류가 뜨기 때문에 해준다.
	private String name[] = new String[0];
	private int price[] = new int[0];
	
	/*이렇게 초기화 해줘도 됨
	 * public Menu() {
	 * 		this.name = new name[0];
	 * 		this.price = new price[0];
	 */
	
	/**
	 * 메뉴 객체에 저장된 데이터를 문자열로 만들어 반환하는 메서드
	 * @return
	 *  모든 메뉴 정보가 있는 문자열을 반환
	 */
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.name.length; i++) {
			str += String.format("%s\t%,d\n", this.name[i], this.price[i]);
		}
		//System.out.printf 와 같지만 이건 출력이고 String.format은 반환시킨다
		return str;
	}

	/**
	 * 메뉴 배열에 새로운 메뉴를 추가하기 위한 기능의 메서드
	 * @param menuName : 음식 메뉴에 추가할 메뉴명
	 * @param price : 음식 메뉴에 추가할 메뉴 가격
	 */
	                       //매개변수
	public void add(String menuName, int price) {
		boolean isExists = this.findIndex(menuName) != -1 ? true : false;
		
		if(!isExists) {
			this.name = Arrays.copyOf(this.name, this.name.length + 1);
			this.name[this.name.length - 1] = menuName;
			
			this.price = Arrays.copyOf(this.price, this.price.length + 1);
			this.price[this.price.length - 1] = price;
		}	
	}
	
	public boolean update(String menuName, int price) {
		//int idx = this.findIndex(menuName);
		//if(idx != -1) {
		//    this.price[idx] = price;
		//    return true;
		//}
		//return false;
		//이렇게 findIndex 활용해서 반복문 없앨 수 있음
		for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {  //문자열 비교는 equals
				this.price[i] = price;
				return true;
			}
		}
		return false;
	}
	
	public void remove(String menuName) {
		//메뉴판에 삭제할 동일데이터가 있는지 확인
		boolean isExists = false;
		//boolean isExists = this.findIndex(menuName) != -1 ? true : false; 
		//이렇게 findIndex 활용하여 반복문 없이 할 수 있음 (바로 if(isExists) 구문으로 넘어가면됨)
		for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {
				isExists = true;
				break;
			}
		}	
		
		if(isExists) {
			String tmpName[] = new String[this.name.length - 1];
			int tmpPrice[] = new int[this.name.length - 1];
		
			for(int i = 0, j = 0; i < this.name.length; i++) {
				if(!this.name[i].equals(menuName)) {  //삭제할 데이터가 아니면 배열에 저장
					tmpName[j] = this.name[i];
					tmpPrice[j] = this.price[i];
					j++;  //삭제 데이터를 만나면 인덱스 위치가 증가하지 말아야하기 때문에 여기서 별로도 증가
				}
			}
			this.name = tmpName;
			this.price = tmpPrice;
		}	
	}
	
	/**
	 * 메뉴를 찾아서 해당하는 메뉴의 가격을 반환하는 메서드
	 * @return
	 *  -1 이 반환되면 해당 메뉴는 없는 메뉴입니다.
	 */
	public int getPrice(String menuName) {
		int idx = this.findIndex(menuName);
		return idx != -1 ? this.price[idx] : idx;
	}
	
	
	//반복되는 반복문은 따로 빼서 재활용하기 위해 findIndex 라는 메서드 생성
	private int findIndex(String menuName) {
		for(int i = 0; i < this.name.length; i++) {
			if(this.name[i].equals(menuName)) {
				return i;
			}
		}
		return -1; //0으로 쓰면 메뉴가격을 0으로 착각할 수도 있으니 -1로 작성
	}
}
