package co.com.core.commons;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

public class ApplicationUtil {

	private static final Logger logger = Logger.getLogger(ApplicationUtil.class);
	
	/**
	 * return the string related to the date and format
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormattedDate(Date date, String format, String complement) {
		String dateStr = null;
		DateFormat df = new SimpleDateFormat(format);
		dateStr = df.format(date);
		if(complement!=null) {
			return dateStr + " " + complement; 
		}
		return dateStr;
	}
	
	/**
	 * returns a date based on the string
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static  Date getDateFromString(String strDate, String format) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			logger.error("Throwed Exception [ApplicationUtil.getDateFromString]:" + e.getMessage());
		}
		return date;
	}
	
	public static String formatNumber(long number) {
		String strNumber = String.valueOf(number);
		return NumberFormat.getNumberInstance(Locale.US).format(strNumber);
	}
}
