package ch11.exam16;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getYear());
		System.out.println(now.getMonth());
		System.out.println(now.getDate());
		System.out.println(now.getDay());
		System.out.println(now.getHours());
		System.out.println(now.getMinutes());
		System.out.println(now.getSeconds());
		
		
		Calendar cal = Calendar.getInstance(); //protected므로 상속을 받아서만 사용할수 있고 new로 객체를 만들수없다.
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(year+"-"+month+"-"+date);
	}

}
//밑줄이 그어진 deprecation 이다. 되도록 쓰지말란것