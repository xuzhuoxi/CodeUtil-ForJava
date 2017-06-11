package code.lang;

import org.junit.Test;

public class TestBooleanUtil {

	@Test
	public void testBooleanObject() {
		Boolean b0 = BooleanUtil.fromString("True");
		Boolean b1 = BooleanUtil.fromString("true");
		Boolean b2 = BooleanUtil.fromString("False");
		Boolean b3 = BooleanUtil.fromString("false");
		Boolean b4 = BooleanUtil.fromString("0");
		Boolean b5 = BooleanUtil.fromString("1");
		Boolean b6 = BooleanUtil.fromString("112");
		Boolean b7 = BooleanUtil.fromString("-112");
		System.out.println(b0);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b7);
	}
}
