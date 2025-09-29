package programmershash;

import java.util.*;

// 프로그래머스 - 의상
public class HashEx004 {

    public int solution(String[][] clothes) {
        // 시간: O(n), 공간: O(n)
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);          // +1은 해당 종류를 입지 않는 경우
        }

        return answer - 1;
    }

}
