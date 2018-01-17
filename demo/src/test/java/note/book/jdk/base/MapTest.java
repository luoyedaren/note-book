package note.book.jdk.base;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 */
public class MapTest {
	@Test
	public void testMapMerge() throws Exception {
		Map<String, Integer> map = Maps.newHashMap();
		map.merge("a", 1, (oldValue, value) -> oldValue + value);
		System.out.println(map.get("a"));

		//累加value值 v+1
		map.merge("a", 1, (oldValue, value) -> oldValue + value);
		System.out.println(map.get("a"));
	}

	@Test
	public void testjdk8Map() throws Exception {
		Map<String, String> map = Maps.newHashMap();
		map.put("a", "test");
		System.out.println(map.get("a"));
//		不存在才放入
		map.putIfAbsent("a", null);
		System.out.println(map.get("b"));
		System.out.println(map.get("a"));

		map.remove("a", "1");
		System.out.println(map);
		map.remove("a", "test");
		System.out.println(map);

		map.putIfAbsent("a", "test");
//		发现key就把value替换掉
		map.replace("a", "newtest");
		System.out.println(map);
//		发现key 和value都存在，替换value
		map.replace("a", "test", "2teset");
		System.out.println(map);
		map.replace("a", "newtest", "2test");
		System.out.println(map);

//		遍历map
		map.forEach((k, v) -> {
			System.out.println(k.concat(":").concat(v));
		});

		System.out.println(map);
	}
}
