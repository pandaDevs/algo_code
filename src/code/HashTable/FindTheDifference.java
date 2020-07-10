package code.HashTable;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
            charCode += t.charAt(i) - s.charAt(i);
        }
        return charCode;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        FindTheDifference diff = new FindTheDifference();
        char ret = diff.findTheDifference(s,t);
        System.out.println(ret);
    }
}
