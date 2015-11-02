package code.math;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void testGetCombinationCount() {
		int[] len = { 5, 4, 3 };
		int[] d = { 1, 2, 3 };
		int[] r = { 5, 10, 10, 4, 6, 4, 3, 3, 1 };
		int i = 0;
		for (int l : len) {
			for (int v : d) {
				int rs = MathUtils.getCombinationCount(l, v);
				Assert.assertEquals(rs, r[i]);
				i++;
			}
		}
	}

	@Test
	public void testTenToCustomSystem() {
		int[] system = { 3, 2, 5, 2, 4 };
		for (int i = 0; i < 240; i++) {
			int[] value = MathUtils.tenToCustomSystem(i, system);
			for (int v : value) {
				System.out.print(v);
			}
			System.out.println();
		}
	}
}
