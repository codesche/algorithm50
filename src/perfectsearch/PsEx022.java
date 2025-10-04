package perfectsearch;

import java.util.*;

// 프로그래머스 - 소수 찾기
public class PsEx022 {
    private final Set<Integer> numberSet = new HashSet<>();

    // 시간: O(n! * √m), 공간: O(n!) - m: 생성 가능한 최대 수
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void dfs(String current, String numbers, boolean[] visited) {
        if (!current.isEmpty()) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
