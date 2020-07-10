package code.strings;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 1) {
            return "1";
        }

        String val = countAndSay(n - 1);
        char pre = val.charAt(0);
        int count = 1;
        StringBuilder ret = new StringBuilder();
        for(int i = 1; i < val.length(); ++i) {
            if(val.charAt(i) == pre) {
                count++;
            } else {
                ret.append(count);
                ret.append(pre);
                pre = val.charAt(i);
                count = 1;
            }
        }

        ret.append(count);
        ret.append(pre);
        return ret.toString();
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        cas.countAndSay(5);
    }
}
