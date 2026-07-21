package hot100.leetcode.editor.cn;

import java.util.*;

import static utils.Printer.print;

/**
 * 2026-07-21 22:36:31
 * Lenovo, Win11
 */
public class $_0049_字母异位词分组 {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			List<List<String>> ans = new ArrayList<>();
			Map<String, List<String>> map = new HashMap<>();
			for (String str : strs) {
				String key = compress(str);
				List<String> list = map.get(key);
				if (list == null) {
					list = new ArrayList<>();
					list.add(str);
					map.put(key, list);
				} else {
					list.add(str);
				}
			}
			map.forEach((k, v) -> ans.add(v));
			return ans;
		}

		/**
		 * 使用压缩的思想，把排序后的字符和字符数量组装成唯一KEY值
		 */
		private String compress(String str) {
			if (str.isEmpty()) return "";
			int[] compress = new int['z' + 1];
			for (char ch : str.toCharArray()) {
				compress[ch]++;
			}
			StringBuilder com = new StringBuilder();
			for (int i = 'a'; i <= 'z'; i++) {
				if (compress[i] != 0) {
					com.append((char) i).append(compress[i]);
				}
			}
			return com.toString();
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	/**
	 * 这个是灵神的解法，**直接使用排序后的字符串作为KEY值**
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> m = new HashMap<>();
		for (String s : strs) {
			// 把 s 排序，作为哈希表的 key
			char[] sortedS = s.toCharArray();
			Arrays.sort(sortedS);
			// 排序后相同的字符串分到同一组
			// computeIfAbsent：如果 key 不在哈希表中，则插入一个新的 ArrayList
			m.computeIfAbsent(new String(sortedS), _ -> new ArrayList<>()).add(s);
		}
		// 哈希表的所有 value 就是分组结果
		return new ArrayList<>(m.values());
	}

	static void main() {
		Solution solution = new $_0049_字母异位词分组().new Solution();
		// put your test code here
		//[["bdd"],["bat"],["nat","tan"],["ac"],["ate","eat","tea"],["bd"],["aac"],["bbd"],["aacc"],["bbdd"],["acc"]]
		print(solution);
	}
}