package code.regexp;

/**
 * 注意要转义
 * 
 * @author xuzhuoxi
 *
 */
public class RegexpUtils {

	/**
	 * ^-?[1-9]d*|0$ //匹配整数
	 */
	public static final String REGEX_INTEGER = "^[\\-\\+]?([1-9]\\d*|0)$";
	/**
	 * +?[1-9]d*$ //匹配正整数(包括带+号的正数)
	 */
	public static final String REGEX_INTEGER_POSITIVE = "^\\+?[1-9]\\d*$";
	/**
	 * ^-[1-9]d*$ //匹配负整数
	 */
	public static final String REGEX_INTEGER_NEGTIVE = "^\\-[1-9]\\d*$";
	/**
	 * ^+?[1-9]d*|0$ //匹配非负整数（正整数 + 0，也包括带+的正数）
	 */
	public static final String REGEX_INTEGER_NOT_NEGTIVE = "^\\+?[1-9]\\d*|0$";
	/**
	 * ^-[1-9]d*|0$ //匹配非正整数（负整数 + 0）
	 */
	public static final String REGEX_INTEGER_NOT_POSITIVE = "^\\-[1-9]\\d*|0$";
	/**
	 * ^[-+]?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$ //匹配浮点数
	 */
	public static final String REGEX_FLOAT = "^[\\-\\+]?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|[\\-\\+]?0?\\.0+|0)$";
	/**
	 * ^+?[1-9]d*.d*|0.d*[1-9]d*$ //匹配正浮点数
	 */
	public static final String REGEX_FLOAT_POSITIVE = "^\\+?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)$";
	/**
	 * ^-([1-9]d*.d*|0.d*[1-9]d*)$ //匹配负浮点数
	 */
	public static final String REGEX_FLOAT_NEGTIVE = "^\\-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)$";
	/**
	 * ^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$ //匹配非负浮点数（正浮点数 + 0）
	 */
	public static final String REGEX_FLOAT_NOT_NEGTIVE = "^\\+?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|[\\-\\+]?0?\\.0+)|0$";
	/**
	 * ^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$ //匹配非正浮点数（负浮点数 + 0）
	 */
	public static final String REGEX_FLOAT_NOT_POSITIVE = "^(\\-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|[\\-\\+]?0?\\.0+|0$";
	/**
	 * ^[A-Za-z]+$ //匹配由26个英文字母组成的字符串
	 */
	public static final String REGEX_ENGLISH_LETTER = "^[A-Za-z]+$";
	/**
	 * ^[A-Z]+$ //匹配由26个英文字母的大写组成的字符串
	 */
	public static final String REGEX_ENGLISH_LETTER_UPPER = "^[A-Z]+$";
	/**
	 * ^[a-z]+$ //匹配由26个英文字母的小写组成的字符串
	 */
	public static final String REGEX_ENGLISH_LETTER_LOWER = "^[a-z]+$";
	/**
	 * ^[A-Za-z0-9]+$ //匹配由数字和26个英文字母组成的字符串
	 */
	public static final String REGEX_STRING_LETTER_NUMBER = "^[A-Za-z0-9]+$";
	/**
	 * ^w+$ //匹配由数字、26个英文字母或者下划线组成的字符串
	 */
	public static final String REGEX_STRING_NAMED = "^\\w+$";
	/**
	 * 只能输入数字：“^[0-9]*$”
	 */
	public static final String REGEX_STRING_NUMBER = "^[0-9]+$";

	/**
	 * 只能输入汉字：“^[u4e00-u9fa5],{0,}$”
	 */
	public static final String REGEX_CHINESE_CHARACTERS = "^[\u4e00-\u9fa5]+$";

	/**
	 * 验证Email地址：“^w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$”
	 */
	public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

	/**
	 * 验证InternetURL
	 */
	public static final String REGEX_INTERNET_URL = "^((http|ftp|https)://)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?$";
	/**
	 * 验证电话号码：
	 * 固定电话<br>
	 * 种类一："4008008888", "400-800-8888" 表达式:d{10}|d{3}-d{3}-d{4}<br>
	 * 种类二："34751234"，"3475-1234" 表达式:d{8}|d{4}-d{4}<br>
	 * 种类三："(区号)34751234"，"(区号)3475-1234" 表达式:\(d{3,4}\)(d{8}|d{4}-d{4})<br>
	 * 种类四："区号-34751234"，"区号-3475-1234" 表达式:d{34}-(d{8}|d{4}-d{4})<br>
	 */
	public static final String REGEX_PHONE = "^(\\d{10}|\\d{3}\\-\\d{3}\\-\\d{4})|(((\\(\\d{3,4}\\))|((\\d{3,4}\\-)))?(\\d{8}|\\d{4}\\-\\d{4}))$";
	/**
	 * 验证电话号码： 手机 种类一："13000000000","130-0000-0000","130-000-00000";
	 */
	public static final String REGEX_PHONE_MOBILE = "^\\d{11}|(\\d{3}\\-\\d{4}\\-\\d{4})|(\\d{3}\\-\\d{3}\\-\\d{5})$";
	/**
	 * 验证身份证号（15位或18位数字）：“^d{15}|d{18}$”
	 */
	public static final String REGEX_ID_CHINA = "^\\d{15}|\\d{18}$";
	/**
	 * 验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12”
	 */
	public static final String REGEX_MONTH = "^(0?[1-9]|1[0-2])$";
	/**
	 * 验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$”
	 */
	public static final String REGEX_DATE = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
}
