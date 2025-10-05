package greedy;

// 프로그래머스 - 조이스틱
public class PsEx027 {
    public int solution(String name) {
        // 시간: O(n^2), 공간: O(1)
        int answer = 0;
        int n = name.length();
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            minMove = Math.min(minMove, i + i + n - next);
            minMove = Math.min(minMove, (n - next) * 2 + i);
        }

        return answer + minMove;
    }
}
