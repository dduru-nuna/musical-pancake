package kr.co.exam04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exam2 {

	public static void main(String[] args) {

		GregorianCalendar gc = new GregorianCalendar(2022,9,1);
		GregorianCalendar gc2 = new GregorianCalendar(2022,10,0); // 10월의 마지막날
		int lastDate = gc2.get(Calendar.DATE);
		
		for(int i = 1 ; i <= lastDate; i++) {
			int year = gc.get(Calendar.YEAR);
			int month = gc.get(Calendar.MONTH) + 1;
			int date = gc.get(Calendar.DATE);
			int day = gc.get(Calendar.DAY_OF_WEEK);
			String sDay = "";
			if(month == 11) {
				break;
			}
			switch(day) {
			case Calendar.SUNDAY:
				sDay = "일요일";
				System.out.println(year + "-" + month + "-" + date + " " + sDay);
				break;
			case Calendar.SATURDAY:
				sDay = "토요일";
				System.out.println(year + "-" + month + "-" + date + " " + sDay);
			}
			gc = new GregorianCalendar(2022, 9, i+1);
		}
	}

}
