package sort;

import java.util.*;

// 프로그래머스 - 구명보트
public class SortEx019 {
    public int solution(int[] people, int limit) {
        // 몸무게가 가장 작은 사람이 앞에 배치됨
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}
