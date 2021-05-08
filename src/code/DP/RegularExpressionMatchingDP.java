package code.DP;

public class RegularExpressionMatchingDP {
    public boolean isMatch(String s, String p) {
        boolean[][] T = new boolean[s.length() + 1][p.length() + 1];

        T[0][0] = true;

        // i > 0 时， T[i][0]都为false，因为s内任意一个字符与空字符匹配都为false
        // 需要处理T[0][i] 情况，即a*, a*b*, a*b*c*这样的
        for(int j = 1; j < T[0].length; ++j) {
            if(p.charAt(j - 1) == '*') {
                T[0][j] = T[0][j - 2];
            }
        }

        for(int i = 1; i < T.length; ++i) {
            for(int j = 1; j < T[0].length; ++j) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    T[i][j] = T[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    T[i][j] = T[i][j - 2];
                    if(p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        T[i][j] = T[i - 1][j] || T[i][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }

        return T[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatchingDP dp = new RegularExpressionMatchingDP();
        String s = "ab";
        String p = ".*";
        System.out.println(dp.isMatch(s, p));
    }
}
