package code.string;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import code.array.ArrayUtils;

public class StringCombinationTest {

	@Test
	public void testGetTwoDimensionArrayStringArrayIntBoolean() {
		String source = "adede";
		String[] sourceArr = source.split("");
		String[] rs1repeat = { "a", "d", "e", "d", "e" };
		String[] rs2repeat = { "a", "d", "e", "d", "e", "ad", "ae", "ad", "ae", "de", "dd", "de", "ed", "ee", "de" };
		String[] rs3repeat = { "a", "d", "e", "d", "e", "ad", "ae", "ad", "ae", "de", "dd", "de", "ed", "ee", "de",
				"ade", "add", "ade", "aed", "aee", "ade", "ded", "dee", "dde", "ede" };
		String[] rs1 = { "a", "d", "e" };
		String[] rs2 = { "a", "d", "e", "ad", "ae", "de", "dd", "ed", "ee" };
		String[] rs3 = { "a", "d", "e", "ad", "ae", "de", "dd", "ed", "ee", "ade", "add", "aed", "aee", "ded", "dee",
				"dde", "ede" };
		int[] dArr = { 1, 2, 3 };
		String[][] resultRepeatArr = { rs1repeat, rs2repeat, rs3repeat };
		String[][] resultArr = { rs1, rs2, rs3 };
		Assert.assertEquals(resultRepeatArr.length, dArr.length);
		Assert.assertEquals(resultArr.length, dArr.length);
		for (int i = 0; i < 3; i++) {
			int d = dArr[i];
			String[] resultRepeat = resultRepeatArr[i];
			String[] result = resultArr[i];
			arrayEquals(resultRepeat,
					ArrayUtils.dimensionalityReduction(StringCombination.getTwoDimensionArray(sourceArr, d, true)));
			arrayEquals(result,
					ArrayUtils.dimensionalityReduction(StringCombination.getTwoDimensionArray(sourceArr, d, false)));
			arrayEquals(resultRepeat, StringCombination.getDimensionCombinationArray(sourceArr, d, true));
			arrayEquals(result, StringCombination.getDimensionCombinationArray(sourceArr, d, false));
		}
	}

	private void arrayEquals(String[] arr0, String[] arr1) {
		Arrays.sort(arr0, c);
		Arrays.sort(arr1, c);
		// for (int i = 0; i < arr0.length || i < arr1.length; i++) {
		// System.out.println(arr0[i] + "=?" + arr1[i]);
		// }
		Assert.assertArrayEquals(arr0, arr1);
	}

	private Comparator<String> c = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	};

}
