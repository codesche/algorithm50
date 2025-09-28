package programmershash;

import java.util.*;

// 002: 프로그래머스 - 폰켓몬
// N마리 폰켓몬 중 N/2 마리를 가져갈 수 있을 때, 최대 종류 수 구하기
public class HashEx002 {

    public int solution(int[] nums) {
        // 해시셋으로 중복 제거
        Set<Integer> types = new HashSet<>();
        for (int num : nums) {
            types.add(num);
        }

        int size = types.size();

        // 최대 N/2 마리 또는 종류 수 중 작은 값
        return Math.min(size, nums.length / 2);
    }

}
