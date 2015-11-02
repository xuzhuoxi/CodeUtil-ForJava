package code.chinese;

import org.junit.Assert;
import org.junit.Test;

public class ChineseUtilsTest {

	@Test
	public void testIsChinese() {
		char[] chs = { 'a', '你', '，' };
		boolean[] rs = { false, true, false };
		Assert.assertEquals(chs.length, rs.length);
		for (int i = 0; i < chs.length && i < rs.length; i++) {
			Assert.assertEquals(ChineseUtils.isChinese(chs[i]), rs[i]);
		}
	}

	@Test
	public void testHasChinese() {
		String[] testStr = new String[] { "你", "a你", "你a", "a你a", "你你", "a你你", "你你a", "a你你a", "你a你", "", "b" };
		boolean[] rs = { true, true, true, true, true, true, true, true, true, false, false };
		Assert.assertEquals(testStr.length, rs.length);
		for (int i = 0; i < testStr.length && i < rs.length; i++) {
			Assert.assertEquals(ChineseUtils.hasChinese(testStr[i]), rs[i]);
		}
	}

	@Test
	public void testGetChineseIndexs() {
		String[] testStr = new String[] { "你", "a你", "你a", "a你a", "你你", "a你你", "你你a", "a你你a", "你a你", "", "b" };
		int[][] rs = { { 0 }, { 1 }, { 0 }, { 1 }, { 0, 1 }, { 1, 2 }, { 0, 1 }, { 1, 2 }, { 0, 2 }, null, null };
		Assert.assertEquals(testStr.length, rs.length);
		for (int i = 0; i < testStr.length && i < rs.length; i++) {
			int[] result = ChineseUtils.getChineseIndexs(testStr[i]);
			Assert.assertArrayEquals(result, rs[i]);
		}
	}

	@Test
	public void testToChineseWordsRegexp() {
		String[] testStr = new String[] { "你", "a你", "你a", "a你a", "你你", "a你你", "你你a", "a你你a", "你ab你" };
		String[] rs = new String[] { "^你[\u4e00-\u9fa5]*$", "^[\u4e00-\u9fa5]*你[\u4e00-\u9fa5]*$",
				"^你[\u4e00-\u9fa5]*$", "^[\u4e00-\u9fa5]*你[\u4e00-\u9fa5]*$", "^你你[\u4e00-\u9fa5]*$",
				"^[\u4e00-\u9fa5]*你你[\u4e00-\u9fa5]*$", "^你你[\u4e00-\u9fa5]*$", "^[\u4e00-\u9fa5]*你你[\u4e00-\u9fa5]*$",
				"^你[\u4e00-\u9fa5]*你[\u4e00-\u9fa5]*$" };
		Assert.assertEquals(testStr.length, rs.length);
		for (int i = 0; i < testStr.length && i < rs.length; i++) {
			String regexp = ChineseUtils.toChineseWordsRegexp(testStr[i]);
			Assert.assertEquals(regexp, rs[i]);
		}
	}
}
