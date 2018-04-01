package code.lang;

import java.text.DecimalFormat;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void testOverflow(){
		System.out.println(Integer.MAX_VALUE);
		String uintMax = "4294967295";
		int i = NumberUtil.intFromString(uintMax);
		System.out.println(i);
		long i2 = Long.parseLong(uintMax);
		System.out.println(i2);
		System.out.println((int)(i2-10));
	}
	
	@Test
	public void testShort() {
		short i = 99;
		byte[] ba = NumberUtil.toByteArray(i);
		int i2 = NumberUtil.toShort(ba);
		int i3 = NumberIOUtil.readShort(ba);
		System.out.println(i + "," + new DecimalFormat("0000").format(i) + "|" + i2 + ","
				+ new DecimalFormat("0000").format(i2) + "|" + i3 + "," + new DecimalFormat("0000").format(i3));
		String str = "";
		for (byte b : ba) {
			str = str + " " + b;
		}
		System.out.println(str);
	}

	@Test
	public void testMultiShort() {
		short[] intValues = new short[] { 0, 1, -1, 127, -128, 32767, -32768 };
		short newValue;
		for (int i = 0; i < intValues.length; i++) {
			byte[] ba = NumberUtil.toByteArray(intValues[i]);
			newValue = NumberUtil.toShort(ba);
			System.out.println(newValue);
			Assert.assertEquals(newValue, intValues[i]);
		}
	}

	@Test
	public void testInteger() {
		int i = 127;
		byte[] ba = NumberUtil.toByteArray(i);
		int i2 = NumberUtil.toInteger(ba);
		System.out.println(
				i + "," + new DecimalFormat("0000").format(i) + "|" + i2 + "," + new DecimalFormat("0000").format(i2));
		String str = "";
		for (byte b : ba) {
			str = str + " " + b;
		}
		System.out.println(str);
	}

	@Test
	public void testMultiInteger() {
		int[] intValues = new int[] { 0, 1, -1, 127, -128, 32767, -32768, 8388607, -8388608, 2147483647, -2147483648 };
		int newValue;
		for (int i = 0; i < intValues.length; i++) {
			byte[] ba = NumberUtil.toByteArray(intValues[i]);
			newValue = NumberUtil.toInteger(ba);
			System.out.println(newValue);
			Assert.assertEquals(newValue, intValues[i]);
		}
	}

	@Test
	public void testLong() {
		long i = 1999999;
		byte[] ba = NumberUtil.toByteArray(i);
		long i2 = NumberUtil.toLong(ba);
		System.out.println(
				i + "," + new DecimalFormat("0000").format(i) + "|" + i2 + "," + new DecimalFormat("0000").format(i2));
		String str = "";
		for (byte b : ba) {
			str = str + " " + b;
		}
		System.out.println(str);
	}

	@Test
	public void testMultiLong() {
		long[] values = new long[] { 0, 1, -1, 127, -128, 32767, -32768, 8388607, -8388608, 2147483647, -2147483648 };
		long newValue;
		for (int i = 0; i < values.length; i++) {
			byte[] ba = NumberUtil.toByteArray(values[i]);
			newValue = NumberUtil.toLong(ba);
			System.out.println(newValue + " " + values[i] + " baLen:" + ba.length);
			Assert.assertEquals(newValue, values[i]);
		}
	}

	@Test
	public void testFloat() {
		float i = 128;
		byte[] ba = NumberUtil.toByteArray(i);
		float i2 = NumberUtil.toFloat(ba);

		System.out.println(
				i + "," + new DecimalFormat("0000").format(i) + "|" + i2 + "," + new DecimalFormat("0000").format(i2));
		String str = "";
		for (byte b : ba) {
			str = str + " " + b;
		}
		System.out.println(str);
	}

	@Test
	public void testMultiFloat() {
		float[] intValues = new float[] { 0, 1, -1, 127, -128, 32767, -32768, 8388607, -8388608, 2147483647,
				-2147483648 };
		float newValue;
		for (int i = 0; i < intValues.length; i++) {
			byte[] ba = NumberUtil.toByteArray(intValues[i]);
			newValue = NumberUtil.toFloat(ba);
			System.out.println(newValue);
			Assert.assertEquals(newValue, intValues[i], 3);
		}
	}

	@Test
	public void testDouble() {
		double i = 128;
		byte[] ba = NumberUtil.toByteArray(i);
		double i2 = NumberUtil.toDouble(ba);

		System.out.println(
				i + "," + new DecimalFormat("0000").format(i) + "|" + i2 + "," + new DecimalFormat("0000").format(i2));
		String str = "";
		for (byte b : ba) {
			str = str + " " + b;
		}
		System.out.println(str);
	}

	@Test
	public void testMultiDouble() {
		double[] intValues = new double[] { 0, 1, -1, 127, -128, 32767, -32768, 8388607, -8388608, 2147483647,
				-2147483648 };
		double newValue;
		for (int i = 0; i < intValues.length; i++) {
			byte[] ba = NumberUtil.toByteArray(intValues[i]);
			newValue = NumberUtil.toDouble(ba);
			System.out.println(newValue);
			Assert.assertEquals(newValue, intValues[i], 3);
		}
	}
}
