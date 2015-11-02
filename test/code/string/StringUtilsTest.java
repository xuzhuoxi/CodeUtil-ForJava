package code.string;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testToNonRepeatString() {
		String str = "abcddabcdd";
		String rs = "abcd";
		Assert.assertEquals(StringUtils.toNonRepeatString(str), rs);
	}

	@Test
	public void testStructStringStringIntArray() {
		String str = "abcddabcdd";
		int[] indexs = { 1, 3, 2, 1 };
		String rs = "bdcb";
		Assert.assertEquals(StringUtils.structString(str, indexs), rs);
	}

	@Test
	public void testStructStringStringInt() {
		String str = "abcddabcdd";
		int[] indexs = { 0, 3, 9, 10, -1 };
		String[] rs = { "bcddabcdd", "abcdabcdd", "abcddabcd", "abcddabcdd", "abcddabcdd" };
		Assert.assertEquals(indexs.length, rs.length);
		for (int i = 0; i < indexs.length && i < rs.length; i++) {
			// System.out.println(rs[i] + " " + StringUtils.structString(str,
			// indexs[i]));
			Assert.assertEquals(StringUtils.structString(str, indexs[i]), rs[i]);
		}
	}

	@Test
	public void testRemoveChars() {
		StringBuilder sb = new StringBuilder("abcddabcdd");
		int[] indexs = { 1, 3, 5 };
		String rs = "acdbcdd";
		StringUtils.removeChars(sb, indexs);
		Assert.assertEquals(sb.toString(), rs);
	}

	@Test
	public void testNonRepeatFactorial() {
		String str = "abcdede";
		this.comsole(StringUtils.nonRepeatFactorial(str, 1));
		this.comsole(StringUtils.nonRepeatFactorial(str, 2));
	}

	private void comsole(String[] arrs) {
		System.out.println("StringCombinationTest.trace()");
		for (String str : arrs) {
			System.out.print(" " + str);
		}
		System.out.println();
	}
}
