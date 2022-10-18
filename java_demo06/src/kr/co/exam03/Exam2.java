package kr.co.exam03;

public class Exam2 {

	public static void main(String[] args) {

		Clock_kh clock = new Clock_kh(11, 59, 59);
		
		clock.nextSecond();
		System.out.println(clock.getAmPm() + " " + clock.getTime());
		
		clock.prevSecond();
		System.out.println(clock.getAmPm() + " " + clock.getTime());
		
		
		
		Schedule_kh schedule = new Schedule_kh(2022, 10, 18);
		System.out.println(schedule.getSchedule());
		
		schedule.changeAllDay();
		System.out.println(schedule.getSchedule());
		
		schedule.changeDate(2022, 10, 19);
		System.out.println(schedule.getSchedule());
		
		//clock클래스를 사용함으로써 재사용 가능
		schedule.changeTime(new Clock_kh(12, 00, 00), new Clock_kh(16, 59, 59));
		System.out.println(schedule.getSchedule());
	
	}
}
	
