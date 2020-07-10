package code.HashTable;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int[] sList = new int[26];
        int[] tList = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sList[sChar - 'a'] = sList[sChar - 'a'] + 1;
            tList[tChar - 'a'] = tList[tChar - 'a'] + 1;
        }

        for(int i = 0; i < sList.length; ++i) {
            if(sList[i] != tList[i]) {
                return false;
            }
        }

        return true;
    }
}
