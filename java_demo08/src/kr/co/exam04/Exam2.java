package kr.co.exam04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam2 {

	public static void main(String[] args) {

		GregorianCalendar gc = new GregorianCalendar(2022,9,1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E");
	//	GregorianCalendar gc2 = new GregorianCalendar(2022,10,0); // 10월의 마지막날
	//	int lastDate = gc2.get(Calendar.DATE);
		int lastDate = gc.getActualMaximum(Calendar.DAY_OF_MONTH); //getActualMaximum 메서드로 그 달(DAY_OF_MONTH)의 마지막일을 알 수 있다
		
		Date[] dateArr = new Date[0]; //문자열 배열 말고 Date 배열에 저장하기
		
		for(int i = 1 ; i <= lastDate; i++) {
			int day = gc.get(Calendar.DAY_OF_WEEK);
	
			switch(day) {
			case Calendar.SUNDAY:
				System.out.println(df.format(gc.getTime()));
				break;
			case Calendar.SATURDAY:
				System.out.println(df.format(gc.getTime()));
			}
			gc.add(Calendar.DATE, 1);
		}
		
		
		// 생일 D-DAY 풀이
		String birthDay = "19971028";
		
		GregorianCalendar now = new GregorianCalendar();
		int nowYear = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH) + 1;
		int nowDate = now.get(Calendar.DATE);
		
		int year = Integer.parseInt(birthDay.substring(0, 4));
		int month = Integer.parseInt(birthDay.substring(4, 6));
		int date = Integer.parseInt(birthDay.substring(6));
		
		int birthMonthDate = month * 100 + date; // 생일값은 101~1231 까지이니 월*100 을 해준다
		int nowMonthDate = nowMonth * 100 + nowDate;
		
		GregorianCalendar nextBirthDay = new GregorianCalendar(nowYear, month-1, date);
		if(nowMonthDate >= birthMonthDate) {
			if(nowMonthDate == birthMonthDate) {
				System.out.println("D-DAY 입니다. 생일 축하합니다!");
			} else {
				System.out.println("생일이 지났습니다.");
			}	
			nextBirthDay.add(Calendar.YEAR, 1);
		} else {
			System.out.println("생일이 아직 지나지 않았습니다.");
		}
		
		System.out.printf("다음 생일은 -> %1$tY년 %1$tm월 %1$td일 입니다.\n", nextBirthDay.getTime());
		// 서식이 3개라 3개가 필요하지만 1$ 쓰면 똑같은 서식을 사용할 수 있다. 2$면 두번째 서식을 남은 값에 적용 하는 방식
		
		int dDay = 0;
		while(true) {
			now.add(Calendar.DATE, 1); //D-DAY 는 오늘 날짜 이후부터 남은 일자를 계산하는 것이니 다음날로 정해준다.
			dDay += 1;
			if(now.get(Calendar.YEAR) == nextBirthDay.get(Calendar.YEAR)
					&& now.get(Calendar.MONTH) == nextBirthDay.get(Calendar.MONTH)
					&& now.get(Calendar.DATE) == nextBirthDay.get(Calendar.DATE)) {
				break;
			}
		}
		System.out.println("D-DAY : " + dDay + "일 남았습니다.");
		
		/*
		 * 1. 현재 달의 남은 일수를 구한다. 
		 * 2. 다음 달부터 생일 전달 까지 모든 월의 일수를 누적하여 구한다.
		 * 3. 생일 달의 일자를 구한다.
		 * 
		 * 이런 방식은 2번째꺼만 반목하면 된다.(최대 10번 -> 1번이랑 3번 달의 경우가 빠짐)
		 * 위에 짠 로직은 같은 날이 나올때까지 365~366(윤년인경우) 번 반복해야해서 반복 횟수가 많다.
		 * 
		 * 힌트 : 1. gc.getActualMaximum(Calendar.DATE_OF_MONTH) - 현재일자 : 달의 남은 일수
		 *       2. gc.getActualMaximum(Calendar.DATE_OF_MONTH)
		 *       3. birthDate
		 */
	}

}
