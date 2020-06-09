package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInt {
    private static final List<Character> wordList = new ArrayList<>();
    private static final Map<Character, Integer> wordVal = new HashMap<>();
    static{
        wordList.add('I');
        wordVal.put('I', 1);
        wordList.add('V');
        wordVal.put('V', 5);
        wordList.add('X');
        wordVal.put('X', 10);
        wordList.add('L');
        wordVal.put('L', 50);
        wordList.add('C');
        wordVal.put('C', 100);
        wordList.add('D');
        wordVal.put('D', 500);
        wordList.add('M');
        wordVal.put('M', 1000);
    }

    public int romanToInt(String s) {
        if(null == s || s.length() == 0) {
            return 0;
        }

        int ret = 0;
        int i = 0;
        while(i < s.length()) {
            Character character = s.charAt(i);
            if((i + 1) < s.length()) {
                Character next = s.charAt(i + 1);
                if(wordList.indexOf(character) < wordList.indexOf(next)) {
                    int minus = wordVal.get(next) - wordVal.get(character);
                    ret += minus;
                    i += 2;
                    continue;
                }
            }

            ret += wordVal.get(character);
            i += 1;
        }

        return ret;
    }
}
