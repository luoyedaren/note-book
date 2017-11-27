package note.book.jdk.base;

import note.book.domain.User;
import org.junit.Test;

/**
 * project: note-book
 * Created by chenghai on 2017/11/27. - 星期一
 */
public class ParentAndChildTest {

	@Test
	public void one() throws Exception {
		Person p = new Person();
		p.setName("mike");
//		addPerson(p);
		User user = new User();
		user.setName("mike's user");
		addPerson(user);
	}

	public void addPerson(User user) {
		System.out.println(user.getName());
	}

}


class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class user extends Person {
	private String address;

}