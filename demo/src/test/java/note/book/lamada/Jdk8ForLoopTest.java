package note.book.lamada;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 */
public class Jdk8ForLoopTest {
	@Test
	public void intStreamTest() throws Exception {
		//和传统for中的 i不同 ，传统的变量i是i++，值变，变量还是i,
		// 拉姆达中的变量i 每一次都是一个新的变量
		IntStream.range(0, 10).forEach(i -> System.out.println(i));
		System.out.println("------包含边界");
		IntStream.rangeClosed(0, 10).forEachOrdered(i -> System.out.println(i));

		System.out.println("---------------");
		//定义步长和限定区域
		int sum = IntStream.iterate(1, e -> e + 2).limit(10).sum();
		System.out.println(sum);


	}
}
