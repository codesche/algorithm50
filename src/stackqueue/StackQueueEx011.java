package stackqueue;

import java.util.*;

// 프로그래머스 - 주식가격
public class StackQueueEx011 {
    public int[] solution(int[] prices) {
        // 시간: O(n), 공간: O(n)
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }
}
