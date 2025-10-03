package sort;

import java.util.*;

// 프로그래머스 - H-Index
// 시간: O(n log n), 공간: O(1)
public class SortEx018 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
