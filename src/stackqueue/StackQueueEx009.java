package stackqueue;

import java.util.*;

// 프로그래머스 - 프로세스
public class StackQueueEx009 {

    public int solution(int[] priorities, int location) {
        // 시간: O(n^2), 공간: O(n)
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});       // 문제 조건
            pq.offer(priorities[i]);
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == pq.peek()) {
                answer++;
                pq.poll();
                if (current[0] == pq.peek()) {
                    return answer;
                }
            } else {
                queue.offer(current);
            }
        }

        return answer;
    }

}
