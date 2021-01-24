package code.lang;

public class BooleanUtil {

    /**
     * 字符串转Boolean数量
     * 1.数字表示的字符串， 字面意思不等于0则为true
     * 2."true", "false" 对应转为true,false，不区分大小写.
     *
     * @param stringValue
     * @return
     */
    public static final boolean fromString(String stringValue) {
        int iValue = NumberUtil.shortFromString(stringValue);
        if (0 != iValue) return true;
        return Boolean.parseBoolean(stringValue);
    }

    public static final boolean fromInteger(int value) {
        return value != 0;
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
