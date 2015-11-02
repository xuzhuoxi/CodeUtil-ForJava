package code.string;

public class StringMatching {
	/**
	 * 把expression按字母分布到source中，返回分布后命中的索引 当source用完时expression还有剩余则返回null<br>
	 * 如：<br>
	 * source:"abcde" expression:"abcd"<br>
	 * return:[true,true,true,true,false]<br>
	 * 
	 * source:"abcde" expression:"abcde"<br>
	 * return:[true,true,true,true,true]<br>
	 * 
	 * source:"abcde" expression:"abcdef"<br>
	 * return:null<br>
	 * 
	 * @param source
	 * @param expression
	 * @return
	 */
	public static final boolean[] matching(String source, String expression) {
		if (null == source || null == expression || expression.length() > source.length()) {
			return null;
		}
		int ei = 0;
		int si = 0;
		boolean[] result = new boolean[source.length()];
		final char emptyChar = ' ';
		char eChar;
		char sChar;
		int tempSi;
		for (; ei < expression.length(); ei++) {
			eChar = expression.charAt(ei);
			if (emptyChar != eChar) {
				for (; si < source.length();) {
					sChar = source.charAt(si);
					tempSi = si;
					si++;
					if (eChar == sChar) {
						result[tempSi] = true;
						if (ei == expression.length() - 1) {
							return result;
						}
						break;
					}
				}
			}
			if (si == source.length()) {
				return null;
			}
		}
		return result;
	}

	/**
	 * 正常值[0,2] 2代表完全匹配
	 * 
	 * @param matchResult
	 * @return
	 */
	public static final double computeMatchintResult(boolean[] matchResult) {
		boolean isFullMatching = true;
		if (null != matchResult && matchResult.length > 0) {
			double result = 0;
			for (int index = 0; index < matchResult.length; index++) {
				if (matchResult[index]) {
					result += (1 / Math.pow(2, index));
				} else {
					isFullMatching = false;
				}
			}
			if (isFullMatching) {
				return 2;
			} else {
				return result;
			}
		} else {
			return 0;
		}
	}
}
