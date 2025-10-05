package greedy;

import java.util.*;

// 프로그래머스 - 단속카메라
// 시간: O(n log n), 공간: O(1)
public class PsEx030 {

    public int solution(int[][] routes) {
        // 예외 처리
        if (routes == null || routes.length == 0) {
            return 0;
        }

        // 진출 지점 기준 정렬 (오버플로우 방지)
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));       // a[1] 기준 오름차순 정렬

        // 첫 구간의 끝에 카메라 설치
        int answer = 1;
        int camera = routes[0][1];

        // 못 덮는 구간이 나오면 그 구간의 끝에 새 카메라
        for (int i = 1; i < routes.length; i++) {               // start > camera -> 미포함
            if (routes[i][0] > camera) {
                answer++;
                camera = routes[i][1];
            }
        }

        return answer;
    }

}
