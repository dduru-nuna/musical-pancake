package kr.co.exam04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 현재 날짜를 구하고 다음 형식에 맞추어 출력하세요.
		 *    1. 2022/01/01
		 *    2. 2022년 01월 01일
		 *    3. 12시 30분 30초
		 *    4. 12:30:30
		 *    
		 * 2022년 10월 중 주말에 해당하는 날짜만 문자열 배열에 담아 출력하세요.
		 * 
		 * 자신의 생년월일을 입력하면 현재로 부터 며칠 남아있는지 알려주는 D-DAY 정보를 출력하세요.
		 */
		
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		int iyear = gc.get(Calendar.YEAR);
		int imonth = gc.get(Calendar.MONTH)+1;
		int idate = gc.get(Calendar.DATE);
		int ihour = gc.get(Calendar.HOUR_OF_DAY);
		int iminute = gc.get(Calendar.MINUTE);
		int isecond = gc.get(Calendar.SECOND);
		
		System.out.println(gc.getTime());
		System.out.println("1. " +  iyear + "/" + imonth + "/" + idate);
		System.out.println("2. " +  iyear + "년 " + imonth + "월 " + idate + "일");
		System.out.println("3. " +  ihour + "시 " + iminute + "분 " + isecond + "초");
		System.out.println("4. " +  ihour + ":" + iminute + ":" + isecond);
		
		
		
		String str[] = new String[0];
		int iArr[] = new int[0];
		int count = 0;
		for(int i = 1; i <= 31; i++) {
			GregorianCalendar gc1 = new GregorianCalendar(2022, 9, i);
			int iday = gc1.get(Calendar.DAY_OF_WEEK);
			if(iday == Calendar.SATURDAY || iday == Calendar.SUNDAY) {
				iArr[count] = i; count++;
				System.out.println(iArr[count]);
			}
		}
		
		
	}

}
