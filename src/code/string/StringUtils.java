package code.string;

import java.util.Arrays;

public class StringUtils {
	/**
	 * 如果源字符串中有相同的字符，则去掉后面的<br>
	 * 
	 * @param str
	 *            源字符串
	 * @return 新的字符串
	 */
	public static final String toNonRepeatString(String str) {
		if (null == str || str.length() <= 1) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		String[] strs = str.split("");
		for (int i = 0; i < strs.length; i++) {
			if (sb.indexOf(strs[i]) == -1) {
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 根据源字符串，构造新的字符串
	 * 
	 * @param source
	 *            源字符串
	 * @param includeIndex
	 *            源字符串的下标数组，新字符串由源字符串对应下标字符组成
	 * @return 新的字符串
	 */
	public static final String structString(String source, int[] includeIndex) {
		StringBuilder sb = new StringBuilder();
		for (int i : includeIndex) {
			sb.append(source.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * 
	 * 根据源字符串，构造新的字符串
	 * 
	 * @param source
	 *            源字符串
	 * @param ignoreIndex
	 *            忽略的源字符下标
	 * @return 新的字符串
	 */
	public static final String structString(String source, int ignoreIndex) {
		if (ignoreIndex < 0 || ignoreIndex >= source.length())
			return source;
		return source.substring(0, ignoreIndex) + source.substring(ignoreIndex + 1, source.length());
	}

	/**
	 * 从一个StringBuilder实例中移除若干个字符
	 * 
	 * @param source
	 *            StringBuilder实例
	 * @param excludeIndex
	 *            下标数组，要求不重复
	 */
	public static final void removeChars(StringBuilder source, int[] excludeIndex) {
		int[] index = excludeIndex.clone();
		Arrays.sort(index);
		for (int i = index.length - 1; i >= 0; i--) {
			if (index[i] <= source.length()) {
				source.deleteCharAt(index[i]);
			}
		}
	}

	/**
	 * 无重复组合<br>
	 * 由源字符串中的字符进行组合，得到的组合字符符合源字符串顺序，如：<br>
	 * 源"abc"，只会产出"ab"不会产出"ba"<br>
	 * 
	 * @param source
	 * @param factorialLevel
	 *            组合维度，最多使用多少个字符进行组合
	 * @return
	 */
	public static final String[] nonRepeatFactorial(String source, int factorialLevel) {
		if (factorialLevel <= 0) {
			throw new Error("FactorialLevel should be greater than 0.");
		}
		String[] newSource = source.split("");
		return StringCombination
				.dimensionalityReduction(StringCombination.getTwoDimensionArray(newSource, factorialLevel));

	}
}
