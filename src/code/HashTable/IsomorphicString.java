package code.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapStoT = new HashMap<>(256);
        Map<Character, Character> mapTtoS = new HashMap<>(256);
        for(int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(mapStoT.containsKey(sChar)) {
                char val = mapStoT.get(sChar);
                if(val != tChar) {
                    return false;
                }
            } else {
                mapStoT.put(sChar, tChar);
            }
            if(mapTtoS.containsKey(tChar)) {
                char val = mapTtoS.get(tChar);
                if(val != sChar) {
                    return false;
                }
            } else {
                mapTtoS.put(tChar, sChar);
            }
        }

        return true;
    }

    private boolean test(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; ++i) {
            if(set.contains(nums[i])) {
                return false;
            }

            set.add(nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        IsomorphicString judge = new IsomorphicString();
        boolean ret = judge.isIsomorphic(s,t);
        System.out.println(ret);
    }
}
