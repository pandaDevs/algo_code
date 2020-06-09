package code;

public class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < strs.length; ++i) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] str = new String[] {"flower","flow","flight"};
        LongestCommonPrefix2 prefix = new LongestCommonPrefix2();
        String ret = prefix.longestCommonPrefix(str);
        System.out.println(ret);
    }
}
