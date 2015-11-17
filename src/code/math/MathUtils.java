package code.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 一些常用的数学方法
 * 
 * @author xuzhuoxi
 *
 */
public class MathUtils {
	/**
	 * 计算从个数为m的有序数组中取得n个元素所构成的组合的个数<br>
	 * 组合行为基于数组顺序
	 * 
	 * @param m
	 *            数据数量
	 * @param n
	 *            选择个数
	 * @return 组合个数
	 */
	public static final int getCombinationCount(int m, int n) {
		int getlen = 0;
		int fenzi = m;
		int fenmu = 1;
		for (int i = 1; i < n; i++) {
			int temp = m;
			fenzi = fenzi * (temp - i);
			int demp = 1;
			fenmu = fenmu * (demp + i);
		}
		getlen = fenzi / fenmu;
		return getlen;
	}

	/**
	 * 十进制转换不确定进制
	 * 
	 * @param value
	 *            十进制数值
	 * @param system
	 *            不确定进制数组
	 * @return 由十进制数据组成的数组
	 */
	public static final int[] tenToCustomSystem(int value, int[] system) {
		int[] rs = new int[system.length];
		int temp = value;
		for (int i = 0; i < system.length; i++) {
			rs[i] = temp % system[i];
			temp = temp / system[i];
		}
		return rs;
	}

	/**
	 * 从sourceLen个源数据中最多选择dimension个元素进行组合，组合过程基于源数据的顺序<br>
	 * 
	 * @param sourceLen
	 *            源数据个数
	 * @param dimension
	 *            最多可选择个数
	 * @return 全部组合的索引情况
	 */
	public static final Integer[][][] getDimensionCombinationIndex(int sourceLen, int dimension) {
		final int newDimension = Math.min(sourceLen, dimension);
		if (newDimension < 1) {
			throw new Error("SourceLen or dimension should be greater than 0.");
		}
		Integer[][][] rs = new Integer[newDimension][][];
		if (1 == newDimension) {
			rs[0] = new Integer[sourceLen][];
			for (int i = 0; i < sourceLen; i++) {
				rs[0][i] = new Integer[] { i };
			}
			return rs;
		}
		@SuppressWarnings("unchecked")
		List<Integer[]>[] temp = new ArrayList[newDimension];
		for (int i = 0; i < newDimension; i++) {
			temp[i] = new ArrayList<Integer[]>();
		}
		int len = 0;
		for (int i = 0; i < sourceLen; i++) {
			for (int j = newDimension - 2; j >= 0; j--) {
				if (temp[j].size() > 0) {
					for (Integer[] indexs : temp[j]) {
						len = indexs.length;
						Integer[] add = new Integer[len + 1];
						System.arraycopy(indexs, 0, add, 0, len);
						add[len] = i;
						temp[j + 1].add(add);
					}
				}
				if (0 == j) {
					temp[0].add(new Integer[] { i });
				}
			}
		}
		for (int i = 0; i < newDimension; i++) {
			Integer[][] arr = new Integer[temp[i].size()][];
			rs[i] = temp[i].toArray(arr);
			Arrays.sort(rs[i], intArrayComparable);
		}
		return rs;
	}

	private static final Comparator<Integer[]> intArrayComparable = new Comparator<Integer[]>() {
		@Override
		public int compare(Integer[] o1, Integer[] o2) {
			if (o1.length != o2.length) {
				return Integer.compare(o1.length, o2.length);
			} else {
				for (int i = 0; i < o1.length; i++) {
					if (!o1[i].equals(o2[i])) {
						return o1[i].compareTo(o2[i]);
					}
				}
				return 0;
			}
		}
	};
}
