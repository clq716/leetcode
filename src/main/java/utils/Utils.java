package utils;

public class Utils {

    /**
     * [1,2,3] 类型字符串转数组
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

}
