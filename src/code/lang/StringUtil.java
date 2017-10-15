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

	public static String changeCharset(String str, String fromCharsetName, String toCharsetName) {
		Charset fromCharset = Charset.forName(fromCharsetName);
		Charset toCharset = Charset.forName(toCharsetName);
		return changeCharset(str, fromCharset, toCharset);
	}

	public static String changeCharset(String str, String fromCharsetName, Charset toCharset) {
		Charset fromCharset = Charset.forName(fromCharsetName);
		return changeCharset(str, fromCharset, toCharset);
	}

	public static String changeCharset(String str, Charset fromCharset, String toCharsetName) {
		Charset toCharset = Charset.forName(toCharsetName);
		return changeCharset(str, fromCharset, toCharset);
	}

	public static String changeCharset(String str, Charset fromCharset, Charset toCharset) {
		String rs = new String(str.getBytes(fromCharset), toCharset);
		return rs;
	}

	private StringUtil() {
	}
}
