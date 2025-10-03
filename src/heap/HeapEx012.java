package heap;

import java.util.*;

// 프로그래머스 - 더 맵게
public class HeapEx012 {
    public int solution(int[] scoville, int K) {
        // 시간: O(n log n), 공간: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : - 1;

    }
}
