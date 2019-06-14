package timeDateCalendar;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.threeten.bp.format.DateTimeFormatter;

public class TimeDateCalendarTest {

	private static final String FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static TimeDateCalendar timeDateCalendar = new TimeDateCalendar();
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER);
	private static Calendar calendar = new GregorianCalendar(2019, 0, 1, 12, 34, 56);

	private Date fromDate = calendar.getTime();
	private String fromTimeZone = "America/Chicago";
	private String toTimeZone = "Pacific/Auckland";

	@Test
	public void convertTimeZone() {
	}

	@Test
	public void convertTimeZone1() {
	}

	@Test
	public void convertandFormatTimeZone() {
	}

	@Test
	public void convertTimeZoneToAnother() {
	}

	@Test
	public void convert_CST_To_GMT() {
	}

	@Test
	public void ConvertTimeZone2AnotherTimeZone() {
		Date date = timeDateCalendar.ConvertTimeZone2AnotherTimeZone(fromTimeZone, toTimeZone, fromDate,
				dateTimeFormatter);

		String dateString = date.toLocaleString();

		System.out.println("ConvertTimeZone2AnotherTimeZone\t: " + dateString);
	}
}
