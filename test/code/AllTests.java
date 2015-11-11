package code;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import code.array.ArrayUtilsTest;
import code.chinese.ChineseUtilsTest;
import code.math.MathUtilsTest;
import code.regexp.RegexpUtilsTest;
import code.string.StringCombinationTest;
import code.string.StringCombinationTest2;
import code.string.StringMatchingTest;
import code.string.StringUtilsTest;

@RunWith(Suite.class)
@SuiteClasses({ ArrayUtilsTest.class, ChineseUtilsTest.class, MathUtilsTest.class, RegexpUtilsTest.class,
		StringCombinationTest.class, StringCombinationTest2.class, StringMatchingTest.class, StringUtilsTest.class })
public class AllTests {
}
