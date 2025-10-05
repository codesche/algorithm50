package perfectsearch;

import java.util.*;

// 프로그래머스 - 전력망을 둘로 나누기
// 시간 O(n^2), 공간: O(n)
public class PsEx025 {

    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }

            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, graph, visited);
            answer = Math.min(answer, Math.abs(count - (n - count)));

        }

        return answer;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }

}
