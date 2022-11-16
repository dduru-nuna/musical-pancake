package kr.co.exam03;

public class Schedule_kh {

	private int year;
	private int month;
	private int day;
	private boolean allDay;
	private Clock_kh startTime;   //앞서 만든 clock_kh클래스 이용 
	private Clock_kh endTime;
	private boolean leaf;  //윤년설정
	private int lastDayForMonth[] = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	
	public Schedule_kh(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		this.startTime = new Clock_kh(9,0,0);
		this.endTime = new Clock_kh(10,0,0);
	}
	
	private void setYear(int year) {
		this.year = year;
		this.leaf = false;
		if(this.year % 4 == 0) {
			if(this.year % 100 == 0) {
				if(this.year % 400 == 0) {
					this.leaf = true;
				}
			} else {
				this.leaf = true;
			}
		}
	}
	
	private void setMonth(int month) {
		this.month = 1;  // 1 ~ 12 이외의 값은 1로 하기위해 설정
		if(month >= 1 && month <= 12) {
			this.month = month;
		}
	}
	
	private void setDay(int day) {
		this.day = 1;  // 1 ~ lastday 이외의 값은 1로 하기위해 설정
		int lastDay = this.lastDayForMonth[this.month - 1];
		
		if(this.month == 2 && this.leaf) {  //윤년인 경우
			lastDay += 1;
		}
		
		if(day >= 1) {
			if(day <= lastDay) {
				this.day = day;
			} else {
				this.day = lastDay;   //윤년이나 잘못입력한 경우가 여기에 해당
			}
		}
	}
	
	public void changeAllDay() {
		this.allDay = true;
		this.startTime = new Clock_kh(0,0,0);
		this.endTime = new Clock_kh(23,59,59);
	}
	
	public void changeTime(Clock_kh startTime, Clock_kh endTime) {
		this.allDay = false;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void changeDate(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	public String getSchedule() {
		String str = "";
		str += this.year + "년 " + this.month + "월 " + this.day + "일 ";
		str += this.startTime.getTime() + "부터 " + this.endTime.getTime() + " 까지 ";
		str += this.allDay ? "하루종일 " : "";
		str += "스케줄이 잡혀 있습니다.";
		return str;    // 메서드 안의 지역변수를 소멸시키지 않고 다른곳에서 불러쓰기 위해선 return이 필요
	}
}
