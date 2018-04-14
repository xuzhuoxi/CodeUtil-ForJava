package code.math;

public class NumberSystemUtil {
	/**
	 * 十进制数 转为 26进制字符表示<br>
	 * 
	 * 将指定的自然数转换为26进制表示。映射关系：[1-26] ->[A-Z]。
	 * 
	 * @param n
	 *            十进制自然数<br>
	 *            （如果无效，则返回空字符串）。
	 * @return 26进制字符
	 */
	public static String toNumberSystem26(int n) {
		String s = "";
		while (n > 0) {
			int m = n % 26;
			if (m == 0)
				m = 26;
			s = (char) (m + 64) + s;
			n = (n - m) / 26;
		}
		return s;
	}

	/**
	 * 26进制字符 转为 十进制数<br>
	 * 
	 * 将指定的26进制表示转换为自然数。映射关系：[A-Z] ->[1-26]。
	 * 
	 * @param s
	 *            26进制字符
	 * @return 十进制自然数。
	 */
	public static int toNumberSystem10(String s) {
		if (s.isEmpty())
			return 0;
		int n = 0;
		for (int i = s.length() - 1, j = 1; i >= 0; i--, j *= 26) {
			char c = Character.toUpperCase(s.charAt(i));
			if (c < 'A' || c > 'Z')
				return 0;
			n += ((int) c - 64) * j;
		}
		return n;
	}
}
