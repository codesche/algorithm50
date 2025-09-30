package stackqueue;

import java.util.*;

// 프로그래머스 - 같은 숫자는 싫어
public class StackQueueEx007 {

    public int[] solution(int[] arr) {
        // 시간: O(n), 공간: O(n)
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

}
