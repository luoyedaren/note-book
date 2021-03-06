package note.book.guava;

import note.book.domain.User;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * project: note-book
 * Created by chenghai on 2017/11/14. - 星期二
 */
public class LambdaTest {
	@Test
	public void one() throws Exception {
		User u = new User();
		Optional<User> user = Optional.ofNullable(u);
		String name = user.get().getName();
		String name1 = user.get().getName();
		if (user.isPresent()) {

		}
		System.out.println(String.format("name1 is %s, name2 is %s", name, name1));
	}

	@Test
	public void two() throws Exception {

		User user = new User();
		List<User> users = Arrays.asList(user);
		users.forEach(User::reportName);

	}

	@Test
	public void three() throws Exception {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		eval(list, n -> true);
		System.out.println("偶数");
		eval(list, n -> n % 2 == 0);
		System.out.println("大于3的数字");
		eval(list, n -> n > 3);

	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		list.forEach(integer -> {
			if (predicate.test(integer)) {
				System.out.println(integer);
			}
		});
	}

	@Test
	public void four() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		System.out.println(localDateTime.toLocalDate());
		System.out.println(localDateTime.toLocalTime());
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getDayOfMonth());

		LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10).withYear(2010);
		System.out.println(localDateTime1);

		LocalDate localDate = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println(localDate);
		LocalDate parse = LocalDate.parse("2017-10-10");
		System.out.println(parse);
	}
}
