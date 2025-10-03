package heap;

import java.util.*;

// 프로그래머스 - 야근 지수
// 시간: O(n log m), 공간: O(m) - m: works 배열 크기
public class HeapEx015 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if (max > 0) {
                pq.offer(max - 1);
                n--;
            }
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
