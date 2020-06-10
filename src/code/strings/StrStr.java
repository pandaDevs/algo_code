package code.strings;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) {
            return 0;
        }

        if(null == haystack || haystack.isEmpty()) {
            return -1;
        }

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for(int i = 0; i <= max; ++i) {
            if(haystack.charAt(i) != first) {
                while(++i <= max && haystack.charAt(i) != first);
            }

            if(i<=max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for(int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); ++k, ++j);

                if(j == end) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String hy = "hello";
        String needle = "ll";

        StrStr strStr = new StrStr();
        int ret = strStr.strStr(hy, needle);
        System.out.println(ret);
        hy.indexOf(needle);
    }
}
