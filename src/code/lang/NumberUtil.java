package code.lang;

import java.nio.ByteBuffer;

public class NumberUtil {
	private static ByteBuffer buffer2 = ByteBuffer.allocate(2);
	private static ByteBuffer buffer4 = ByteBuffer.allocate(4);
	private static ByteBuffer buffer8 = ByteBuffer.allocate(8);

	// short-----------------------------
	/**
	 * 字符串 转 short
	 * 
	 * @param value
	 *            字符串
	 * @return 整数值
	 */
	public static final short shortFromString(String value) {
		short iValue = 0;
		try {
			iValue = Short.parseShort(value);
		} catch (Exception e) {
			iValue = 0;
		} finally {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * byte 数组转 short
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static short toShort(byte[] values) {
		int len = values.length;
		if (len < 1) {
			throw new Error("NumberUtil.toShort");
		}
		if (len <= 2) {
			buffer2.clear();
			buffer2.put(values);
			buffer2.flip();
			return buffer2.getShort();
		} else {
			return Short.MAX_VALUE;
		}
	}

	/**
	 * short 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(short value) {
		buffer2.clear();
		buffer2.putShort(0, value);
		return buffer2.array().clone();
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
		int iValue = 0;
		try {
			iValue = Integer.parseInt(value);
		} catch (Exception e) {
			iValue = 0;
		} finally {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * byte 数组转 int
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static int toInteger(byte[] values) {
		int len = values.length;
		if (len < 1) {
			throw new Error("NumberUtil.toInteger");
		}
		if (len <= 4) {
			buffer4.clear();
			buffer4.put(values);
			buffer4.flip();
			return buffer4.getInt();
		} else {
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * int 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(int value) {
		buffer4.clear();
		buffer4.putInt(0, value);
		return buffer4.array().clone();
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
		switch (byteCount) {
		case 1:
			return new byte[] { (byte) value };
		case 2:
			return NumberUtil.toByteArray((short) value);
		case 4:
			return NumberUtil.toByteArray(value);
		default:
			throw new Error("byteCount value error: " + byteCount);
		}
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
		long iValue = 0;
		try {
			iValue = Long.parseLong(value);
		} catch (Exception e) {
			iValue = 0;
		} finally {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * byte 数组转 long
	 * 
	 * @param values
	 *            由字节数组表示的整数<br>
	 * @return 整数值
	 */
	public static long toLong(byte[] values) {
		int len = values.length;
		if (len < 1) {
			throw new Error("LongUtil.toLong");
		}
		if (len <= 8) {
			buffer8.clear();
			buffer8.put(values);
			buffer8.flip();
			return buffer8.getLong();
		} else {
			return Long.MAX_VALUE;
		}
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
		if (8 == byteCount) {
			return toByteArray(value);
		} else {
			return toByteArray((int) value, byteCount);// 溢出时，value会变为负数int
		}
	}

	/**
	 * long 转 byte数组
	 * 
	 * @param value
	 *            整数值
	 * @return 字节数组
	 */
	public static byte[] toByteArray(long value) {
		buffer8.clear();
		buffer8.putLong(0, value);
		return buffer8.array().clone();
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
		float iValue = 0;
		try {
			iValue = Float.parseFloat(value);
		} catch (Exception e) {
			iValue = 0;
		} finally {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * byte 数组转 float
	 * 
	 * @param values
	 *            由字节数组表示的整数
	 * @return 浮点数
	 */
	public static float toFloat(byte[] values) {
		if (null == values) {
			return 0;
		}
		int vLen = values.length;
		if (vLen < 4) {
			return 0;
		}
		if (vLen == 4) {
			buffer4.clear();
			buffer4.put(values);
			buffer4.flip();
			return buffer4.getFloat();
		} else {
			return Float.MAX_VALUE;
		}

	}

	/**
	 * float 转 byte数组
	 * 
	 * @param value
	 *            浮点数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(float value) {
		buffer4.clear();
		buffer4.putFloat(value);
		return buffer4.array().clone();
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
		double iValue = 0;
		try {
			iValue = Double.parseDouble(value);
		} catch (Exception e) {
			iValue = 0;
		} finally {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * byte 数组转 double
	 * 
	 * @param values
	 *            由字节数组表示的整数
	 * @return 浮点数
	 */
	public static double toDouble(byte[] values) {
		if (null == values) {
			return 0;
		}
		int vLen = values.length;
		if (vLen < 8) {
			return 0;
		}
		if (vLen == 8) {
			buffer8.clear();
			buffer8.put(values);
			buffer8.flip();
			return buffer8.getDouble();
			// 做法2：
			// long value = 0;
			// for (int i = 0; i < 8; i++) {
			// value |= ((long) (values[i] & 0xff)) << (8 * i);
			// }
			// return Double.longBitsToDouble(value);
			// 做法1：
			/*
			 * int l; l = values[0]; l &= 0xff; l |= ((long) values[1] << 8); l
			 * &= 0xffff; l |= ((long) values[2] << 16); l &= 0xffffff; l |=
			 * ((long) values[3] << 24); l &= 0xffffffff; l |= ((long) values[4]
			 * << 32); l &= 0xffffffffffl; l |= ((long) values[5] << 40); l &=
			 * 0xffffffffffffl; l |= ((long) values[6] << 48); l &=
			 * 0xffffffffffffffl; l |= ((long) values[7] << 56); return
			 * Double.longBitsToDouble(l);
			 */
		} else {
			return Double.MAX_VALUE;
		}

	}

	/**
	 * double 转 byte数组
	 * 
	 * @param value
	 *            浮点数
	 * @return 字节数组
	 */
	public static byte[] toByteArray(double value) {
		buffer8.clear();
		buffer8.putDouble(value);
		return buffer8.array().clone();
		// 做法2：
		// long d = Double.doubleToRawLongBits(value);
		// byte[] byteRet = new byte[8];
		// for (int i = 0; i < 8; i++) {
		// byteRet[i] = (byte) ((d >> 8 * i) & 0xff);
		// }
		// return byteRet;
		// 做法1：
		/*
		 * long lbit = Double.doubleToLongBits(value); byte[] b = new byte[8];
		 * for (int i = 0; i < 8; i++) { b[i] = (byte) (lbit >> (56 - i * 8)); }
		 * 
		 * // 翻转数组 int len = b.length; // 建立一个与源数组元素类型相同的数组 byte[] dest = new
		 * byte[len]; // 为了防止修改源数组，将源数组拷贝一份副本 System.arraycopy(b, 0, dest, 0,
		 * len); byte temp; // 将顺位第i个与倒数第i个交换 for (int i = 0; i < len / 2; ++i)
		 * { temp = dest[i]; dest[i] = dest[len - i - 1]; dest[len - i - 1] =
		 * temp; } return dest;
		 */
	}
}
