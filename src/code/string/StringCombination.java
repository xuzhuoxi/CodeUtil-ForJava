package code.string;

import java.util.ArrayList;
import java.util.List;

import code.array.ArrayUtils;
import code.math.MathUtils;

public class StringCombination {
	/**
	 * 使用字符串数组进行组合<br>
	 * 组合过程是按顺序的，即不会出现source[1]+source[0]这重情况<br>
	 * 并去除重复得到的字符串<br>
	 * 
	 * @param source
	 *            字符串数组
	 * @param dimenstion
	 *            维度，指组合最多使用的字符串数<br>
	 * @return 二维数组，第一个数组为只有1个source元素的字符串数组，第二个为2个source元素，如止类推<br>
	 */
	public static final String[][] getTwoDimensionArray(String[] source, int dimenstion) {
		return dimenstion(source, dimenstion, false);
	}

	/**
	 * 使用字符串数组进行组合<br>
	 * 组合过程是按顺序的，即不会出现source[1]+source[0]这重情况<br>
	 * 
	 * @param source
	 *            字符串数据源
	 * @param dimenstion
	 *            维度，指组合最多使用的字符串数
	 * @param repeat
	 *            是否允许重复
	 * @return 二维数组，第一个数组为只有1个source元素的字符串数组，第二个为2个source元素，如止类推<br>
	 */
	public static final String[][] getTwoDimensionArray(String[] source, int dimenstion, boolean repeat) {
		return dimenstion(source, dimenstion, repeat);
	}

	/**
	 * 把二维字符串数组降为一维字符串数组
	 * 
	 * @param arrTwo
	 *            二维字符串数组
	 * @return 一维字符串数组
	 */
	public static final String[] dimensionalityReduction(String[][] arrTwo) {
		return ArrayUtils.dimensionalityReduction(arrTwo);
	}

	/**
	 * 使用字符串数组进行组合<br>
	 * 组合过程是按顺序的，即不会出现source[1]+source[0]这重情况<br>
	 * 为提高效率，区分了dimenstion=1,dimenstion=2,dimenstion>2三种情况进行处理
	 * 
	 * @param source
	 *            字符串数据源
	 * @param dimenstion
	 *            维度，指组合最多使用的字符串数
	 * @param repeat
	 *            是否允许重复
	 * @return 二维数组，第一个数组为只有1个source元素的字符串数组，第二个为2个source元素，如止类推<br>
	 */
	private static final String[][] dimenstion(String[] source, int dimenstion, boolean repeat) {
		if (dimenstion < 1) {
			throw new Error("Dimenstion should be greater than 0.");
		}
		if (1 == dimenstion) {
			return dimenstionOne(source, repeat);
		} else if (2 == dimenstion) {
			return dimenstionTwo(source, repeat);
		} else {
			return dimenstionMutli(source, dimenstion, repeat);
		}
	}

	private static final String[][] dimenstionOne(String[] source, boolean repeat) {
		if (repeat) {
			return new String[][] { source.clone() };
		} else {
			return new String[][] { ArrayUtils.cleanRepeat2List(source) };
		}
	}

	private static final String[][] dimenstionTwo(String[] source, boolean repeat) {
		String[][] rs = new String[2][];
		String[] dOneArr = dimenstionOne(source, true)[0];
		rs[0] = dOneArr;

		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < dOneArr.length - 1; i++) {
			for (int j = i + 1; j < dOneArr.length; j++) {
				temp.add(dOneArr[i] + dOneArr[j]);
			}
		}
		String[] dTwoArr = new String[temp.size()];
		dTwoArr = temp.toArray(dTwoArr);
		rs[1] = dTwoArr;
		if (!repeat) {
			for (int i = 0; i < 2; i++) {
				rs[i] = ArrayUtils.cleanRepeat2List(rs[i]);
			}
		}
		return rs;
	}

	private static final String[][] dimenstionMutli(String[] source, int dimenstion, boolean repeat) {
		final int max = Math.min(source.length, dimenstion);
		String[][] newarr = new String[max][];
		for (int n = 1; n <= max; n++) {
			newarr[n - 1] = getCombination(source, n);
			if (!repeat) {
				newarr[n - 1] = ArrayUtils.cleanRepeat2List(newarr[n - 1]);
			}
		}
		return newarr;
	}

	/**
	 * 从一个一维数组中取得n个元素所构成的组合,并且基于源数组的顺序
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static final String[] getCombination(String[] arr, int n) {
		// 这里还要检测n必须不超过arr.length,这里就省略了
		// 这里采取类似选择排序的for循环方式
		// 这里还要采用递归的算法getCombination(n,arr)要利用getCombination(n-1,arr);n>=2;
		String[] newarr = new String[MathUtils.getCombinationCount(arr.length, n)];
		int count = 0;
		if (n == 1) {
			for (int i = 0; i < arr.length; i++) {
				newarr[i] = arr[i];
			}
		}
		if (n >= 2) {
			for (int j = 0; j < arr.length - 1; j++) {
				String currentValue = arr[j];
				int lensub = ArrayUtils.subArray(arr, j + 1).length;
				int lengetCombinationsub = getCombination(ArrayUtils.subArray(arr, j + 1), n - 1).length;
				for (int k = 0; k < lengetCombinationsub; k++) {
					// 这里容易出现一个错误，getCombination(subArray(arr,j+1),n-1)的长度问题
					if (lensub >= n - 1) {
						newarr[count] = currentValue + getCombination(ArrayUtils.subArray(arr, j + 1), n - 1)[k];
					}
					count++;
				}
			} // for 1
		}
		return newarr;
	}
}
