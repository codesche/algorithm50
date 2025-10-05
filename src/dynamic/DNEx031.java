package dynamic;

// 프로그래머스 - 정수삼각형
public class DNEx031 {
    public int solution(int[][] triangle) {
        // 시간: O(n^2), 공간: O(1)
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return triangle[0][0];
    }
}
