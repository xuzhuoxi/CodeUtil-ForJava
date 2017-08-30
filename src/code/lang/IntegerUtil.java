package code.lang;

public class IntegerUtil {

	/**
	 * 字符串 转 Integer
	 * 
	 * @param value
	 *            字符串
	 * @return 整数值
	 */
	public static final Integer fromString(String value) {
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
	 *            由字节数组表示的整数
	 * @return 整数值
	 */
	public static int toInt(byte[] values) {
		int len = values.length;
		switch (len) {
		case 1:
			return values[0] & 0xFF;
		case 2:
			return values[1] & 0xFF | (values[0] & 0xFF) << 8;
		case 3:
			return values[2] & 0xFF | (values[1] & 0xFF) << 8 | (values[0] & 0xFF) << 16;
		case 4:
			return values[3] & 0xFF | (values[2] & 0xFF) << 8 | (values[1] & 0xFF) << 16 | (values[0] & 0xFF) << 24;
		default:
			if (len < 1) {
				throw new Error("IntegerUtil.byteArrayToInt");
			} else {
				return values[len - 1] & 0xFF | (values[len - 2] & 0xFF) << 8 | (values[len - 3] & 0xFF) << 16
						| (values[len - 4] & 0xFF) << 24;
			}
		}
	}

	/**
	 * int 转为 byte数组,
	 * 
	 * @param value
	 *            int值
	 * @param byteCount
	 *            byte数组长度
	 * @return 字节数组
	 */
	public static byte[] toByteArray(int value, int byteCount) {
		switch (byteCount) {
		case 1:
			return new byte[] { (byte) (value & 0xFF) };
		case 2:
			return new byte[] { (byte) ((value >> 8) & 0xFF), (byte) (value & 0xFF) };
		case 3:
			return new byte[] { (byte) ((value >> 16) & 0xFF), (byte) ((value >> 8) & 0xFF), (byte) (value & 0xFF) };
		case 4:
			return new byte[] { (byte) ((value >> 24) & 0xFF), (byte) ((value >> 16) & 0xFF),
					(byte) ((value >> 8) & 0xFF), (byte) (value & 0xFF) };
		default:
			if (byteCount < 1) {
				throw new Error("IntegerUtil.intToByteArray");
			} else {
				byte[] rs = new byte[byteCount];
				byte[] b4 = toByteArray(value, 4);
				int i = 0;
				for (i = 0; i < byteCount - 4; i++) {
					rs[i] = 0;
				}
				for (int j = 0; j < 4; j++, i++) {
					rs[i] = b4[j];
				}
				return rs;
			}
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
		return toByteArray(value, 4);
	}

	private IntegerUtil() {
	}
}
