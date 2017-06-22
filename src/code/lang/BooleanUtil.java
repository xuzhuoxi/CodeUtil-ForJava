package code.lang;

public class BooleanUtil {

	public static final boolean fromString(String stringValue) {
		int iValue = IntegerUtil.fromString(stringValue);
		if (iValue > 0) {
			return true;
		} else {
			return Boolean.parseBoolean(stringValue);
		}
	}

	public static final boolean fromInteger(int value) {
		return 0 == value ? false : true;
	}

	public static final byte toByte(boolean b) {
		return (byte) (b ? 0x01 : 0x00);
	}

	public static final int toInt(boolean b) {
		return b ? 1 : 0;
	}

	private BooleanUtil() {
	}
}
