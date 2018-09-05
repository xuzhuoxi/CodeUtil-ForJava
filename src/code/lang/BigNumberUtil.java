package code.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberUtil {

	public static final BigInteger integerFromString(String value) {
		return new BigInteger(value);
	}

	public static final BigInteger integerFromString(String value, int radix) {
		return new BigInteger(value, radix);
	}

	public static final BigDecimal decimalFromString(String value) {
		return new BigDecimal(value);
	}

	public static final BigInteger toInteger(byte[] values) {
		return new BigInteger(values);
	}

	public static final BigDecimal toDecimal(byte[] values) {
		return new BigDecimal(new BigInteger(values), 0);
	}

	public static final byte[] toByteArray(BigInteger value) {
		return value.toByteArray();
	}

	public static final byte[] toByteArray(BigDecimal value) {
		return value.unscaledValue().toByteArray();
	}

	public static final byte[] toByteArray(BigInteger value, int byteCount) {
		byte[] bs = value.toByteArray();
		byte[] rs = new byte[byteCount];
		int j = 0;
		for (int i = byteCount - 1; i >= 0; i--, j++) {
			if (j < bs.length) {
				rs[i] = bs[j];
			} else {
				rs[i] = 0;
			}
		}
		return rs;
	}

	private BigNumberUtil() {
		super();
	}
}
