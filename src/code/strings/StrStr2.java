package code.strings;

public class StrStr2 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) {
            return 0;
        }

        if(null == haystack || haystack.isEmpty()) {
            return -1;
        }

        int i = 0;
        while (i < haystack.length() - needle.length() + 1) {
            boolean equal = true;
            for(int j = 0; j < needle.length(); ++j) {
                if(needle.charAt(j) != haystack.charAt(i + j)) {
                    equal = false;
                    break;
                }
            }
            if(equal) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String hy = "hello";
        String needle = "ll";

        StrStr2 strStr = new StrStr2();
        int ret = strStr.strStr(hy, needle);
        System.out.println(ret);
        hy.indexOf(needle);
    }
}
