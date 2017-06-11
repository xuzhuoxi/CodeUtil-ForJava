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

	private BooleanUtil() {
	}
}
