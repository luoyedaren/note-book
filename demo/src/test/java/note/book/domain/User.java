package note.book.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * project: note-book
 * Created by chenghai on 2017/11/14. - 星期二
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 6001125649966767227L;
	private String name;
	private String address;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String reportName() {
		System.out.println("name is " + name);
		return name;
	}
}
