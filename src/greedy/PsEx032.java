package greedy;

import java.util.*;

public class PsEx032 {

    private int[] parent;

    // 시간: O(E log E), 공간: O(n) - E: 간선 수
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int edges = 0;

        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {
                answer += cost[2];
                edges++;
                if (edges == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }

}
