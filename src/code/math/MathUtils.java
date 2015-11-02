package code.math;

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
	 * @param n
	 * @return
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
	 * @return
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
}
