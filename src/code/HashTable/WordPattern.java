package code.HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(str == null) {
            return false;
        }
        String[] strList = str.split(" ");
        if(strList.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < strList.length; ++i) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(strList[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), strList[i]);
            }
            if(map2.containsKey(strList[i])) {
                if(!map2.get(strList[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                map2.put(strList[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
