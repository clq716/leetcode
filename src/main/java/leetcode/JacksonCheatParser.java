package leetcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用 Jackson XML 反序列化 CheatEntry XML 的示例
 * 保存为 JacksonCheatParser.java 编译运行:
 * javac -cp jackson-dataformat-xml-2.15.2.jar:. JacksonCheatParser.java
 * java -cp jackson-dataformat-xml-2.15.2.jar:. JacksonCheatParser path/to/CE_DK4HD_sc.xml
 */
public class JacksonCheatParser {

	// LastState 支持属性和文本两种情况
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LastState {
		@JacksonXmlProperty(isAttribute = true, localName = "Value")
		public String valueAttr;

		@JacksonXmlProperty(isAttribute = true, localName = "RealAddress")
		public String realAddress;

		@JacksonXmlText
		public String textContent;

		public String getValue() {
			if (valueAttr != null && !valueAttr.isEmpty()) return valueAttr;
			if (textContent != null && !textContent.isEmpty()) return textContent.trim();
			return "";
		}

		@Override
		public String toString() {
			return "LastState[value=" + getValue() + ", realAddress=" + realAddress + "]";
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CheatEntry {
		@JacksonXmlProperty(localName = "ID")
		public String id;

		@JacksonXmlProperty(localName = "Description")
		public String description;

		@JacksonXmlProperty(localName = "ShowAsSigned")
		public String showAsSigned;

		@JacksonXmlProperty(localName = "VariableType")
		public String variableType;

		@JacksonXmlProperty(localName = "Address")
		public String address;

		@JacksonXmlProperty(localName = "DropDownListLink")
		public String dropDownListLink;

		@JacksonXmlProperty(localName = "GroupHeader")
		public String groupHeader;

		@JacksonXmlProperty(localName = "LastState")
		public LastState lastState;

		// 对应 <CheatEntries><CheatEntry>...</CheatEntry></CheatEntries>
		@JacksonXmlElementWrapper(localName = "CheatEntries")
		@JacksonXmlProperty(localName = "CheatEntry")
		public List<CheatEntry> cheatEntries;

		// 有些 XML 也可能直接嵌套 CheatEntry 节点而不包在 CheatEntries 中
		@JacksonXmlElementWrapper(useWrapping = false)
		@JacksonXmlProperty(localName = "CheatEntry")
		public List<CheatEntry> directNestedCheatEntry;

		public List<CheatEntry> getChildren() {
			List<CheatEntry> out = new ArrayList<>();
			if (cheatEntries != null) out.addAll(cheatEntries);
			if (directNestedCheatEntry != null) out.addAll(directNestedCheatEntry);
			return out;
		}

		@Override
		public String toString() {
			return "CheatEntry{id=" + id + ", desc=" + description + "}";
		}
	}

	// 扁平化树结构为列表
	private static void flatten(CheatEntry root, List<CheatEntry> out) {
		out.add(root);
		for (CheatEntry c : root.getChildren()) {
			flatten(c, out);
		}
	}

	// 将 LastState.value 按空格或逗号分割
	private static List<String> splitLastState(String raw) {
		if (raw == null) return List.of();
		String s = raw.trim();
		if (s.isEmpty()) return List.of();
		return List.of(s.replace(",", " ").split("\\s+"));
	}

	// 输出 Markdown 表格
	private static void printMarkdown(List<CheatEntry> rows) {
		List<String> headers = List.of("姓名", "ID", "所属势力", "生命", "魔法", "攻击", "防御", "速度", "VariableType", "Address", "RealAddress", "原始LastState");
		System.out.println("| " + String.join(" | ", headers) + " |");
		System.out.println("|" + headers.stream().map(h -> "---").collect(Collectors.joining("|")) + "|");

		for (CheatEntry r : rows) {
			String name = r.description == null ? "" : r.description.replaceAll("^\"|\"$", "");
			String rawLast = r.lastState == null ? "" : r.lastState.getValue();
			List<String> vals = splitLastState(rawLast);
			String faction = vals.size() > 0 ? vals.get(0) : "";
			String hp = vals.size() > 1 ? vals.get(1) : "";
			String mp = vals.size() > 2 ? vals.get(2) : "";
			String atk = vals.size() > 3 ? vals.get(3) : "";
			String def = vals.size() > 4 ? vals.get(4) : "";
			String spd = vals.size() > 5 ? vals.get(5) : "";

			List<String> cells = List.of(
					escapePipe(name),
					escapePipe(r.id),
					escapePipe(faction),
					escapePipe(hp),
					escapePipe(mp),
					escapePipe(atk),
					escapePipe(def),
					escapePipe(spd),
					escapePipe(r.variableType),
					escapePipe(r.address),
					escapePipe(r.lastState == null ? "" : r.lastState.realAddress),
					escapePipe(rawLast)
			);
			System.out.println("| " + String.join(" | ", cells) + " |");
		}
	}

	private static String escapePipe(String s) {
		if (s == null) return "";
		return s.replace("|", "\\|");
	}

	// 主程序
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.err.println("Usage: java JacksonCheatParser path/to/CE_DK4HD_sc.xml");
			System.exit(1);
		}
		File xmlFile = new File(args[0]);
		XmlMapper mapper = new XmlMapper();

		// 反序列化为根 CheatEntry（样例 XML 根为单个 CheatEntry）
		CheatEntry root = mapper.readValue(xmlFile, CheatEntry.class);

		// 扁平化并过滤掉没有 Description 的容器节点（可按需调整）
		List<CheatEntry> flat = new ArrayList<>();
		flatten(root, flat);

		// 可选：只保留有 Description 或有 LastState 的条目
		List<CheatEntry> rows = flat.stream()
				.filter(e -> (e.description != null && !e.description.isBlank()) || (e.lastState != null && e.lastState.getValue() != null && !e.lastState.getValue().isBlank()))
				.collect(Collectors.toList());

		// 输出 Markdown 表格
		printMarkdown(rows);
	}
}
