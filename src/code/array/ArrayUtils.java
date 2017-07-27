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
	private ArrayUtils() {
	}

	/**
	 * 不支持二维以上数组
	 * 
	 * @param ary
	 *            输入数组
	 * @return 新的数组
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
	 *            对象数组
	 * @param arr1
	 *            对象数组
	 * @return 如果两个数组长度相等且每个数组对象依次相等，则返回true<br>
	 *         否则返回false<br>
	 *         相等指的是equals方法调用为true<br>
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
	 * @return 新的数组
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
	 *            数组
	 * @param obj
	 *            对象
	 * @return 如果数组只有一个对象与obj相等，则返回true<br>
	 * @see Object#equals(Object)
	 */
	public static final <T> boolean isExist(T[] array, T obj) {
		T[] temp = array.clone();
		Arrays.sort(temp);
		return Arrays.binarySearch(temp, obj) >= 0;
	}

	/**
	 * 合并两个数组
	 * 
	 * @param arr0
	 *            数组1
	 * @param arr1
	 *            数组2
	 * @return 新的数组
	 */
	public static final <T> T[] mergeArray(T[] arr0, T[] arr1) {
		if (null == arr0 || null == arr1) {
			return null;
		}
		final int baseLen = null == arr0 ? 0 : arr0.length;
		final int addLen = null == arr1 ? 0 : arr1.length;
		T[] rs = Arrays.copyOf(arr0, baseLen + addLen);
		System.arraycopy(arr1, 0, rs, baseLen, addLen);
		return rs;
	}

	/**
	 * 合并两个数组
	 * 
	 * @param arr0
	 * @param arr1
	 * @return
	 */
	public static final byte[] mergeArray(byte[] arr0, byte[] arr1) {
		if (null == arr0 || null == arr1) {
			return null;
		}
		final int baseLen = null == arr0 ? 0 : arr0.length;
		final int addLen = null == arr1 ? 0 : arr1.length;
		byte[] rs = Arrays.copyOf(arr0, baseLen + addLen);
		System.arraycopy(arr1, 0, rs, baseLen, addLen);
		return rs;
	}

	/**
	 * 追加到数组
	 * 
	 * @param arr0
	 *            数组1
	 * @param item
	 *            数据
	 * @return 新的数组
	 */
	public static final <T> T[] append2Array(T[] arr0, T item) {
		if (null == arr0 || null == item) {
			return null;
		}
		final int baseLen = null == arr0 ? 0 : arr0.length;
		T[] rs = Arrays.copyOf(arr0, baseLen + 1);
		rs[rs.length - 1] = item;
		return rs;
	}

	/**
	 * 追加到数组
	 * 
	 * @param arr0
	 * @param item
	 * @return
	 */
	public static final byte[] append2Array(byte[] arr0, byte item) {
		if (null == arr0) {
			return null;
		}
		final int baseLen = null == arr0 ? 0 : arr0.length;
		byte[] rs = Arrays.copyOf(arr0, baseLen + 1);
		rs[rs.length - 1] = item;
		return rs;
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到末尾
	 * 
	 * @param arr
	 *            源数组
	 * @param startIndex
	 *            开始索引
	 * @return 新的数组
	 */
	public static final <T> T[] subArray(T[] arr, int startIndex) {
		return Arrays.copyOfRange(arr, startIndex, arr.length);
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到末尾
	 * 
	 * @param arr
	 *            源数组
	 * @param startIndex
	 *            开始索引
	 * @return 新的数组
	 */
	public static final byte[] subArray(byte[] arr, int startIndex) {
		return Arrays.copyOfRange(arr, startIndex, arr.length);
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到endIndex(不包括)位
	 * 
	 * @param arr
	 *            源数组
	 * @param startIndex
	 *            开始索引
	 * @param endIndex
	 *            结束索引(不包括)
	 * @return 新的数组
	 */
	public static final <T> T[] subArray(T[] arr, int startIndex, int endIndex) {
		return Arrays.copyOfRange(arr, startIndex, endIndex);
	}

	/**
	 * 分割一个字符串数组，获得一个新的字符串数组从startIndex位到endIndex(不包括)位
	 * 
	 * @param arr
	 *            源数组
	 * @param startIndex
	 *            开始索引
	 * @param endIndex
	 *            结束索引(不包括)
	 * @return 新的数组
	 */
	public static final byte[] subArray(byte[] arr, int startIndex, int endIndex) {
		return Arrays.copyOfRange(arr, startIndex, endIndex);
	}

	/**
	 * 反向
	 * 
	 * @param arr
	 *            源数组，数组会被修改。<br>
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
	 *            源二维数组
	 * @return 新的一维数组
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
