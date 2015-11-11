package code.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

	@Test
	public void testCleanRepeat2List() {
		Character[] cs = new Character[] { 'a', 'b', 'c', 'a', 'b', 'c' };
		Character[] result = new Character[] { 'a', 'b', 'c' };
		Character[] rs = ArrayUtils.cleanRepeat2List(cs);
		Assert.assertArrayEquals(rs, result);
	}

	@Test
	public void testEqualsTArrayTArray() {
		Character[] result = new Character[] { 'a', 'b', 'c' };
		Character[] result2 = new Character[] { 'a', 'b', 'c' };
		Character[] result3 = new Character[] { 'a', 'b' };
		Character[] result4 = new Character[] { 'a', 'c', 'b' };
		Assert.assertTrue(ArrayUtils.equals(result, result2));
		Assert.assertFalse(ArrayUtils.equals(result, result3));
		Assert.assertFalse(ArrayUtils.equals(result, result4));
	}

	@Test
	public void testRemove() {
		Character[] result = new Character[] { 'a', 'b', 'c' };
		Character[] result1 = new Character[] { 'a', 'b' };
		Assert.assertArrayEquals(ArrayUtils.remove(result, 2), result1);
	}

	@Test
	public void testIsExist() {
		Character[] result = new Character[] { 'a', 'b', 'c' };
		Assert.assertTrue(ArrayUtils.isExist(result, 'b'));
		Assert.assertFalse(ArrayUtils.isExist(result, 'B'));
	}

	@Test
	public void testAddAll() {
		Character[] result = new Character[] { 'a', 'b', 'c', 'a', 'b', 'c' };
		Character[] result2 = new Character[] { 'a', 'b', 'c' };
		Character[] result3 = new Character[] { 'a', 'b', 'c' };
		Assert.assertArrayEquals(result, ArrayUtils.mergeArray(result2, result3));
	}

	@Test
	public void testSubArrayTArrayInt() {
		Character[] result = new Character[] { 'a', 'b', 'c', 'a', 'b', 'c' };
		Character[] result2 = new Character[] { 'a', 'b', 'c' };
		Character[] result3 = new Character[] { 'b', 'c', 'a', 'b', 'c' };
		Assert.assertArrayEquals(result2, ArrayUtils.subArray(result, 3));
		Assert.assertArrayEquals(result3, ArrayUtils.subArray(result, 1));
	}

	@Test
	public void testSubArrayTArrayIntInt() {
		Character[] result = new Character[] { 'a', 'b', 'c', 'a', 'b', 'c' };
		Character[] result2 = new Character[] { 'a', 'b' };
		Character[] result3 = new Character[] { 'b', 'c', 'a', 'b' };
		Assert.assertArrayEquals(result2, ArrayUtils.subArray(result, 0, 2));
		Assert.assertArrayEquals(result3, ArrayUtils.subArray(result, 1, 5));
	}

	@Test
	public void testReverse() {
		Character[] result = new Character[] { 'a', 'b' };
		Character[] result2 = new Character[] { 'b', 'a' };
		ArrayUtils.reverse(result);
		Assert.assertArrayEquals(result2, result);
		Character[] result3 = new Character[] { 'a', 'b', 'c' };
		Character[] result4 = new Character[] { 'c', 'b', 'a' };
		ArrayUtils.reverse(result3);
		Assert.assertArrayEquals(result3, result4);
	}

	@Test
	public void testDimensionalityReduction() {
		Character[][] result = new Character[][] { new Character[] { 'a', 'b' }, new Character[] { 'c', 'b' },
				new Character[] { 'a', 'e' } };
		Character[] result2 = new Character[] { 'a', 'b', 'c', 'b', 'a', 'e' };
		Assert.assertArrayEquals(result2, ArrayUtils.dimensionalityReduction(result));
	}
}
