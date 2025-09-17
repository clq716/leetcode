package leetcode.lingshen.a_double_point_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 * @date 2025/9/14 星期日16:41
 */

public class Test {
	public static void main(String[] args) throws IOException {
		String kindStr = "物理通用型\t粗制\t厚重\t锋利\t熟练\t游魂\t火焰\t混沌\t暗\t幽邃\t结晶\t雷电\t毒\t血\t愚人\t祝福";
		String[] kinds = kindStr.split("\t");
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		List<Weapon> weapons = new ArrayList<>();
		String type = null;
		for (String line : lines) {
			if (line.contains("、")) {
				type = line.split("、")[1];
				continue;
			}
			String[] s1 = line.split("：");
			Weapon weapon = new Weapon();
			weapon.type = type;
			weapons.add(weapon);
			List<String> ks = new ArrayList<>();
			weapon.ks = ks;
			weapon.name = s1[0].trim();
			String[] kis = s1[1].split("/");
			o: for (String kind : kinds) {
				for (String k : kis) {
					if (!kindStr.contains(k.trim())) System.out.println("未知:" + k);
					if (k.trim().equals(kind)) {
						ks.add(kind);
						continue o;
					}
				}
				ks.add("");
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Weapon weapon : weapons) {
			builder.append(weapon.type).append(",");
			builder.append(weapon.name).append(",");
			if (weapon.ks.get(0).equals("物理通用型")) {
				weapon.ks.set(1, "粗制");
				weapon.ks.set(2, "厚重");
				weapon.ks.set(3, "锋利");
				weapon.ks.set(4, "熟练");
			}
			builder.append(weapon.ks.stream().collect(Collectors.joining(",")));
			builder.append("\n");
		}
		Files.writeString(Paths.get("D:\\Game\\DarkSoul3\\weapons.csv"), builder, Charset.forName("gbk"));
	}

	static class Weapon {
		String type;
		String name;
		List<String> ks;
	}

	static String filePath = "D:\\Game\\DarkSoul3\\weapons.txt";

}
