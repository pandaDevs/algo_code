package code.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) {
            return "";
        }

        int length = strs.length;
        int minLen = Integer.MAX_VALUE;
        for(String s : strs) {
            if(s.length() < minLen) {
                minLen = s.length();
            }
        }

        int prefixLen = 0;
        boolean equal = true;
        for(int i = 0; i < minLen && equal; ++i) {
            char c = ' ';
            for(String s : strs) {
                char word = s.charAt(i);
                if(c != ' ' && word != c) {
                    equal = false;
                    break;
                }
                c = word;
            }
            if(equal) {
                prefixLen++;
            }
        }

        if(prefixLen == 0) {
            return "";
        } else {
            return strs[0].substring(0, prefixLen);
        }
    }

    public static void main(String[] args) {
        String[] str = new String[] {"flower","flow","flight"};
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String ret = prefix.longestCommonPrefix(str);
        System.out.println(ret);
    }
}
