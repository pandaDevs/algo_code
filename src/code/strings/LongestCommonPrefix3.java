package code.strings;

public class LongestCommonPrefix3 {
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int i, int j) {
        if(i == j) {
            return strs[i];
        }

        int mid = (i + j) / 2;
        String commonLeft = longestCommonPrefix(strs, i, mid);
        String commonRight = longestCommonPrefix(strs, mid + 1, j);
        return getPrefix(commonLeft, commonRight);
    }

    private String getPrefix(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        for(int i = 0; i < minLen; ++i) {
            if(left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, minLen);
    }

    public static void main(String[] args) {
        String[] str = new String[] {"flower","flow","flight"};
        LongestCommonPrefix3 prefix = new LongestCommonPrefix3();
        String ret = prefix.longestCommonPrefix(str);
        System.out.println(ret);
    }
}
