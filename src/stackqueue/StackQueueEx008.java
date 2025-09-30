package stackqueue;

import java.util.*;

// 프로그래머스 - 올바른 괄호
public class StackQueueEx008 {

    public boolean solution(String s) {
        // 시간: O(n), 공간: O(n)
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {        // 닫는 괄호가 아닌 경우 제거
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

}
