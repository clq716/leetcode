package leetcode.lingshen.a_double_point_1;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */

public class Test {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{30,60,90})));
	}
	private static int[] solution(int[] tempratures) {
		int n = tempratures.length;
		int[] ans = new int[n];
		o: for (int i = 0; i < n-1; i++) {
			int l = tempratures[i];
			int j = i+1;
			for (; j < n; j++) {
				int r = tempratures[j];
				if (r > l) break;
				if (j == n-1) continue o;
			}
			ans[i] = j - i;
		}
		return ans;
	}

}
