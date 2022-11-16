package kr.co.exam03;

public class Schedule {
	// Git issue 클래스 만들기 연습 (스케쥴)
	private int year;
	private int month;
	private int day;
	private boolean allDay = false;
	private String start = "09:00:00";
	private String finish = "10:00:00";
	
	public Schedule(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void allDayChange() {
		boolean allDay = true;
		start = "00:00:00";
		finish = "23:59:59";
	}
	
	public void dayChange(int year, int month, int day) {
		System.out.println("년, 월, 일 을 입력하세요.");
		this.year = year;
		this.month = month;
		this.day = day;
	}
}
