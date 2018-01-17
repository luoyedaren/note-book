package note.book.lamada;

import org.junit.Test;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 * 正则
 * 表 1. 常见正则表达式结构
 * 正则表达式结构	符合匹配条件的内容
 * <p>
 * <p>
 * .	任何字符
 * ?	前面的零 (0) 或一 (1) 个字符或数字
 * 前面的零 (0) 或更多个字符或数字
 * +	前面的一 (1) 或更多个字符或数字
 * []	一个字符或数字范围
 * ^	后面的条件的否定条件（即 “非后面的条件”）
 * \d	任何数字（也可表示为 [0-9]）
 * \D	任何非数字（也可表示为 [^0-9]）
 * \s	任何空格字符（也可表示为 [\n\t\f\r]）
 * \S	任何非空格字符（也可表示为 [^\n\t\f\r]）
 * \w	任何单词字符（也可表示为 [a-zA-Z_0-9]）
 * \W	任何非单词字符（也可表示为 [^\w]）
 */

public class RegularTest {
	@Test
	public void one() throws Exception {
		String s = "12";
		Pattern compile = Pattern.compile("\\d?");
		Matcher matcher = compile.matcher(s);
		System.out.println(matcher.find());

	}

	@Test
	public void two() throws Exception {
		String input = "Here is a WikiWord followed by AnotherWikiWord, then SomeWikiWord.";
		Pattern pattern = Pattern.compile("[A-Z][a-z]*([A-Z][a-z]*)+");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
//			Logger.getAnonymousLogger().info("Found this wiki word: " + matcher.group());
			System.out.println(matcher.group());
		}

		Pattern pattern1 = Pattern.compile("([A-Z][a-z]){2}");
		Matcher matcher1 = pattern1.matcher(input);
		System.out.println("patten 2 -------------");
		while (matcher1.find()) {
			System.out.println(matcher1.group());
		}

		//替换
		String replaceStr = matcher.replaceAll("chenghai");
		System.out.println(replaceStr);

	}

	@Test
	public void testFindMatches() {

		String input = "Do you run? Ran? No, bro, run! Bro, I ran and run.";

		String regex = "r[au]n";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		int matchCount = 0;
		StringBuilder matchHolder = new StringBuilder();
		while (matcher.find()) {
			if (matchCount > 0)
				matchHolder.append(',');
			matchHolder.append(matcher.group());
			matchCount++;
		}

		System.out.println("Matches: " + matchHolder.toString());

	}
}
