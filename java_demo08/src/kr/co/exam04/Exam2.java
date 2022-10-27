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
		int lastDate = gc.getMaximum(Calendar.DAY_OF_MONTH); //getMaximum 메서드로 그 달(DAY_OF_MONTH)의 마지막일을 알 수 있다
		
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
	}

}
