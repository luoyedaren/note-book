package note.book.joda.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.Locale;


/**
 * project: note-book
 * Created by chenghai on 2017/11/30. - 星期四
 */
public class SimpleTimeTest {

	@Test
	public void one() throws Exception {
		// LocalDate
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.monthOfYear().getAsText());
		System.out.println(localDate.monthOfYear().getAsShortText(Locale.ENGLISH));

		// DateTime
		DateTime dt = new DateTime();
		DateTime year = dt.withYear(2000);
		System.out.println(year);
		DateTime plusHours = dt.plusHours(2);
		System.out.println(plusHours);

	}
}
