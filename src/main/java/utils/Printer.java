package utils;

/**
 *
 * @author ASHES
 * @date 2026/7/2122:29
 */

public class Printer {
	public static void print(Object... args) {
		for (Object arg : args) {
			System.out.println(arg);
		}
	}
}
