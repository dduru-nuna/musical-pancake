package kr.co.exam02;

public class Phone {

	/**
	 * 전화번호에 사용하는 접두사가 "010" 이 아니면 사용하는 에러코드
	 */
	public final static int PREFIX_ERROR = 1;
	/**
	 * 전화번호에 사용하는 구분문자가 "-" 이 아니면 사용하는 에러코드
	 */
	public final static int DELIMITER_ERROR = 2;
	/**
	 * 전화번호 형식이 잘못 되었을 때 사용하는 에러코드
	 */
	public final static int FORMATTING_ERROR = 3;
	/**
	 * 전화번호에 숫자가 아닌 문자가 포함된 경우 사용하는 에러코드
	 */
	public final static int NUMBER_ERROR = 4;
	/**
	 * 전화번호의 길이가 잘못 되었을 때 사용하는 에러코드
	 * 전화번호는 구분문자 포함 총 13자리이며, 2번째 3번째 숫자는 4자리
	 */
	public final static int LENGTH_ERROR = 5;
	
	private final String PREFIX_NUMBER = "010";
	private final String DELIMITER = "-";
	private final String HIDDEN_CHAR = "****";
	
	private String number;
	private String[] phoneNumber;
	private boolean invalid = true;
	private int errorCode;
	
	private Phone(String phone) {
		this.errorCode = this.valid(phone);
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
	
	public int reason() {
		return this.errorCode;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getNumber(boolean hidden) {
		if(hidden) {
			if(!this.invalid) {
				return String.join(DELIMITER, phoneNumber[0], phoneNumber[1], HIDDEN_CHAR);
			}
		}
		return this.getNumber();
	}
	
	private int valid(String phone) {
		if(!phone.startsWith(PREFIX_NUMBER)) {
			return Phone.PREFIX_ERROR;
		}
		
		if(phone.length() != 13) {
			System.out.println("하이픈(-)을 포함한 13자리 번호를 입력하세요");
			return Phone.LENGTH_ERROR;
		}
		if(phone.split(DELIMITER).length != 3) {
			return Phone.FORMATTING_ERROR;
		}
		
		String phoneArr[] = phone.split(DELIMITER);
		
		for(int i = 1; i < phoneArr.length; i++) { // 010은 이미 체크했으니 인덱스 1부터 확인
			for(int j = 0; j < phoneArr[i].length(); j++) {
				if(!(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9')) {
					return Phone.NUMBER_ERROR; 
				}
			}
		}
		
		for(int i = 1; i < phoneArr.length; i++) {
			if(phoneArr[i].length() != 4) {
				return Phone.LENGTH_ERROR;
			}
		}
		this.number = phone;
		this.phoneNumber = phoneArr;
		this.invalid = false;
		
		return 0;
	}
	
	public static Phone valuOf(String phone) {
		return new Phone(phone);
	}
}
