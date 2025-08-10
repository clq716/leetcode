package leetcode.editor.cn.oldcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ASUS
 * @date 2025/8/10 星期日11:04
 */

public class Test {
	public static void main(String[] args) {
		TreeSet<Long> treeSet = solution(0l);
		int i = 0;
		long start = System.currentTimeMillis();
		for (Long l : treeSet) {
			i++;
			System.out.println(l);
		}
		System.out.println(i);
		System.out.println(System.currentTimeMillis() - start);
	}

	public static TreeSet<Long> solution(long n) {
		char[][] odds = new char[][]{
				{},
				{'3'},
				{'5', '5'},
				{'7','7','7'},
				{'9','9','9','9'}
		};
		char[][] evens = new char[][]{
				{'2'},
				{'4','4'},
				{'6','6','6'},
				{'8','8','8','8'}
		};
		TreeSet<Long> set = new TreeSet<>();
		for (char[] odd : odds) {
			f(odd, set);
			for (int i = 0; i < evens.length; i++) {
				f(odd, set, evens[i]);
				for (int j = i+1; j < evens.length; j++) {
					f(odd, set, evens[i], evens[j]);
					for (int k = j+1; k < evens.length; k++) {
						f(odd, set, evens[i], evens[j], evens[k]);
					}
				}
			}
		}
		return set;
	}

	private static void f(char[] odd, TreeSet<Long> set, char[]... evens) {
		List<Character> list = new ArrayList<>();
		for (char[] even : evens) {
			for (char ev : even) list.add(ev);
			if (list.size() > 7) return;
		}
		for (char od : odd) list.add(od);
		if (list.size() > 7) return;
		char od = odd.length == 0 ? ' ' : odd[0];
		for (int i = 0; i < list.size(); i++) {
			List<Character> l = new ArrayList<>(list);
			revert(l.remove(i), l, set, od, new StringBuilder());
		}
	}

	private static void revert(char ch, List<Character> list, TreeSet<Long> set, char od, StringBuilder builder) {
		builder.append(ch);
		if (list.isEmpty()) {
			String s = builder.toString();
			if (od == ' ') {
				String s1 = s + "1" + new StringBuilder(builder).reverse();
				set.add(Long.parseLong(s1));
			} else {
				s += od;
			}
			s += builder.reverse();
			set.add(Long.parseLong(s));
		} else {
			for (int i = 0; i < list.size(); i++) {
				List<Character> l = new ArrayList<>(list);
				revert(l.remove(i), l, set, od, new StringBuilder(builder));
			}
		}
	}
}
