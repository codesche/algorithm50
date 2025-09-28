package programmershash;

import java.util.*;

// 003: 프로그래머스 - 전화번호 목록
// 한 번호가 다른 번호의 접두어인 경우 false 반환
public class HashEx003 {
    // 해시셋 활용
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
