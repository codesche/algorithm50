package sort;

import java.util.*;

// 프로그래머스 - K번째수
// 시간: O(m * n log n), 공간: O(n) - m: commands 길이
public class SortEx016 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}
