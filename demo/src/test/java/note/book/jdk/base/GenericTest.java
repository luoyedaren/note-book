package note.book.jdk.base;

import note.book.domain.User;
import org.junit.Test;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 * 类型擦除
 */
public class GenericTest {

	@Test
	public void testOne() throws Exception {
		Container<User> userContainer = new Container<>(new User("mike"));
		User conatiner = userContainer.getConatiner();
		System.out.println(conatiner);
	}
}

class Container<T> {
	private T conatiner;

	public Container() {
	}

	public Container(T conatiner) {
		this.conatiner = conatiner;
	}

	public T getConatiner() {
		return conatiner;
	}

	public void setConatiner(T conatiner) {
		this.conatiner = conatiner;
	}
}
