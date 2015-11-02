package code.string;

import org.junit.Assert;
import org.junit.Test;

public class StringMatchingTest {

	private String source = "adfeff";
	private String expression = "aff";
	private boolean[] resultMatching = { true, false, true, false, true, false };

	private boolean[] resultCompute = { true, false, true, false, true };
	private double delta = 0.000000000001;

	@Test
	public void testMatching() {
		Assert.assertArrayEquals(resultMatching, StringMatching.matching(source, expression));
	}

	@Test
	public void testComputeMatchintResult() {
		Assert.assertEquals(1.3125, StringMatching.computeMatchintResult(resultCompute), delta);
	}

}
