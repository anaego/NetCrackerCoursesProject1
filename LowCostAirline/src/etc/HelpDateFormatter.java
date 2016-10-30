package etc;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/** for the correct output of the gregorian calendar dates
 * @author Anastasia
 */
public class HelpDateFormatter {
	
	public static String DateFormatter (GregorianCalendar calendar) {
	    SimpleDateFormat fmt = new SimpleDateFormat("d MMM yyyy HH:mm");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}

}
