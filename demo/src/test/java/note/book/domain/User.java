package note.book.domain;

import lombok.Data;

/**
 * project: note-book
 * Created by chenghai on 2017/11/14. - 星期二
 */
@Data
public class User {
	private String name;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String reportName() {
		System.out.println("name is " + name);
		return name;
	}
}
