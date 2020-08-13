package org.iit.mmp.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
public class AppLibrary {
	public static String getDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		System.out.println(date);
		return date.toString();
	}
	public static String getRandomChars(int count) {
		Random rnd = new Random();
		String s = "";
		for (int i = 0; i < count; i++) {
			s = s + (char) ('a' + rnd.nextInt(26));
		}
		return s;
	}
	public static String getRandomDigits(int count) {
		int j = 1;
		for (int i = 0; i < count; i++) {
			j = j * 10;
		}
		String randomNumber = Long.toString(Calendar.getInstance().getTimeInMillis() % j);
		return randomNumber;
	}
	public static String getAlphaNumericString(int length) {
		String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(SOURCE.charAt(r.nextInt(SOURCE.length())));
		return sb.toString();
	}
	public static int getRandomIndexInRange(int max, int min) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}