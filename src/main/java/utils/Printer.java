package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ASHES
 */

public class Printer {
	public static void print(Object... args) {
		if (args == null) {
			System.out.println("null");
			return;
		}
		for (Object arg : args) {
			if (arg == null) {
				System.out.println("null");
				continue;
			}
			if (arg.getClass().isArray()) {
				List<Object> list = new ArrayList<>();
				for (int i = 0; i < Array.getLength(arg); i++) list.add(Array.get(arg, i));
				System.out.println(list);

			}
			else System.out.println(arg);
		}
	}
}
