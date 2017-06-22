package code.lang;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class IntegerUtilTest {

	@Test
	public void test() {
		int i = -15646545;
		byte[] ba = IntegerUtil.toByteArray(i, 6);
		int i2 = IntegerUtil.toInt(ba);
		System.out.println(i2);
	}

	@Test
	public void testCommonInteger() {
		int[] intValues = new int[] { 0, 1, -1, 127, -128, 32767, -32768, 8388607, -8388608, 2147483647, -2147483648 };
		int newValue;
		for (int i = 0; i < intValues.length; i++) {
			byte[] ba = IntegerUtil.toByteArray(intValues[i]);
			newValue = IntegerUtil.toInt(ba);
			System.out.println(newValue);
			Assert.assertEquals(newValue, intValues[i]);
		}
	}

	@Test
	public void testBigInteger() {
		String[] intValues = new String[] { "0", "1", "-1", "127", "-128", "32767", "-32768", "8388607", "-8388608",
				"2147483647", "-2147483648", "21474836475", "-21474836475" };
		BigInteger bValue;
		for (int i = 0; i < intValues.length; i++) {
			bValue = BigIntegerUtil.fromString(intValues[i]);
			byte[] ba = bValue.toByteArray();
			System.out.println("\n长度＝"+bValue.toByteArray().length + ":");
			for (byte b : ba) {
				System.out.print(b + "\t");
			}
			System.out.println("\n值：");
			System.out.println(bValue.toString());
		}
	}
}
