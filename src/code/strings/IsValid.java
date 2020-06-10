package code.strings;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if(null == s || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            if(stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if(ch == ')' && top != '(') {
                return false;
            }
            if(ch == ']' && top != '[') {
                return false;
            }
            if(ch == '}' && top != '{') {
                return false;
            }
        }
        return stack.empty();
    }
}
