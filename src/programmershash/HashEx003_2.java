package programmershash;

import java.util.*;

// 003: 프로그래머스 - 전화번호 목록
// 한 번호가 다른 번호의 접두어인 경우 false 반환
public class HashEx003_2 {
    // 해시셋 활용
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
