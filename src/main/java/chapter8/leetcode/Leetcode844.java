package chapter8.leetcode;

import java.util.Stack;

/**
 * @author youyu.song
 * @date 2020/9/5 21:06
 */
public class Leetcode844 {

    public boolean backspaceCompare(String S, String T) {
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < sChar.length; i ++) {
            char c = sChar[i];
            if (c == '#' &&  !sStack.isEmpty()) {
                sStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }

        for (int j = 0; j < tChar.length; j ++) {
            char c = tChar[j];
            if (c == '#' &&  !tStack.isEmpty()) {
                tStack.pop();
            } else if (c != '#') {
                tStack.push(c);
            }
        }

        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        if ((!sStack.isEmpty() && tStack.isEmpty()) || (sStack.isEmpty() && !tStack.isEmpty())) {
            return false;
        }

        return true;
    }

}
