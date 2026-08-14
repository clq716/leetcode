package utils;

public class Utils {

    /**
     * [1,2,3] 类型字符串转int数组
     */
    public static int[] toArray(String str) {
        str = str.replace('[', ' ').replace(']', ' ').trim();
        if (str.isEmpty()) return new int[0];
        String[] sp = str.split(",");
        int[] arr = new int[sp.length];
        for (int i = 0; i < sp.length; i++) {
            if ("null".equals(sp[i].trim())) arr[i] = Integer.MIN_VALUE;
            else arr[i] = Integer.parseInt(sp[i].trim());
        }
        return arr;
    }

    /**
     * 字符串转char数组
     */
    public static char[] toCharArray(String str) {
        str = str.replace('[', ' ').replace(']', ' ').trim();
        if (str.isEmpty()) return new char[0];
        String[] sp = str.split(",");
        char[] arr = new char[sp.length];
        for (int i = 0; i < sp.length; i++) arr[i] = sp[i].charAt(1);
        return arr;
    }

    /**
     * 字符串转int二维数组
     */
    public static int[][] toSquareArray(String str) {
        if (str == null) return new int[0][0];
        str = trimSquareBracket(str);
        if ("[]".equals(str)) return new int[0][0];
        String[] sp = str.split("],\\[");
        int[][] arr = new int[sp.length][];
        for (int i = 0; i < sp.length; i++) arr[i] = toArray(sp[i]);
        return arr;
    }

    /**
     * 字符串转char二维数组
     */
    public static char[][] toSquareCharArray(String str) {
        if (str == null) return new char[0][0];
        str = trimSquareBracket(str);
        if ("[]".equals(str)) return new char[0][0];
        String[] sp = str.split("],\\[");
        char[][] arr = new char[sp.length][];
        for (int i = 0; i < sp.length; i++) arr[i] = toCharArray(sp[i]);
        return arr;
    }

    private static String trimSquareBracket(String str) {
        return str.replace("[[","[").replace("]]","]");
    }
}
