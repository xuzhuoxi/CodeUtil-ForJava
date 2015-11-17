package code.string;

import org.junit.Test;

public class StringCombinationTest2 {

	private static final String source0 = "ABCDEFGHIJKLMMOPQQ";
	private static final String source1 = "ABCDEFGHIJKK";
	private static final String source2 = "ABCC";

	private static String[] src0;
	private static String[] src1;
	private static String[] src2;

	public StringCombinationTest2() {
		src0 = source0.split("");
		src1 = source1.split("");
		src2 = source2.split("");
	}

	@Test
	public void test0_1() {
		String[] source = src0;
		int dimesion = 1;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test1_1() {
		String[] source = src1;
		int dimesion = 1;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test2_1() {
		String[] source = src2;
		int dimesion = 1;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test0_2() {
		String[] source = src0;
		int dimesion = 2;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test1_2() {
		String[] source = src1;
		int dimesion = 2;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test2_2() {
		String[] source = src2;
		int dimesion = 2;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test0_4() {
		String[] source = src0;
		int dimesion = 4;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test1_4() {
		String[] source = src1;
		int dimesion = 4;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test2_4() {
		String[] source = src2;
		int dimesion = 4;
		comsoleTest(source, dimesion);
	}

	@Test
	public void test() {
		String[] source = src0;
		int dimesion = 4;
		System.out.print("Start: (" + toString(source) + ")(" + dimesion + ")");
		this.comsole(
				StringCombination.dimensionalityReduction(StringCombination.getTwoDimensionArray(source, dimesion)));
		this.comsole(StringCombination
				.dimensionalityReduction(StringCombination.getTwoDimensionArray(source, dimesion, true)));
		System.out.println("End————————————————————————－\n");
	}

	@Test
	public void test2() {
		String[] source = src0;
		int dimesion = 5;
		System.out.print("Start: (" + toString(source) + ")(" + dimesion + ")");
		this.comsole(StringCombination.getDimensionCombinationArray(source, dimesion, false));
		this.comsole(StringCombination.getDimensionCombinationArray(source, dimesion, true));
		System.out.println("End————————————————————————－\n");
	}

	private void comsoleTest(String[] source, int dimesion) {
		System.out.print("Start: (" + toString(source) + ")(" + dimesion + ")");
		this.comsole(StringCombination.getTwoDimensionArray(source, dimesion));
		this.comsole(StringCombination.getTwoDimensionArray(source, dimesion, true));
		System.out.println("\n…………………………………………");
		this.comsole(StringCombination.getDimensionCombinationArray(source, dimesion, false));
		this.comsole(StringCombination.getDimensionCombinationArray(source, dimesion, true));
		System.out.println("End————————————————————————－\n");
	}

	private void comsole(String[] arr) {
		System.out.println("\nStringCombinationTest.comsole():");
		System.out.print("(" + arr.length + ")");
		for (String str : arr) {
			System.out.print(" " + str);
		}
		System.out.println("\n");
	}

	private void comsole(String[][] arr) {
		System.out.println("\nStringCombinationTest.comsole():");
		for (String[] arr2 : arr) {
			System.out.print("(" + arr2.length + ")");
			for (String str : arr2) {
				System.out.print(" " + str);
			}
			System.out.println();
		}
	}

	private String toString(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
