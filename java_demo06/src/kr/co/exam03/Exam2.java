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
	
		
		
		
		System.out.println("메뉴 테스트");
		
		Menu_kh m = new Menu_kh();
		String s = m.getAll();
		System.out.print(s);
		
		System.out.println("\n메뉴 추가 확인");
		m.add("만두", 4000);
		s = m.getAll();
		System.out.print(s);
		
		System.out.println("\n메뉴 수정 확인");
		//s = m.getAll();  //매번 수정을 확인하는것이 번거로워질것. break 대신 return true,false로 boolean데이터 반환이 더 효율적
		boolean res = m.update("김치", 4500);
		System.out.println("수정확인-> " + res);
		
		System.out.println("\n메뉴 삭제 확인");
		m.remove("김밥");
		s = m.getAll();
		System.out.print(s);
		
		System.out.println("\n메뉴 가격 확인");
		int price = m.getPrice("라면");
		System.out.print(price);
	}
}
	
