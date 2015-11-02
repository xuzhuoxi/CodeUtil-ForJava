package code.regexp;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegexpUtilsTest {

	/**
	 * ^-?[1-9]d*$ //匹配整数
	 */
	@Test
	public void testRegex01Integer() {
		String[] integers = { "0", "1", "-1", "+1", "01", "-+1" };
		boolean[] results = { true, true, true, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTEGER), results[i]);
		}
	}

	/**
	 * +?[1-9]d*$ //匹配正整数(包括带+号的正数)
	 */
	@Test
	public void testRegex01IntegerPositive() {
		String[] integers = { "0", "1", "-1", "+1", "01", "-+1" };
		boolean[] results = { false, true, false, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTEGER_POSITIVE), results[i]);
		}
	}

	/**
	 * ^-[1-9]d*$ //匹配负整数
	 */
	@Test
	public void testRegex01IntegerNegtive() {
		String[] integers = { "0", "1", "-1", "+1", "01", "-+1" };
		boolean[] results = { false, false, true, false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTEGER_NEGTIVE), results[i]);
		}
	}

	/**
	 * ^+?[1-9]d*|0$ //匹配非负整数（正整数 + 0，也包括带+的正数）
	 */
	@Test
	public void testRegex01IntegerNotNegtive() {
		String[] integers = { "0", "1", "-1", "+1", "01", "-+1" };
		boolean[] results = { true, true, false, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTEGER_NOT_NEGTIVE), results[i]);
		}
	}

	/**
	 * ^-[1-9]d*|0$ //匹配非正整数（负整数 + 0）
	 */
	@Test
	public void testRegex01IntegerNotPositive() {
		String[] integers = { "0", "1", "-1", "+1", "01", "-+1" };
		boolean[] results = { true, false, true, false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTEGER_NOT_POSITIVE), results[i]);
		}
	}

	/**
	 * ^[-+]?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$ //匹配浮点数
	 */
	@Test
	public void testRegex02Float() {
		String[] integers = { "0", "0.0", "0.1", "1.0", "1.1", "-0.0", "-0.1", "-1.0", "-1.1", "+0.0", "+0.1", "+1.0",
				"+1.1", "-+1", "-+1.0", "-+0" };
		boolean[] results = { true, true, true, true, true, true, true, true, true, true, true, true, true, false,
				false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_FLOAT), results[i]);
		}
	}

	/**
	 * ^+?[1-9]d*.d*|0.d*[1-9]d*$ //匹配正浮点数
	 */
	@Test
	public void testRegex02FloatPositive() {
		String[] integers = { "0", "0.0", "0.1", "1.0", "1.1", "-0.0", "-0.1", "-1.0", "-1.1", "+0.0", "+0.1", "+1.0",
				"+1.1", "-+1", "-+1.0", "-+0" };
		boolean[] results = { false, false, true, true, true, false, false, false, false, false, true, true, true,
				false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_FLOAT_POSITIVE), results[i]);
		}
	}

	/**
	 * ^-([1-9]d*.d*|0.d*[1-9]d*)$ //匹配负浮点数
	 */
	@Test
	public void testRegex02FloatNegtive() {
		String[] integers = { "0", "0.0", "0.1", "1.0", "1.1", "-0.0", "-0.1", "-1.0", "-1.1", "+0.0", "+0.1", "+1.0",
				"+1.1", "-+1", "-+1.0", "-+0" };
		boolean[] results = { false, false, false, false, false, false, true, true, true, false, false, false, false,
				false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_FLOAT_NEGTIVE), results[i]);
		}
	}

	/**
	 * ^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$ //匹配非负浮点数（正浮点数 + 0）
	 */
	@Test
	public void testRegex02FloatNotNegtive() {
		String[] integers = { "0", "0.0", "0.1", "1.0", "1.1", "-0.0", "-0.1", "-1.0", "-1.1", "+0.0", "+0.1", "+1.0",
				"+1.1", "-+1", "-+1.0", "-+0" };
		boolean[] results = { true, true, true, true, true, true, false, false, false, true, true, true, true, false,
				false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_FLOAT_NOT_NEGTIVE), results[i]);
		}
	}

	/**
	 * ^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$ //匹配非正浮点数（负浮点数 + 0）
	 */
	@Test
	public void testRegex02FloatNotPositive() {
		String[] integers = { "0", "0.0", "0.1", "1.0", "1.1", "-0.0", "-0.1", "-1.0", "-1.1", "+0.0", "+0.1", "+1.0",
				"+1.1", "-+1", "-+1.0", "-+0" };
		boolean[] results = { true, true, false, false, false, true, true, true, true, true, false, false, false, false,
				false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_FLOAT_NOT_POSITIVE), results[i]);
		}
	}

	/**
	 * ^[A-Za-z]+$ //匹配由26个英文字母组成的字符串
	 */
	@Test
	public void testRegex03EnglishLetter() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, true, true, true, true, false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_ENGLISH_LETTER), results[i]);
		}
	}

	/**
	 * ^[A-Z]+$ //匹配由26个英文字母的大写组成的字符串
	 */
	public void testRegex03EnglishLetterUpper() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, false, false, true, true, false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_ENGLISH_LETTER_UPPER), results[i]);
		}
	}

	/**
	 * ^[a-z]+$ //匹配由26个英文字母的小写组成的字符串
	 */
	@Test
	public void testRegex03EnglishLetterLower() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, true, true, false, false, false, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_ENGLISH_LETTER_LOWER), results[i]);
		}
	}

	/**
	 * ^[A-Za-z0-9]+$ //匹配由数字和26个英文字母组成的字符串
	 */
	@Test
	public void testRegex03EnglishLetterNumber() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, true, true, true, true, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_STRING_LETTER_NUMBER), results[i]);
		}
	}

	/**
	 * ^w+$ //匹配由数字、26个英文字母或者下划线组成的字符串
	 */
	@Test
	public void testRegex04StringNamed() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, true, true, true, true, true, true, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_STRING_NAMED), results[i]);
		}
	}

	/**
	 * 只能输入数字：“^[0-9]*$”
	 */
	@Test
	public void testRegex04StringNumber() {
		String[] integers = { "", "a", "z", "A", "Z", "7", "_", "{" };
		boolean[] results = { false, false, false, false, false, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_STRING_NUMBER), results[i]);
		}
	}

	/**
	 * 只能输入汉字：“^[u4e00-u9fa5],{0,}$”
	 */
	@Test
	public void testRegex05ChineseCharacters() {
		String[] integers = { "", "a", "z好", "好A", "好Z好", "好", "_", "{" };
		boolean[] results = { false, false, false, false, false, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_CHINESE_CHARACTERS), results[i]);
		}
	}

	/**
	 * 验证Email地址：“^w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$”
	 */
	@Test
	public void testRegex06Email() {
		String[] integers = { "abc@sohucom", "abc@.com", "bc@sina com", "abc@com", "abc@163.com" };
		boolean[] results = { false, false, false, false, true };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_EMAIL), results[i]);
		}
	}

	/**
	 * 验证InternetURL：“^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$”
	 */
	@Test
	public void testRegex06Url() {
		String[] integers = { "http://bbs.51testing.com/thread-159585-1-1.html",
				"bbs.51testing.com/thread-159585-1-1.html", "http://www.ltesting.net/ceshi/ceshijishu/csyl/", "abc@com",
				"http://cn.bing.com/search?q=Email%e5%9c%b0%e5%9d%80+%e6%b5%8b%e8%af%95%e7%94%a8%e4%be%8b&qs=n&pq=email%e5%9c%b0%e5%9d%80+%e6%b5%8b%e8%af%95%e7%94%a8%e4%be%8b&sc=0-10&sp=-1&sk=&cvid=84754928d6804015ab08feb52779b272&first=11&FORM=PORE",
				"abc@163.com", "192.168.1.1:80", "www.yahoo.com" };
		boolean[] results = { true, true, true, false, true, false, true, true };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_INTERNET_URL), results[i]);
		}
	}

	/**
	 * 验证电话号码：“^((d{3,4})|d{3,4}-)?d{7,8}$”
	 */
	@Test
	public void testRegex06Phone() {
		String[] integers = { "4008008888", "400-800-8888", "34751234", "3475-1234", "(020)34751234", "(020)3475-1234",
				"020-34751234", "020-3475-1234", "12345678", "123456789" };
		boolean[] results = { true, true, true, true, true, true, true, true, true, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_PHONE), results[i]);
		}
	}

	/**
	 * 验证电话号码： 手机 种类一："13000000000","130-0000-0000","130-000-00000";
	 */
	@Test
	public void testRegex06PhoneMobile() {
		String[] integers = { "13000000000", "130-0000-0000", "130-000-00000" };
		boolean[] results = { true, true, true };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_PHONE_MOBILE), results[i]);
		}
	}

	/**
	 * 验证身份证号（15位或18位数字）：“^d{15}|d{18}$”
	 */
	@Test
	public void testRegexIDChina() {
		String[] integers = { "", "440901197709194316", "4409011977091943160", "44090119770919431" };
		boolean[] results = { false, true, false, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_ID_CHINA), results[i]);
		}
	}

	/**
	 * 验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12”
	 */
	@Test
	public void testRegexMonth() {
		String[] integers = { "", "0", "1", "01", "12", "13" };
		boolean[] results = { false, false, true, true, true, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_MONTH), results[i]);
		}
	}

	/**
	 * 验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$”
	 */
	@Test
	public void testRegexDate() {
		String[] integers = { "", "0", "1", "01", "31", "32" };
		boolean[] results = { false, false, true, true, true, false };
		Assert.assertEquals(integers.length, integers.length);
		for (int i = 0; i < integers.length && i < results.length; i++) {
			// System.out.println("Info(i=" + i + "):" + integers[i] + " " +
			// results[i]);
			Assert.assertEquals(integers[i].matches(RegexpUtils.REGEX_DATE), results[i]);
		}
	}
}
