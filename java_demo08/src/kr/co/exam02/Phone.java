package kr.co.exam02;

public class Phone {

	private String number;
	private boolean invalid = true;
	
	public Phone(String phone) {
		this.valid(phone);
	}
	
	/**
	 * 생성된 객체에 저장된 전화번호 형식이 유효하지 않은지 확인하기 위한 메서드
	 *   true : 유효하지 않은 전화번호
	 *   false : 유효한 전화번호
	 * @return
	 * boolean
	 */
	public boolean isInvalid() {
		return this.invalid;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getNumber(boolean hidden) {
		if(!this.invalid) {
			return this.number.substring(0, 9) + "****";
		}
		return null;
	}
	
	private void valid(String phone) {
		if(!phone.startsWith("010")) {
			System.out.println("010으로 시작하는 번호를 입력하세요.");
			return;
		}
		
		if(phone.length() != 13) {
			System.out.println("하이픈(-)을 포함한 13자리 번호를 입력하세요");
			return;
		}
		if(phone.split("-").length != 3) {
			System.out.println("올바른 전화번호 형식이 아닙니다.");
			return;
		}
		
		String phoneArr[] = phone.split("-");
		
		for(int i = 1; i < phoneArr.length; i++) { // 010은 이미 체크했으니 인덱스 1부터 확인
			for(int j = 0; j < phoneArr[i].length(); j++) {
				if(!(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9')) {
					System.out.println("0 ~ 9에 해당하는 숫자가 아닙니다.");
					return; 
				}
			}
		}
		
		for(int i = 1; i < phoneArr.length; i++) {
			if(phoneArr[i].length() != 4) {
				System.out.println("전화번호는 2번째 3번째 숫자가 4자리여야 합니다.");
				return;
			}
		}
		this.number = phone;
		this.invalid = false;
	}
	
	public static Phone valuOf(String phone) {
		return new Phone(phone);
	}
}
