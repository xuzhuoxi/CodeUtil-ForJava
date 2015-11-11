package code.chinese;

/**
 * 汉字范围[0x4e00,0x9fa5]
 * 
 * @author xuzhuoxi
 *
 */
public class ChineseUtils {
	private static final StringBuilder sb = new StringBuilder();
	private static final String someChinese = "[\u4e00-\u9fa5]*";
	private static final String endStr = "$";

	private ChineseUtils() {
	}

	/**
	 * 检测是否为中文字符<br>
	 * 注：中文字符指是中国字，不包括中文标点
	 * 
	 * @param word
	 *            待判断的字符
	 * @return 是中文字符返回true,否则返回false。
	 */
	public static final boolean isChinese(char word) {
		return word >= 0x4e00 && word <= 0x9fa5;
	}

	/**
	 * 检测字符串中是否含有中文字符<br>
	 * 注：中文字符指是中国字，不包括中文标点
	 * 
	 * @param words
	 *            待判断的字符串
	 * @return 字符串包含中文字符返回true,否则返回false。
	 */
	public static final boolean hasChinese(String words) {
		boolean b;
		for (int i = 0; i < words.length(); i++) {
			b = isChinese(words.charAt(i));
			if (b)
				return true;
		}
		return false;
	}

	/**
	 * 获得字符串中的中文索引号
	 * 
	 * @param words
	 *            待计算字符串
	 * @return 返回每个中文字符返回字符串中的索引组成的数组。
	 */
	public static final int[] getChineseIndexs(String words) {
		if (words == null || words.length() == 0) {
			return null;
		}
		int[] temp = new int[words.length()];

		int j = 0;
		boolean b;
		for (int i = 0; i < words.length(); i++) {
			b = isChinese(words.charAt(i));
			if (b) {
				temp[j] = i;
				j++;
			}
		}
		if (j == 0) {
			return null;
		}
		int[] rs = new int[j];
		System.arraycopy(temp, 0, rs, 0, rs.length);
		return rs;
	}

	/**
	 * 计算字符串中的针对中文字符而成的正则表达式
	 * 
	 * @param chineseInput
	 *            包含中文字符的字符串
	 * @return 字符串形式的正则表达式
	 */
	public static final String toChineseWordsRegexp(String chineseInput) {
		sb.setLength(0);
		sb.append("^");
		char c;
		boolean isPC = true;
		boolean isC = false;
		for (int i = 0; i < chineseInput.length(); i++) {
			c = chineseInput.charAt(i);
			isC = ChineseUtils.isChinese(c);
			if (isC) {
				sb.append(c);
			} else if (0 == i || isPC) {
				sb.append(someChinese);
			}
			isPC = isC;
		}
		if (isPC) {
			sb.append(someChinese);
		}
		sb.append(endStr);
		return sb.toString();
	}

	/**
	 * 判断字符是否为拼音所用到的字符(不区分大小写)
	 * 
	 * @param c
	 *            待判断的字符
	 * @return 如果是中文拼音所使用到的字符，则返回true，否则返回false。<br>
	 * 
	 */
	public static final boolean isPinyinChar(char c) {
		return (c >= 0x0041 && c <= 0x005A) || (c >= 0x0061 && c <= 0x007A);
	}

	/**
	 * 判断字符是否为五笔所用到的字符(不区分大小写，忽略z)
	 * 
	 * @param c
	 *            待判断的字符
	 * @return 如果是中文五笔所使用到的字符，则返回true，否则返回false。<br>
	 */
	public static final boolean isWubiChar(char c) {
		return (c >= 0x0041 && c < 0x005A) || (c >= 0x0061 && c < 0x007A);
	}
}
