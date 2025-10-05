package greedy;

import java.util.*;

// 프로그래머스 - 체육복 (Set 활용)
public class PsEx026_2 {

    // 시간 O(n log n) (Set 삽입/삭제 포함), 공간: O(n)
    public int solution(int n, int[] lost, int[] reserve) {
        // 중복/겹침 정리: 여분이 있는데 본인이 잃어버린 경우 먼저 제거
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) {
            lostSet.add(l);
        }

        for (int r : reserve) {
            if (lostSet.contains(r)) {
                // 본인이 도난 + 여분 보유 -> 자기 것 사용 후 둘 다 제외
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }

        // 빌려주기: 번호 작은 쪽 우선(왼쪽 -> 오른쪽)
        for (int l : new TreeSet<>(lostSet)) {      // 정렬하여 순차적으로 처리
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                lostSet.remove(l);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                lostSet.remove(l + 1);
            }
        }

        return n - lostSet.size();
    }

}
