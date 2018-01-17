package note.book.jdk.base;

import com.google.common.collect.Lists;
import note.book.domain.User;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

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

	//方法泛型化
	public <E> String get(List<E> t) {
		String s = "";
		t.forEach(t1 -> {
			System.out.println(t1);
			s.concat(t1.toString());

		});
		return s;
	}

	public <E> List getTwo(String s, List<E> list1) {
		list1.size();
		return list1;
	}

	@Test
	public void three() throws Exception {
		List a = getTwo("a", Collections.emptyList());
		System.out.println(a);
		List list1 = Lists.newArrayList(new User("mike"), new User("tome"));
		getTwo("", list1);
		System.out.println(getTwo("", list1));
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
