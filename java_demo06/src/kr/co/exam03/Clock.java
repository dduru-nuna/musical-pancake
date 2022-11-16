package kr.co.exam03;

public class Clock {

	// Git issue 에 업로드 된 클래스 만들기 연습 (시계)
	private int hour;
	private int minute;
	private int second;
	private boolean am;
	
	public Clock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void dayNight() {
		boolean am = true;
		if(hour >= 12) {
			am = false;
			System.out.println("오후");
		} else {
			System.out.println("오전");
		}
	}
	
	public void beforeTime() {
		int i = 0;
		this.minute = minute - i;
	}
	
	public void afterTime() {
		
	}
	
	public String getTime() {
		String str = "";
		str += hour + ":" + minute + ":" + second;
		return str;
	}
	
	
	
	
}
