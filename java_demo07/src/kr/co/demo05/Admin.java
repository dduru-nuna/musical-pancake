package kr.co.demo05;

public interface Admin extends Staff {

	String ROLE = "Admin";
	
	void removeRole();
	
	void addRole();
}
