package code.math;

import org.junit.Test;

public class NumberSystemUtilTest {
	@Test
	public void test26to10() {
		String[] t = new String[] { "A", "B", "Y", "Z", "AA" };
		for (String string : t) {
			System.out.println(t.toString() + " " + NumberSystemUtil.toNumberSystem10(string));
		}
	}

	@Test
	public void test10to26() {
		int[] arr = new int[] { 0, 1, 2, 25, 26, 29 };
		for (int i : arr) {
			System.out.println(i + " " + NumberSystemUtil.toNumberSystem26(i));
		}
	}
}
