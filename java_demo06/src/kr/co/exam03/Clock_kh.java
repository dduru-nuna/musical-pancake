package kr.co.exam03;

public class Clock_kh {
	private int hour;
	private int minute;
	private int second;
	private boolean am;
	private boolean pm;
	
	//생성자
	public Clock_kh(int hour, int minute, int second) {
		this.hour = hour % 24;
		this.minute = minute % 60;
		this.second = second % 60;
		setAmPm();
	}
	
	private void setAmPm() {
		if(this.hour >= 12) {
			this.am = false;
			this.pm = true;
		} else {
			this.am = true;
			this.pm = false;
		}
	}
	
	public String getAmPm() {
		return this.am ? "오전" : "오후";
	}
	
	public String getTime() {
		String str = "";
		// 00:00:00 형식으로 출력하기 위해
		str += this.hour <= 9 ? "0" + this.hour : this.hour;
		str += ":";
		
		str += this.minute <= 9 ? "0" + this.minute : this.minute;
		str += ":";
		
		str += this.second <= 9 ? "0" + this.second : this.second;
		
		return str;
	}
	
	//60초 이상이면 분으로 넘어가기
	public void nextSecond() {
		this.second++;
		if(this.second >= 60) {
			this.nextMinute();
			this.second = 0;
		}	
	}
	//60분 이상이면 시로 넘어가기
	public void nextMinute() {
		this.minute++;
		if(this.minute >= 60) {
			this.nextHour();
			this.minute = 0;
		}
	}
	//시간이 늘어나서 오전오후가 바뀌면
	public void nextHour() {
		this.hour++;
		this.hour %= 24;
		this.setAmPm();
	}
	//00초에서 줄어들면 분으로 넘어가기
	public void prevSecond() {
		this.second--;
		if(this.second <= -1) {
			this.prevMinute();
			this.second = 59;
		}
	}
	//00분에서 줄어들면 시로 넘어가기
	public void prevMinute() {
		this.minute--;
		if(this.minute <= -1) {
			this.prevHour();
			this.minute = 59;
		}
	}
	//시간이 줄어들어 오전오후 바뀌면
	public void prevHour() {
		this.hour--;
		this.hour %= 24;
		this.setAmPm();
	}
}
