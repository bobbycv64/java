package timeDateCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.zone.ZoneRulesException;

public class TimeDateCalendar {

    public static final String CST_310 = "America/Chicago";

    public TimeDateCalendar() {

    }

    public Date ConvertTimeZone2AnotherTimeZone(String fromTimeZone, String toTimeZone,
                                    Date fromDate, DateTimeFormatter dateTimeFormatter) {

        Clock clock = provideClock(fromDate, fromTimeZone);
        LocalDateTime localDateTime = LocalDateTime.now(clock);

        System.out.println("localTime\t\t\t: " + dateTimeFormatter.format(localDateTime));

        // set From Time
        ZonedDateTime fromTime = localDateTime.atZone(ZoneId.of(fromTimeZone));

        // compute To Time
        ZonedDateTime toTime = fromTime.withZoneSameInstant(ZoneId.of(toTimeZone));

        System.out.println("fromTime\t\t\t: " + fromTime);
        System.out.println("toTime\t\t\t\t: " + toTime);

        // return the toDate
        // return toJavaUtilDateFromString(toTime.toString());
        return toJavaUtilDateFromZonedDateTime(toTime);
    }

    public Clock provideClock(Date date, String timeZone) {
        Instant instant = null;
        ZoneId zoneId = null;
        try {
            instant = Instant.ofEpochMilli(date.getTime());
            zoneId = ZoneId.of(timeZone);
        } catch (ZoneRulesException e) {
            zoneId = ZoneId.of(CST_310);
        } finally {
            return Clock.fixed(instant, zoneId);
        }
    }

    private Date toJavaUtilDateFromString(String dateString) {

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("toJavaUtilDateFromString\t: " + date);
        return date;
    }
    
    /**
     * @param zonedDateTime
     * @return
     */
    private Date toJavaUtilDateFromZonedDateTime(ZonedDateTime zonedDateTime) {

        Date date = new Date();

        // compute To Time
        ZonedDateTime toTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Chicago"));
        
        Instant instant = zonedDateTime.toInstant();

        Instant instantTruncatedToMilliseconds = Instant.ofEpochMilli(instant.toEpochMilli());
        String millisecondsString = instantTruncatedToMilliseconds.toString(); // Example:
                                                                               // 2015-08-18T06:36:40.321Z
        System.out.println("millisecondsString\t: " + millisecondsString);
        long milliseconds = instantTruncatedToMilliseconds.toEpochMilli();

        // java.util.Date date = java.util.Date.from(instant);
        date.setTime(milliseconds);

        return date;
    }
}
