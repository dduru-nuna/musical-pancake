package kr.co.demo05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {

	public static void main(String[] args) throws ParseException {
		/*
		 * 날짜 관련 클래스
		 *     - Date : 시스템으로 부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 *     
		 *     - GregorianCalendar : Calendar 클래스를 상속하여 작성된 하위 클래스로
		 *                          년, 월, 일, 시, 분, 초 를 다룰 수 있게 구성된 클래스
		 *     - SimpleDateFormat : 날짜 및 시간 정보를 정해진 형식에 맞추어 문자열로 만들어주거나
		 *                        문자열로 만들어진 날짜 및 시간 정보를 Date 객체로 만들어주는 클래스                    
		 */
		
		/*
		 * Date 클래스
		 */
		Date date = new Date();
		System.out.println(date);
		
		// 1970년 1월 1일 0시 0분 0초 부터 시작된 현재까지의 밀리초
		long ms = date.getTime();
		System.out.println(ms);
		
		String year = String.format("%tY", date);
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String sDay = String.format("%tA", date);
		System.out.println(year + "년 " + month + "월 " + day + "일 " + sDay);
		
		
		/*
		 * GregorianCalendar 
		 */
		GregorianCalendar gc = new GregorianCalendar();
		gc = new GregorianCalendar(2022,1,1);
		gc = new GregorianCalendar(2022,0,1,12,30,0);  // 월 값은 0 이 1월, 1이 2월 ~
		
		System.out.println(gc.getTime());
		
		int iYear = gc.get(Calendar.YEAR); // 년도 가져오기
		int iMonth = gc.get(Calendar.MONTH) + 1; // 월 가져오기 , 월 정보는 0~11까지 가져오니 +1 해준다
		int iDate = gc.get(Calendar.DATE); // 일 가져오기
		int iDay = gc.get(Calendar.DAY_OF_WEEK);
		// DAY_OF_WEEK 에 해당하는 상수값이 이미 다 있기 때문에 정수값이 얼마인지 따로 구할 필요는 없다
		sDay = "";
		switch(iDay) {
		case Calendar.SUNDAY:
			sDay = "일요일";
			break;
		case Calendar.MONDAY:
			sDay = "월요일";
			break;
		case Calendar.TUESDAY:
			sDay = "화요일";
			break;
		case Calendar.WEDNESDAY:
			sDay = "수요일";
			break;
		case Calendar.THURSDAY:
			sDay = "목요일";
			break;
		case Calendar.FRIDAY:
			sDay = "금요일";
			break;
		case Calendar.SATURDAY:
			sDay = "토요일";
			break;
		}
		System.out.println(iYear);
		System.out.println(iYear + "년 " + iMonth + "월 " + iDate + "일 " + sDay);
		
		// 시,분,초
		gc.get(Calendar.HOUR);
		gc.get(Calendar.MINUTE);
		gc.get(Calendar.SECOND);
		gc.get(Calendar.MILLISECOND);
		
		/*
		 * SimpleDateFormat
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String fDate = df.format(new Date());
		System.out.println(fDate);
		
		String strDate = "2022년 10월 25일 12시 30분 30초"; //미리 지정한 날짜 포멧에 해당하는 문자열 데이터가 있으면 parsing 하여 date타입으로 저장 가능
		date = df.parse(strDate);
		System.out.println(date);
	}

}
