package code.lang;

public class ByteArrayUtil {
//	/**
//	 * 转换char为byte[]
//	 * 
//	 * @param bAry
//	 *            待写入的byte[]， 长度至少为1
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, char num, int startIndex) {
//		int temp = (int) num;
//		// byte[] b = new byte[2];
//		for (int i = 0; i < 2; i++) {
//			// 将最高位保存在最低位
//			result[startIndex + i] = new Integer(temp & 0xff).byteValue();
//			temp = temp >> 8; // 向右移8位
//		}
//	}
//
//	/**
//	 * 转换short为byte[]
//	 * 
//	 * @param result
//	 *            待写入的byte[]， 长度至少为2
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, short num, int startIndex) {
//		result[startIndex + 1] = (byte) (num >>> 8);
//		result[startIndex + 0] = (byte) (num);
//	}
//
//	/**
//	 * 转换int为byte[]
//	 * 
//	 * @param result
//	 *            待写入的byte[]， 长度至少为4
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, int num, int startIndex) {
//		result[startIndex + 0] = (byte) (num >>> 24);// 取最高8位放到0下标
//		result[startIndex + 1] = (byte) (num >>> 16);// 取次高8为放到1下标
//		result[startIndex + 2] = (byte) (num >>> 8); // 取次低8位放到2下标
//		result[startIndex + 3] = (byte) (num); // 取最低8位放到3下标
//	}
//
//	/**
//	 * 转换long为byte[]
//	 * 
//	 * @param result
//	 *            待写入的byte[]， 长度至少为8
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, long num, int startIndex) {
//		result[startIndex + 0] = (byte) (num >>> 56);// 取最高8位放到0下标
//		result[startIndex + 1] = (byte) (num >>> 48);// 取最高8位放到0下标
//		result[startIndex + 2] = (byte) (num >>> 40);// 取最高8位放到0下标
//		result[startIndex + 3] = (byte) (num >>> 32);// 取最高8位放到0下标
//		result[startIndex + 4] = (byte) (num >>> 24);// 取最高8位放到0下标
//		result[startIndex + 5] = (byte) (num >>> 16);// 取次高8为放到1下标
//		result[startIndex + 6] = (byte) (num >>> 8); // 取次低8位放到2下标
//		result[startIndex + 7] = (byte) (num); // 取最低8位放到3下标
//	}
//
//	/**
//	 * 转换float为byte[]
//	 * 
//	 * @param result
//	 *            待写入的byte[]， 长度至少为4
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, float num, int startIndex) {
//		int val = Float.floatToIntBits(num);
//		for (int i = 0; i < 4; i++) {
//			result[startIndex + i] = new Integer(val).byteValue();
//			val = val >> 8;
//		}
//	}
//
//	/**
//	 * 转换double为byte[]
//	 * 
//	 * @param result
//	 *            待写入的byte[]， 长度至少为8
//	 * @param num
//	 * @param startIndex
//	 */
//	public static void toByteArray(byte[] result, double num, int startIndex) {
//		long l = Double.doubleToLongBits(num);
//		for (int i = 0; i < 8; i++) {
//			result[startIndex + i] = new Long(l).byteValue();
//			l = l >> 8;
//		}
//	}
//
//	/**
//	 * 字节到字符转换
//	 * 
//	 * @param byteAry
//	 * @param startIndex
//	 * @return
//	 */
//	public static char toChar(byte[] byteAry, int startIndex) {
//		int s = 0;
//		if (byteAry[startIndex + 1] > 0)
//			s += byteAry[startIndex + 1];
//		else
//			s += 256 + byteAry[startIndex + 0];
//		s *= 256;
//		if (byteAry[startIndex + 0] > 0)
//			s += byteAry[startIndex + 1];
//		else
//			s += 256 + byteAry[startIndex + 0];
//		char ch = (char) s;
//		return ch;
//	}
//
//	/**
//	 * 通过byte数组取到short
//	 * 
//	 * @param byteAry
//	 * @param startIndex
//	 * @return
//	 */
//	public static short toShort(byte[] byteAry, int startIndex) {
//		return (short) (((byteAry[startIndex + 1] << 8) | byteAry[startIndex + 0] & 0xff));
//	}
//
//	/**
//	 * 将4字节的byte数组转成一个int值
//	 * 
//	 * @param byteAry
//	 * @return 转换后的int型数值
//	 */
//	public static int toInteger(byte[] byteAry) {
//		byte[] a = new byte[4];
//		int i = a.length - 1, j = byteAry.length - 1;
//		for (; i >= 0; i--, j--) {// 从b的尾部(即int值的低位)开始copy数据
//			if (j >= 0)
//				a[i] = byteAry[j];
//			else
//				a[i] = 0;// 如果byteAry.length不足4,则将高位补0
//		}
//		int v0 = (a[0] & 0xff) << 24;// &0xff将byte值无差异转成int,避免Java自动类型提升后,会保留高位的符号位
//		int v1 = (a[1] & 0xff) << 16;
//		int v2 = (a[2] & 0xff) << 8;
//		int v3 = (a[3] & 0xff);
//		return v0 + v1 + v2 + v3;
//	}
//
//	/**
//	 * 将8字节的byte数组转成一个long值
//	 * 
//	 * @param byteAry
//	 * @return 转换后的long型数值
//	 */
//	public static long toLong(byte[] byteAry) {
//		byte[] a = new byte[8];
//		int i = a.length - 1, j = byteAry.length - 1;
//		for (; i >= 0; i--, j--) {// 从b的尾部(即int值的低位)开始copy数据
//			if (j >= 0)
//				a[i] = byteAry[j];
//			else
//				a[i] = 0;// 如果byteAry.length不足4,则将高位补0
//		}
//		// 注意此处和byte数组转换成int的区别在于，下面的转换中要将先将数组中的元素转换成long型再做移位操作，
//		// 若直接做位移操作将得不到正确结果，因为Java默认操作数字时，若不加声明会将数字作为int型来对待，此处必须注意。
//		long v0 = (long) (a[0] & 0xff) << 56;// &0xff将byte值无差异转成int,避免Java自动类型提升后,会保留高位的符号位
//		long v1 = (long) (a[1] & 0xff) << 48;
//		long v2 = (long) (a[2] & 0xff) << 40;
//		long v3 = (long) (a[3] & 0xff) << 32;
//		long v4 = (long) (a[4] & 0xff) << 24;
//		long v5 = (long) (a[5] & 0xff) << 16;
//		long v6 = (long) (a[6] & 0xff) << 8;
//		long v7 = (long) (a[7] & 0xff);
//		return v0 + v1 + v2 + v3 + v4 + v5 + v6 + v7;
//	}
//
//	/**
//	 * 
//	 * 通过byte数组取得double
//	 * 
//	 * @param b
//	 *            byte数组,长度至少为index+4
//	 * @param index
//	 * @return
//	 */
//	public static float toFloat(byte[] b, int index) {
//		int l;
//		l = b[index + 0];
//		l &= 0xff;
//		l |= ((long) b[index + 1] << 8);
//		l &= 0xffff;
//		l |= ((long) b[index + 2] << 16);
//		l &= 0xffffff;
//		l |= ((long) b[index + 3] << 24);
//		return Float.intBitsToFloat(l);
//	}
//
//	/**
//	 * 通过byte数组取得double
//	 * 
//	 * @param b
//	 *            byte数组,长度至少为index+8
//	 * @param index
//	 * @return
//	 */
//	public static double toDouble(byte[] b, int index) {
//		long l;
//		l = b[index + 0];
//		l &= 0xff;
//		l |= ((long) b[index + 1] << 8);
//		l &= 0xffff;
//		l |= ((long) b[index + 2] << 16);
//		l &= 0xffffff;
//		l |= ((long) b[index + 3] << 24);
//		l &= 0xffffffffl;
//		l |= ((long) b[index + 4] << 32);
//		l &= 0xffffffffffl;
//		l |= ((long) b[index + 5] << 40);
//		l &= 0xffffffffffffl;
//		l |= ((long) b[index + 6] << 48);
//		l &= 0xffffffffffffffl;
//		l |= ((long) b[index + 7] << 56);
//		return Double.longBitsToDouble(l);
//	}

}
