package perfectsearch;

// 프로그래머스 - 카펫
public class PsEx023 {

    public int[] solution(int brown, int yellow) {
        // 시간: O(√n), 공간: O(1)
        int total = brown + yellow;

        for (int height = 3; height * height <= total; height++) {
            if (total % height == 0) {
                int width = total / height;
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }

}
