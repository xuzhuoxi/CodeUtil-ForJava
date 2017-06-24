package code.date;

public class DateFormats {

	/**
	 * 格式：1971-01-02
	 */
	public static final String yyyyMMdd = "yyyy-MM-dd";
	/**
	 * 格式：71-01-02
	 */
	public static final String yyMMdd = "yy-MM-dd";
	/**
	 * 格式：23:05:02
	 */
	public static final String HHmmss = "HH:mm:ss";
	/**
	 * 格式：71-01-02 23:05:02
	 */
	public static final String yyMMddHHmmss = "yy-MM-dd HH:mm:ss";
	/**
	 * 格式：1971-01-02 23:05:02
	 */
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 格式：2001.07.04 AD at 12:08:56 PDT
	 */
	public static final String EEEdMMMyyyHHmmss = "EEE, d MMM yyyy HH:mm:ss ";
	/**
	 * 格式：2001.July.04 AD 12:08 PM
	 */
	public static final String yyyyMMddHHmmssaaa = "yyyy.MMMMM.dd GGG hh:mm aaa";
	/**
	 * 格式：0:08 PM, PDT
	 */
	public static final String Kmmaz = "K:mm a, z";
	/**
	 * 格式：12 o'clock PM, Pacific Daylight Time
	 */
	public static final String hhazzzz = "hh 'o''clock' a, zzzz";
	/**
	 * 格式：12:08 PM 或 10:08 AM
	 */
	public static final String hmma = "h:mm a";
	/**
	 * 格式：Wed, Jul 4, '01
	 */
	public static final String EEEMMMdyy = "EEE, MMM d, ''yy";

	private DateFormats() {
	}
}
