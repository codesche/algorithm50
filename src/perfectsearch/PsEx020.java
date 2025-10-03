package perfectsearch;

// 프로그래머스 - 최소직사각형
// 시간: O(n), 공간: O(1)
public class PsEx020 {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.max(size[0], size[1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}
