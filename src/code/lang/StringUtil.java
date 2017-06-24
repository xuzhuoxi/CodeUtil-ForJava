package code.lang;

import java.nio.charset.Charset;

public class StringUtil {

	public static String fromByteArray(byte[] values) {
		return new String(values).toString();
	}

	public static String fromByteArray(byte[] values, Charset charset) {
		return new String(values, charset).toString();
	}

	public static String fromByteArray(byte[] values, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return new String(values, charset).toString();
	}

	public static byte[] toByteArray(String value) {
		return value.getBytes();
	}

	public static byte[] toByteArray(String value, Charset charset) {
		return value.getBytes(charset);
	}

	public static byte[] toByteArray(String value, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return value.getBytes(charset);
	}

	private StringUtil() {
	}
}
