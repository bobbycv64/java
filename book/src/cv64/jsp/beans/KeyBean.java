package cv64.jsp.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class KeyBean {

	public KeyBean() {

		setExpirationDate("2003365");
	}

	public void display() {
		System.out.println("Key.toString()");
		System.out.println(expirationDate_);
	}

	public String getExpirationDate() {
		return expirationDate_;
	}

	public boolean isExpired() {

		Calendar calendar = new GregorianCalendar();
		Date trialTime = new Date();
		calendar.setTime(trialTime);

		String calendarDay = Integer.toString(calendar.get(Calendar.DAY_OF_YEAR));

		while (calendarDay.length() < 3)
			calendarDay = "0" + calendarDay;

		String currentDate =
			Integer.toString(calendar.get(Calendar.YEAR)) + calendarDay;

		System.out.println("Current Date:\t" + currentDate);

		if (Integer.parseInt(currentDate) <=
		    Integer.parseInt(expirationDate_)) {

			System.err.println("Software Expires on: " +
			    expirationDate_);

			return false;

		} else {

			System.err.println("Software Expired on: " +
			    expirationDate_);

			return true;
		}
	}

	private void setExpirationDate(String date) {
		expirationDate_ = date;
	}

	private String expirationDate_;
}
