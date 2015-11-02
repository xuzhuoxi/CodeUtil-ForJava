package code.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author xuzhuoxi
 *
 */
public class ArrayUtils {
	/**
	 * 不支持二维以上数组
	 * 
	 * @param ary
	 * @return
	 */
	public static final <T> T[] cleanRepeat2List(T[] ary) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < ary.length; i++) {
			if (!list.contains(ary[i])) {
				list.add(ary[i]);
			}
		}
		T[] rs = Arrays.copyOf(ary, list.size());
		for (int i = 0; i < rs.length; i++) {
			rs[i] = list.get(i);
		}
		return rs;
	}

	/**
	 * 不支持二维以上数组
	 * 
	 * @param arr0
	 * @param arr1
	 * @return
	 */
	public static final <T> boolean equals(T[] arr0, T[] arr1) {
		if (arr0 == arr1) {
			return true;
		} else {
			if (arr0.length != arr1.length) {
				return false;
			}
			for (int i = 0; i < arr0.length; i++) {
				if (!arr0[i].equals(arr1[i])) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * 移除数组中的某一位数据
	 * 
	 * @param data
	 *            源数据
	 * @param index
	 *            移除标志位
	 * @return
	 */
	public static final <T> T[] remove(T[] data, int index) {
		T[] temp = Arrays.copyOf(data, data.length - 1);
		System.arraycopy(data, index + 1, temp, index, temp.length - index);
		return temp;
	}

	/**
	 * 检查一个实例是否在数组中<br>
	 * 使用实例的equals方法进行判断是否相等<br>
	 * 
	 * @param array
	 * @param obj
	 * @return
	 */
	public static final <T> boolean isExist(T[] array, T obj) {
		T[] temp = array.clone();
		Arrays.sort(temp);
		return Arrays.binarySearch(temp, obj) >= 0;
	}

	/**
	 * 合并两个数组
	 * 
	 * @param base
	 * @param add
	 * @return
	 */
	public static final <T> T[] addAll(T[] base, T[] add) {
		if (null == base || null == add) {
			return null;
		}
		final int baseLen = null == base ? 0 : base.length;
		final int addLen = null == add ? 0 : add.length;
		T[] rs = Arrays.copyOf(base, baseLen + addLen);
		System.arraycopy(add, 0, rs, baseLen, addLen);
		return rs;
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到末尾
	 * 
	 * @param arr
	 * @param startIndex
	 * @return
	 */
	public static final <T> T[] subArray(T[] arr, int startIndex) {
		if (startIndex <= arr.length) {
			int len = arr.length;
			int newLen = len - startIndex;
			T[] newArr = Arrays.copyOf(arr, newLen);
			System.arraycopy(arr, startIndex, newArr, 0, newLen);
			return newArr;
		} else {
			return null;
		}
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到endIndex(不包括)位
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static final <T> T[] subArray(T[] arr, int startIndex, int endIndex) {
		int realEndIndex = endIndex <= arr.length ? endIndex : arr.length;
		int newLen = realEndIndex - startIndex;
		if (startIndex <= arr.length && newLen > 0) {
			T[] newArr = Arrays.copyOf(arr, newLen);
			System.arraycopy(arr, startIndex, newArr, 0, newLen);
			return newArr;
		} else {
			return null;
		}
	}

	/**
	 * 反向
	 * 
	 * @param arr
	 */
	public static final <T> void reverse(T[] arr) {
		T temp;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	/**
	 * 把二维数组降为一维数组
	 * 
	 * @param arrTwo
	 * @return
	 */
	public static final <T> T[] dimensionalityReduction(T[][] arrTwo) {
		int size = 0;
		for (T[] ary : arrTwo) {
			size += ary.length;
		}
		T[] rs = Arrays.copyOf(arrTwo[0], size);
		int i = 0;
		for (T[] ary : arrTwo) {
			for (T str : ary) {
				rs[i] = str;
				i++;
			}
		}
		return rs;
	}

}
