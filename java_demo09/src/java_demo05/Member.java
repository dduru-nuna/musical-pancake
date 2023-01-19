package java_demo05;

public class Member {

	private String name;
	private String password;
	
	public void setName(String name) throws UserException {
		if(name.contains("*")) {
			throw new UserException("사용자 이름에는 * 이 들어가면 안됩니다.");
		}
		this.name = name;
	}
	
	public void setPassword(String password) throws PasswordException {
	// 내가 푼거
    //	if(!(password.contains("?")||password.contains("!")||password.contains("*")||password.contains("@"))) {
	//		throw new PasswordException("비밀번호에는 특수문자 ?, !, *, @ 가 포함되어야 합니다.");
	//	}
		if(validLowerCase(password)&&validNumber(password)&&validSpecialChar(password)&&validUpperCase(password)) {
			this.password = password;
		} else {
			throw new PasswordException("패스워드에는 대문자/소문자/숫자/특수문자(!@#$%^&*) 가 포함되야함");
			
	    }
	}	
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	private boolean validUpperCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				return true;
			}
		}
		return false;
	}
	
	private boolean validLowerCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				return true;
			}
		}
		return false;
	}	
	
	private boolean validNumber(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				return true;
			}
		}
		return false;
	}
	
	private boolean validSpecialChar(String password) {
		String specialChar = "!@#$%^&*";
		for(int i = 0; i < password.length(); i++) {
			if(password.contains("" + specialChar.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
