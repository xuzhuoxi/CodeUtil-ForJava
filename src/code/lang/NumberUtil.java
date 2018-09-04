package code.lang;

public class NumberUtil {
	private static NumberConverter converter = NumberConverter.instanceBigEndian();

	// short-----------------------------
	/**
	 * 字符串 转 short
	 * 
	 * @param value
	 *            字符串
	 * @return 整数值
	 */
	public static final short shortFromString(String value) {
		return converter.shortFromString(value);
	}

	/**
	 * byte 数组转 short
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static short toShort(byte[] values) {
		return converter.toShort(values);
	}

	/**
	 * short 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(short value) {
		return converter.toByteArray(value);
	}

	// int-----------------------------
	/**
	 * 字符串 转 int
	 * 
	 * @param value
	 *            字符串
	 * @return 整数值
	 */
	public static final int intFromString(String value) {
		return converter.intFromString(value);
	}

	/**
	 * byte 数组转 int
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static int toInteger(byte[] values) {
		return converter.toInteger(values);
	}

	/**
	 * int 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(int value) {
		return converter.toByteArray(value);
	}

	/**
	 * int 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @param byteCount
	 *            输出位数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(int value, int byteCount) {
		return converter.toByteArray(value, byteCount);
	}

	// long-----------------------------
	/**
	 * 字符串 转 long
	 * 
	 * @param value
	 *            字符串
	 * @return 整数值
	 */
	public static final long longFromString(String value) {
		return converter.longFromString(value);
	}

	/**
	 * byte 数组转 long
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static long toLong(byte[] values) {
		return converter.toLong(values);
	}

	/**
	 * long 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @param byteCount
	 *            输出位数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(long value, int byteCount) {
		return converter.toByteArray(value, byteCount);
	}

	/**
	 * long 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(long value) {
		return converter.toByteArray(value);
	}

	// float-----------------------------
	/**
	 * 字符串 转 float
	 * 
	 * @param value
	 *            字符串
	 * @return 浮点数
	 */
	public static final float floatFromString(String value) {
		return converter.floatFromString(value);
	}

	/**
	 * byte 数组转 float
	 * 
	 * @param values
	 *            由字节数组表示的整数
	 * @return 浮点数
	 */
	public static float toFloat(byte[] values) {
		return converter.toFloat(values);
	}

	/**
	 * float 转 byte数组
	 * 
	 * @param value
	 *            浮点数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(float value) {
		return converter.toByteArray(value);
	}

	// double-----------------------------
	/**
	 * 字符串 转 double
	 * 
	 * @param value
	 *            字符串
	 * @return 浮点数
	 */
	public static final Double doubleFromString(String value) {
		return converter.doubleFromString(value);
	}

	/**
	 * byte 数组转 double
	 * 
	 * @param values
	 *            由字节数组表示的整数
	 * @return 浮点数
	 */
	public static double toDouble(byte[] values) {
		return converter.toDouble(values);
	}

	/**
	 * double 转 byte数组
	 * 
	 * @param value
	 *            浮点数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(double value) {
		return converter.toByteArray(value);
	}
}
