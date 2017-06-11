package code.lang;

public class IntegerUtil {

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

	private IntegerUtil() {
	}
}
