package code.lang;

import java.math.BigInteger;

import org.junit.Test;

public class BigNumberUtilTest {

	@Test
	public void testBigInteger() {
		String[] intValues = new String[] { "0", "1", "-1", "127", "-128", "32767", "-32768", "8388607", "-8388608",
				"2147483647", "-2147483648", "21474836475", "-21474836475" };
		BigInteger bValue;
		for (int i = 0; i < intValues.length; i++) {
			bValue = BigNumberUtil.integerFromString(intValues[i]);
			byte[] ba = bValue.toByteArray();
			System.out.println("\n长度＝" + bValue.toByteArray().length + ":");
			for (byte b : ba) {
				System.out.print(b + "\t");
			}
			System.out.println("\n值：");
			System.out.println(bValue.toString());
		}
	}
}
