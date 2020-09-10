package chapter8.leetcode;

import java.util.Stack;

/**
 * @author youyu.song
 * @date 2020/9/6 21:35
 */
public class Leetcode682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < ops.length; i ++) {
            String s = ops[i];
            if (s.equals("+")) {
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                stack.push(pop);
                stack.push(pop + peek);
                result += (pop + peek);
            } else if (s.equals("C")) {
                Integer c = stack.pop();
                result -= c;
            } else if (s.equals("D")) {
                Integer d = stack.peek();
                Integer newD = d * 2;
                stack.push(newD);
                result += newD;
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
                result += num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = {"5","-2","4","C","D","9","+","+"};
        System.out.println(new Leetcode682().calPoints(s));
    }

}
