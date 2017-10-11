### guava 

---

#### 字符操作

Joiner Splitter 操作类
```java
public class JoinerAndSplitter {

	public static void main(String[] args) {
		String[] subdirs = {"usr", "local", "lib"};
		String directory = Joiner.on("/").join(subdirs);
		System.out.println(directory);

		int[] numbers = {1, 2, 3, 4, 5};
		String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
		System.out.println(numbersAsString);

		String numbersAsStringDirectly = Ints.join(";", numbers);
		System.out.println(numbersAsStringDirectly);


		//------------------------
		String testString = "foo , what,,,more,";
		Iterable split = Splitter.on(",").split(testString);


		String[] splitRegular = testString.split(",");
		System.out.println(splitRegular);

		Iterable<String> split2 = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);


	}

	@Test
	public void moreDemo() {
		String str = "test1, , test2, test3";
		Iterable<String> strArr = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.split(str);

		System.out.println(strArr);
		//Output:->
		//["test1", "test2", "test3"]
	}

}

```

过滤字符，过滤字符中的数字 or 保留数字
```java
public class CharMatcherDemo {

	public static void main(String[] args) {
		CharMatcher charMatcher = inRange('a', 'z').or(inRange('A', 'Z'));

		// 只留数字
		String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");

		//去掉数字
		String string1 = CharMatcher.DIGIT.removeFrom("some text 89983 and more");

		System.out.println(string);
		System.out.println(string1);

	}

}
```