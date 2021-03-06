package src.leetcode.easy;

/**
 * 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca", "cba"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String same = "";
        String str = strs[0];
        for (int i = 0; i <= str.length() - 1; i++) {
            int countSame = 0;
            char a = str.charAt(i);
            for (int j = 0; j <= strs.length - 1; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != a) {
                    break;
                }
                countSame++;
            }
            if (countSame == strs.length) {
                same = same + a;
            } else {
                break;
            }
        }
        return same;
    }

}
