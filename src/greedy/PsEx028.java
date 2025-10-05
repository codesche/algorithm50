package greedy;

import java.util.*;

public class PsEx028 {
    public String solution(String number, int k) {
        // 시간: O(n), 공간: O(n)
        Stack<Character> stack = new Stack<>();
        int toRemove = k;

        for (char digit : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < digit && toRemove > 0) {
                stack.pop();
                toRemove--;
            }
            stack.push(digit);
        }

        while (toRemove > 0) {
            stack.pop();
            toRemove--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
