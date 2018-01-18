package note.book.guava;

import com.google.common.collect.*;
import org.junit.Test;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 * todo 待看
 * 参考资料 ：https://www.ibm.com/developerworks/cn/java/j-lo-googlecollection/index.html
 * <p>
 * Immutable Collections: 还在使用 Collections.unmodifiableXXX() ？ Immutable Collections 这才是真正的不可修改的集合
 * Multiset: 看看如何把重复的元素放入一个集合
 * Multimaps: 需要在一个 key 对应多个 value 的时候 , 自己写一个实现比较繁琐 - 让 Multimaps 来帮忙
 * BiMap: java.util.Map 只能保证 key 的不重复，BiMap 保证 value 也不重复
 * MapMaker: 超级强大的 Map 构造类
 * Ordering class: 大家知道用 Comparator 作为比较器来对集合排序，但是对于多关键字排序 Ordering class 可以简化很多的代码
 * 其他特性
 */
public class CollectionsTest {

	@Test
	public void one() throws Exception {
		// key->HashMap value->HashSet
		Multimap multimap = HashMultimap.create();
		multimap.put("one", 1);
		multimap.put("one", 2);
		System.out.println(multimap);
		multimap.get("one").stream().forEach(o -> System.out.println(o));
	}

	@Test
	public void two() throws Exception {
		// 双向map
		//bimap key和value都不可重复，key value等价,
		//适合场景：需要根据value反推key
		BiMap biMap = HashBiMap.create();
		biMap.put("one", 1);
		biMap.put("two", 2);
		System.out.println(biMap.inverse().get(2));

	}

	@Test
	public void three() throws Exception {
		//不是set集合  放入重复元素，会存入重复元素的次数
		//[tom, mike x 3, jack] mike放了三次
		Multiset<String> multiset = HashMultiset.create();
		multiset.add("mike");
		multiset.add("jack");
		multiset.add("mike");
		multiset.add("tom");
		multiset.add("mike");
		System.out.println(multiset);
		System.out.println(multiset.count("mike"));
	}
}
