package chapter7.leetcode;

import java.util.Stack;

/**
 * @author youyu.song
 * @date 2020/9/5 13:33
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }

        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < c.length; i ++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
                continue;
            }
            // 若不是左括号但栈为空
            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.pop();
            char tmp;
            if (c[i] == ')') {
                tmp = '(';
            } else if (c[i] == '}') {
                tmp = '{';
            } else {
                tmp = '[';
            }

            if (tmp != pop) {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

}
