package note.book.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * project: note-book
 * Created by chenghai on 2017/10/13. - 星期五
 */
public class JoinerTest {

	@Test
	public void listToStrings() throws Exception {
		List<String> list = Lists.newArrayList("mike", "jen", "dolad");
		String join = Joiner.on(",").join(list);
		System.out.println(join);// mike,jen,dolad

	}

	@Test
	public void mapToStrings() throws Exception {
		Map<String, Object> map = Maps.newHashMap();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		String join = Joiner.on(",").withKeyValueSeparator(" = ").join(map);
		System.out.println(join);// one = 1,two = 2,three = 3


	}

	@Test
	public void nestCollectionsToStrings() throws Exception {
		List<ArrayList<String>> nested = Lists.newArrayList(
				Lists.newArrayList("apple", "banana", "orange"),
				Lists.newArrayList("cat", "dog", "bird"),
				Lists.newArrayList("John", "Jane", "Adam"));

		String result = Joiner.on(";").join(Iterables.transform(nested,
				input -> Joiner.on("-").join(input)));

		System.out.println(result);

	}

	@Test
	public void handleNullValues() throws Exception {
		List<String> list = Lists.newArrayList("mike", "jen", "dolad", null);
		String join = Joiner.on(",").skipNulls().join(list);
		System.out.println(join);// mike,jen,dolad

		//replace null or 指定的字符
		String aNull = Joiner.on(",").useForNull("empty").join(list);
		System.out.println(aNull); // mike,jen,dolad,empty

	}
}
