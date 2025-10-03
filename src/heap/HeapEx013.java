package heap;

import java.util.*;

// 프로그래머스 - 디스크 컨트롤러
public class HeapEx013 {

    public int solution(int[][] jobs) {
        // 시간: O(n log n), 공간: O(n)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;
        int idx = 0;
        int count = 0;
        int total = 0;

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
                count++;
            }
        }

        return total / jobs.length;
    }

}
