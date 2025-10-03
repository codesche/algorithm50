package sort;

import java.util.*;

// 프로그래머스 - 가장 큰 수
// 시간: O(n log n), 공간: O(n)
public class SortEx017 {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 핵심 로직
        // 비교하는 두 숫자를 앞, 뒤로 번갈아가며 이어붙인 것을 기준으로 비교
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // // 0이 제일 앞일 경우 "000..." -> "0" 리턴
        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
