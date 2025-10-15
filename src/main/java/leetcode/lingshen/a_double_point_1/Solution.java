package leetcode.lingshen.a_double_point_1;

/**
 *
 * @author ASUS
 * @date 2025/9/26 星期五18:57
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(solution("3[a]2[bc]"));
	}

	private static String solution(String encoded) {
		StringBuilder builder = new StringBuilder();

		Deque<Character> deque = new ArrayDeque<>();
		String cnt = "";
		int c = 0;
		String prefix = "";
		for (char ch : encoded.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				deque.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				cnt += ch;
			} if (ch == '[') {
				c = Integer.parseInt(cnt);
				cnt = "";
				while (deque.isEmpty()) prefix += deque.pop();
			} else if (ch == ']') {
				String d = "";
				while (deque.isEmpty()) d += deque.pop();
				while (c-->0) {
					builder.append(d);
				}
			}
		}

		//dfs(encoded, builder);
		return builder.toString();
	}

	private static String dfs (String encoded, StringBuilder builder) {
		int head = encoded.indexOf('[');
		if (head == -1) {
			return encoded;
		}
		String child = getChild(encoded);


		int i = 0;
		for (; i < encoded.toCharArray().length; i++) {
			char ch = encoded.toCharArray()[i];
			if (ch >= 'a' && ch <= 'z') builder.append(ch);
			else break;
		}
		int count = cacuCount(encoded, i, head);
		String childStr = dfs(child, builder);
		while (count-->0) {
			builder.append(childStr);
		}
		return builder.toString();
	}

	private static String getChild(String encoded) {
		char[] chs = encoded.toCharArray();
		int cnt = 0, head = 0, tail = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '[') {
				if (cnt == 0) head = i;
				cnt++;
			}
			else if (chs[i] == ']') {
				cnt--;
				if (cnt == 0) {
					tail = i;
					break;
				}
			}
		}
		if (head == tail) return encoded;
		else return encoded.substring(head+1, tail);
	}

	private static int cacuCount(String encoded, int s, int head) {
		return Integer.parseInt(encoded.substring(s, head));
	}
}
