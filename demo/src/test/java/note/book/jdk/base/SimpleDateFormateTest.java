package note.book.jdk.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 * 线程不安全
 * 方案
 * 1. 每次使用都new一个  太耗gc
 * 2.  枷锁  synchronized(sdf)
 * 3. 使用 ThreadLocal 实例化一个线程安全的对象
 */
public class SimpleDateFormateTest {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static ThreadLocal<SimpleDateFormat> simpleDateFormateThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			new Thread(() -> {
				try {
//					System.out.println(sdf.parse("2018-01-17 10:40:11"));
					System.out.println(simpleDateFormateThreadLocal.get().parse("2018-01-17 10:40:11"));

				} catch (ParseException e) {
					e.printStackTrace();
				}

			}).start();

		}
	}
}
