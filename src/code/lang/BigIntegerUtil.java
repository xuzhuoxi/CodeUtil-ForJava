package code.lang;

import java.math.BigInteger;

public class BigIntegerUtil {

	public static final BigInteger fromString(String value) {
		return new BigInteger(value);
	}

	public static final BigInteger fromString(String value, int radix) {
		return new BigInteger(value, radix);
	}

	public static final BigInteger toBigInteger(byte[] values) {
		return new BigInteger(values);
	}

	public static final byte[] toByteArray(BigInteger value) {
		return value.toByteArray();
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

	private BigIntegerUtil() {
		super();
	}
}
