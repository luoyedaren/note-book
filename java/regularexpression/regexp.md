### 正则表达式

手机号正则 java

^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
(\\+\\d+)?1[3458]\\d{9}$
java代码使用

public static boolean checkMobile(String mobile) { 
        String regex = "(\\+\\d+)?1[3458]\\d{9}$"; 
        return Pattern.matches(regex,mobile); 
    }
预备知识 参考:http://www.runoob.com/regexp/regexp-syntax.html \d 匹配一个数字字符。等价于 [0-9]。 () 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。 手机正则中使用了前匹配，匹配 + \d ,例如 +1 ? 匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 或 "does" 。? 等价于 {0,1}。 + 匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。 * 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。

附带工具地址: https://c.runoob.com/front-end/854