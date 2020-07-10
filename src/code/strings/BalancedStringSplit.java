package code.strings;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int equal = 0;
        int count = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'L') {
                equal++;
            } else {
                equal--;
            }
            if(equal == 0) {
                count++;
            }
        }

        return count;
    }
}
