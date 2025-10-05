package greedy;

// 프로그래머스 - 체육복
public class GDEx026 {

    // 시간: O(n), 공간: O(n)
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];

        // 여분
        for (int r : reserve) {
            clothes[r]++;
        }

        // 도난
        for (int l : lost) {
            clothes[l]--;
        }

        int attend = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == -1) {
                // 왼쪽 먼저 시도
                if (clothes[i - 1] == 1) {
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if (clothes[i + 1] == 1) {       // 오른쪽 먼저 시도
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }

            if (clothes[i] >= 0) {          // 체육복 확보 시 참여 가능
                attend++;
            }
        }

        return attend;
    }

}
